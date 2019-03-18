package ru.sstu.lessons.lesson18;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        System.out.println("Lambda expressions");

        SumExpression sum = new SumExpression();
        DivExpression div = new DivExpression();

        //анонимный класс
        Expression e = new Expression() {
            @Override
            public void calc(int a, int b) {
                int c = a + 2 * b;
                System.out.println(c);
            }
        };

        //лямбда выражение
        Expression e1 = (int x, int y) -> System.out.println(x + 2 * y);
        Expression e2 = (int x, int y) -> {
            int a1 = x * x;
            int b1 = y * y;
            System.out.println(b1 + a1);
        };

        calculator(1, 3, sum);
        calculator(1, 3, div);
        calculator(1, 3, e);//передача перемееной типа лямбда
        calculator(1, 3, e1);
        calculator(1, 3, e2);
        calculator(1, 2, (x, y) -> System.out.println("a,b=" + x + y));//передача в метод вырежения

        calculator(1, 3, Math::max);//передача в медот другой метод

        ArrayList<String> strings = new ArrayList<>();
        strings.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        strings.add("123");
        strings.add("wqe");
        strings.add("qwe");
        strings.add("q");
        strings.add("sad");
        strings.add("qwes");
        strings.sort((x, y) -> y.compareTo(x));//сортировко по убыванию

        strings.forEach(x -> System.out.println(x));//перебор элементов

        int[] a = {2, 0, 0, 321, 3, 2, -31, 23, -4, 435, 4, 432, -54, 52, 35};
        printArr(a);
        printArrEven(a);
        printArrOdd(a);
        printArr(a, (x) -> true);
        printArr(a, (x) -> x % 2 == 0);
        printArr(a, (x) -> x % 3 == 0 && x % 5 != 0);
        printArr(a, (x) -> x % 5 == 0);
        printArr(a, Main::isNegative);
        printArr(a, Main::isPozitive);
        SumExpression test = new SumExpression();
        printArr(a, test::isZero);
        printArr(a, new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return Math.random() > 0.5;
            }
        });

        Integer[] massiv = {2, 0, 0, 321, 3, 2, -31, 23, -4, 435, 4, 432, -54, 52, 35};
        List<Double> doubles = Arrays.asList(massiv)//преобразование к списку
                .stream()//получение потока целых чисел
                .filter(x -> x > 0)//фильтрация потока
                .map(f -> Math.sqrt(f))//преобразование целого числа к его корню в веществвенном виде
                .collect(Collectors.toList());//преобразование потока в коллекцию
        doubles.forEach(System.out::println);

        List<User> users = new ArrayList<>();
        users.add(new User("Ivan", 21, 213));
        users.add(new User("Masha", 21, 13));
        users.add(new User("Petr", 21, 23));
        users.add(new User("Sidr", 251, 21));
        users.add(new User("Vasaya", 21, 23));

        List<UserView> views = users
                .stream()
                .map(x -> new UserView(x.getName(), x.getSalary()))
                .collect(Collectors.toList());
        views.forEach(System.out::println);
        views.forEach(x -> System.out.println(x));
        Runnable r = new Runnable() {
            @Override
            public void run() {

            }
        };
        //пример многопоточного программирования
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("xxxxxxx");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            }
        });
        thread.start();

        for (int i = 0; i < 100; i++) {
            System.out.println("---------");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e3) {
                e3.printStackTrace();
            }
        }
    }

    public static void calculator(int a, int b, Expression exp) {
        exp.calc(a, b);
    }

    public static boolean isPozitive(int x) {
        return x > 0;
    }

    public static boolean isNegative(int x) {
        return x < 0;
    }


    public static void printArr(int[] arr, Predicate<Integer> predicate) {
        for (int i = 0; i < arr.length; i++) {
            if (predicate.test(arr[i])) {//вызов переданного метода у лямда-выражения
                System.out.print(arr[i]);
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void printArrEven(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                System.out.print(arr[i]);
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    public static void printArrOdd(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                System.out.print(arr[i]);
                System.out.print(" ");
            }
        }
        System.out.println();
    }

}
