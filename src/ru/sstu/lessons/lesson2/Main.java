package ru.sstu.lessons.lesson2;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        System.out.println("Условия, циклы и массивы");

        //конструкция ветеления
//        if (булево значение) {
//            //if true
//        } else {
//            //else false
//        }

        //пример на определение знака числа
        int a = -1;
        if (a > 0) {
            System.out.println("positive");
        } else {
            System.out.println("zero or negative");
        }

        //пример на определение знака числа и нуля
        if (a > 0) {
            System.out.println("positive");
        } else {
            if (a == 0) {
                System.out.println("zero ");
            } else {
                System.out.println("negative");
            }
        }

        //пример на и/или
        a = 6;
        if (a == 1 || a == 3) {
            System.out.println("1");
        } else if (a >= 2 && a <= 5) {
            System.out.println("2");
        } else {
            System.out.println("3");
        }

        //if без else
        if (a == 0) {
            return;
        }

        //частный случай if
        //если точно известны значение а
        a = 1;
        switch (a) {
            default://выполняется когда ни один из case не сработал(может отсутствовать)
                System.out.println("ds");
                break;
            case 1:
            case 3:
                System.out.println("1s");
                break;
            case 2:
                System.out.println("2s");
                break;
        }

        //пожет работать со строками
        String s = "a";
        switch (s) {
            case "aa":
                break;
            case "a"://латинская
                break;
            case "а"://кириллическая
                break;
            case "A":
                break;
            case "aaa":
                break;
        }
        a = 1;
        if (a < 0) {
            a = 0;
        }
        a = a < 0 ? 0 : a;//тернарный оператор, эквивалет if выше


        //цикл со счетчиком от 0 до 10
        for (int i = 0; i < 10; i++) {
            if (i == 3) {
                System.out.println((i + 1) + ". Message 333333");
            } else {
                System.out.println((i + 1) + ". Message");
            }
        }
        //Пример цикла, который определяет
        // элемент следующего ряда:
        //1,2,4,8,16,32;
        int n = 100;
        for (int i = 0; i < n; i++) {
            System.out.print((double) Math.pow(2, i) + " ");
//            int r = (int) Math.pow(2, i);
//            if (r % 100 / 10 == 8) {
//                System.out.print(r + " ");
//            }
        }

        //цикл от -50 до 510
        for (int i = -50; i < 510; i++) {

        }

        //цикл от  50 до 2
        for (int i = 50; i > 2; i--) {

        }

        //цикл с условием
        while (true) {
            if (Math.random() < 0.1) {
                break;
            }
            System.out.println("1 ");
        }

        do {
            System.out.println("2 ");
            if (Math.random() > 0.1) {
                break;
            }
        } while (true);

        //объявление массива на 10 элементов
        int[] arr;
        arr = new int[10];

        //присвоение значений элементам массива
        arr[0] = 12;
        arr[9] = -12;

        //вывод на экран значений элементов массива
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        //заполнение по порядку
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        //заполнение случайным образом
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        //нахождение суммы элементов
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println("sum=" + sum);

        //подсчет количества элементов
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                count++;
            }
        }
        System.out.println("count zero = " + count);

        //поиск элементов
        int f = 4;
        boolean found = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == f) {
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("found");
        } else {
            System.out.println("Not found");
        }

        //получение результата в новый массив
        count = 0;
        int[] rArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 50 && arr[i] < 75) {
                rArr[count] = arr[i];
                count++;
            }
        }
        for (int i = 0; i < count; i++) {
            System.out.print(rArr[i] + " ");
        }
        System.out.println();

        //массивы большей размерности
        int[][] arr2 = new int[5][4];
        arr2[3][2] = 5;

        char[][] arr3 = new char[2][];
        arr3[0] = new char[3];
        arr3[1] = new char[2];
        arr3[0][0] = 3000;
        arr3[1][1] = 65;
        arr3[0][2] = 402;
        for (int i = 0; i < arr3.length; i++) {
            for (int j = 0; j < arr3[i].length; j++) {
                System.out.print(arr3[i][j] + " ");
            }
            System.out.println();
        }

        char h = Character.MAX_VALUE;
        for (int i = 0; i < 10000; i++, h++) {
            if (i % 1000 == 0) {
                System.out.println();
            }
            System.out.print(h);
        }
    }
}
