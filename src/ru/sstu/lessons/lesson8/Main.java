package ru.sstu.lessons.lesson8;

import java.io.*;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        System.out.println("Исключительные ситуации");
        try {
            FileHandler handler = new FileHandler("log.txt");//запись логов в файл
            ConsoleHandler console = new ConsoleHandler();//запись логов в консоль
            console.setFormatter(new ConsoleFormater());//собственный формат логов для консоли

            Logger.getLogger("my-logger").addHandler(handler);//назчение хендлера для логгера
            Logger.getLogger("my-logger").addHandler(console);//назчение хендлера для логгера
            Logger.getLogger("my-logger").setUseParentHandlers(false);//отключение стандартного хендлера
        } catch (IOException e) {
            e.printStackTrace();
        }

        //логгирование сообщений
        Logger.getLogger("my-logger").log(Level.SEVERE, "приложение старт");
        Logger.getLogger("my-logger").log(Level.INFO, "приложение старт");
        Logger.getLogger("my-logger").warning("File not found");

        //генерация и отлов сообщений
        try {
            int l = -1;
            int[] arr = new int[l];
            // int a = 4/0;
            Object o = null;
            String s = o.toString();
        } catch (ArithmeticException exp) {
            System.out.println("/ by zero" + exp.getMessage());
            exp.printStackTrace();
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("other error" + e.getMessage());
        }

        try {
            FileInputStream bf = new FileInputStream("file.txt");
        } catch (FileNotFoundException e) {

            Logger.getLogger("my-logger").warning("File not found");
        }
        //метод для получения числа из консоли
        int a = readInt();
        System.out.println(a);
        a = readInt();
        System.out.println(a);

        Util u = new Util();
        int b = u.readInt();

        try {
            //проброс ошибки
            method("test.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            //метод с собственной ошибкой
            int z = sum(5, -6);
            System.out.println(z);
        } catch (SumNegativeException e) {
            System.err.println(e.a + " " + e.b + " " + e.getMessage());
        }

        //блок finally выполняется в любом слючае
        FileInputStream bf = null;
        try {
            bf = new FileInputStream("file.txt");
            //error
            //

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bf != null) {
                    bf.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        methodA();

        int b1 = methodB();
        System.out.println("b1=" + b1);

        Logger.getLogger("my-logger").log(Level.FINE, "приложение стоп");
    }

    //тестирование fanally
    public static void methodA() {
        try {

            int a = 4 / 0;
            System.out.println("try");
            ;
        } catch (Exception e) {
            System.out.println("catch");
        } finally {
            System.out.println("finally");
        }
    }

    //тестирование fanally
    public static int methodB() {
        try {
            return 0;
        } catch (Exception e) {
            return 1;
        } finally {
            return -1;
        }
    }

    /**
     * метод с генерацией собственных исключений
     * @param a
     * @param b
     * @return
     */
    public static int sum(int a, int b) {
        if (a + b < 0) {
            throw new SumNegativeException("Некорректная сумма", a, b);
        }
        if (a + b == 5) {
            throw new IllegalStateException("Тоже ошикба");
        }
        return a + b;
    }

    //метод, который пробрасывает вверх исключения
    public static void method(String fileName) throws FileNotFoundException, NumberFormatException, ArrayIndexOutOfBoundsException {
        FileInputStream bf = new FileInputStream(fileName);
    }


    public static int readInt() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.print("Введите число: ");
                String s = bufferedReader.readLine();
                int a = Integer.valueOf(s);
                return a;
            } catch (IOException e) {
                System.out.println("error");
                return 0;
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод");
            }
        }
    }
}
