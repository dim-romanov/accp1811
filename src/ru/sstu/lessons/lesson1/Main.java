package ru.sstu.lessons.lesson1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //вывод на экран сообщений
        System.out.println("Hello World!");
        System.out.println("Hello");
        System.out.print("Hello \n");
        System.out.print("User");
        System.out.printf("User %.2f", 12.555);

        //объявление переменных целого типа
        int a = 123;
        long l = 12321000000l;
        short s = 155;
        byte b = 126;

        //объявление переменных вещественного типа
        float f = 1.3f;
        double d = 1.5;

        //объявление переменных символьного типа
        char c = '3';//Unicode
        char c1 = 21;
        System.out.println("Привет, мир!!!!");

        //объявление переменных логического типа
        boolean b1 = true;
        boolean b2 = false;

        System.out.println("B1 = " + b1);
        System.out.println("B2 = " + b2);
        System.out.println("B2 = " + b2 + " count: " + a);

        //Чтение с клавиатуры
        Scanner sc = new Scanner(System.in);
        String s23 = "hello";
        String s1 = sc.nextLine();//чтение строки
        int c3 = sc.nextInt();//чтение целого числа
        System.out.println("c3 = "+c3);
        float f1 = sc.nextFloat();//чтение вещественного числа
        System.out.println("Float = "+f1);

        //+,-,*,/,%
        double i1 = 5;
        double i2 = 0;
        double i3 = i1 / i2;
        System.out.println(i3);

        //>,<,<=,>=,!=,==

        boolean b3 = 5 > 6;
        System.out.println(b3);

        b3 = 5 < 6;
        System.out.println(b3);

        b3 = 5 == 6;
        System.out.println(b3);

        b3 = false == false;
        System.out.println(b3);

        //&&, ||, !
        b3 = false && true;
        System.out.println(b3);

        b3 = false || true;
        System.out.println(b3);

        //++,--
        int i4 = 6;
        ++i4;
        i4--;
        System.out.println(i4);

        int b22 = ++i4;
        System.out.println(b22 + " " + i4);

        //=,+=,-=,/=,*=,%=

        i4 += 0x5;
        i4 = i4 + 5;
        a = 2;

        int r2 = 5;
        float f2 = r2;

        r2 = (int)f2;
        //byte->short->int->long->float->double;

        double sqtr = Math.sqrt(9);
        double pow  = Math.pow(2,10);
        double value  = 2.5475;
        double r = Math.round(value*1000)/1000.0;//окргугление по правилам математики
        System.out.println(r);

        value  = 2.547;
        double r1 = Math.floor(value*100)/100.0;//округление к меньшему
        System.out.println(r1);

        value  = 2.441;
        double r22 = Math.ceil(value);//округление к большему
        System.out.println(r22);



    }
}
