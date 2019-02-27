package ru.sstu.lessons.lesson11;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        try {

            //байтовый поток для чтения
            FileInputStream fb = new FileInputStream("test.txt");
            int b = fb.read();
            while (b != -1) {
                System.out.print((char) b);
                b = fb.read();//чтение одного символа
            }
            fb.close();

            //байтовый поток для записи в файл
            FileOutputStream fout = new FileOutputStream("t1.txt");
            fout.write("Hello".getBytes());//запись массива байт
            fout.write("Hello11".getBytes());//запись массива байт
            fout.write(65);
            fout.close();//закрытие потока


        } catch (FileNotFoundException ex) {
            System.out.println("file not found");
        } catch (IOException e) {
            System.out.println("errro io");
        }
//Указываем источник для Scanner потоко
//        try {
//            Scanner sc = new Scanner(new FileReader("test.txt"));
//            sc.nextInt();
//            sc.nextInt();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

        //символьный поток для чтения построчно
        try (BufferedReader bf = new BufferedReader(new FileReader("test.txt"))) {
 //символьный поток для чтения построчно
 //чтение по очереди строк из двух файлов
//            try (BufferedReader bf2 = new BufferedReader(new FileReader("t1.txt"))) {
////                String s = bf.readLine();
////                String s2 = bf2.readLine();
////                System.out.println(s+" ||| "+s2);
////            }

            String s;
            while ((s = bf.readLine()) != null) {
                System.out.println(s.length() + "\t- " + s);//построчное чтение
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        //символьный поток для записи построчно
        try (PrintWriter out = new PrintWriter(new FileWriter("t2.txt"))) {
            out.println((byte) 5);
            out.println(new Object());
        } catch (IOException ex) {

        }
//
//        System.in;//стандартный поток ввода
//        System.out;//стандартный поток вывода
//        System.err;//стандартный поток ошибок
        System.err.println("erroor!!!!");
        PrintStream outConsole = System.out;
        System.setOut(new PrintStream(new FileOutputStream("out.txt", true)));//изменеите стандартного
        System.out.println("message!!!!");

        System.setOut(outConsole);
        System.out.println("11234355");


        //чтение с другой кодировкой
        try (BufferedReader read = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("test.txt"), "cp1251"))) {

            String s;
            while ((s = read.readLine()) != null) {
                System.out.println(s.length() + "\t- " + s);
            }

        }

        //запись с другой кодировкой
        try (PrintWriter out = new PrintWriter(
                new OutputStreamWriter(
                        new FileOutputStream("cp.txt"), "cp1251"))) {
            out.println("cp1251");
            out.println("Привет, юзер!!!!");
        }

        //список доступных кодировок
        Charset charset = Charset.defaultCharset();
        System.out.println(charset);
        for (Map.Entry<String, Charset> entry : Charset.availableCharsets().entrySet()) {
            System.out.println(entry.getKey());
        }

        User u = new User("Ivan", 18, 10000);
        u.setU(u);
        System.out.println(u);

        //поток для сериализации объектов
        try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream("user.dat"))) {
            stream.writeInt(10);//запись int
            stream.writeInt(5);//запись int
            stream.writeObject(u);//запись user
        }

        //поток для десериализации объектов
        try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream("user.dat"))) {
            int i1 = stream.readInt();//чтение int
            int i2 = stream.readInt();//чтение int
            User u1 = (User) stream.readObject();//чтение user
            System.out.println(i1 + " " + i2);
            System.out.println(u1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
