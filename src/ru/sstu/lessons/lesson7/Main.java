package ru.sstu.lessons.lesson7;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abc";
        String s41 = "abcabc";
        String s3 = new String("Abc");

        System.out.println(s1 == s2);//ставние по ссылке
        System.out.println(s1 == s3);//ставние по ссылке
        System.out.println("equals: " + s1.equals(s3));//стравние по значению
        System.out.println("equalsIgnoreCase: " + s1.equalsIgnoreCase(s3));//стравние по значению игнорируя регистр

        String s4 = s1 + s2;
        System.out.println(s4 == s41);
        System.out.println(s4.equals(s41));

        String s5 = s1 + s2 + s1 + s2 + s1 + s4; //операция над строкой порождает новую строку

        String s = "";
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            s += Integer.toString(i);//операция над строкой порождает новую строку
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        StringBuilder sb = new StringBuilder();//класс для соединения строк
        sb.append(s1).append(s2).append(s1);
        String s6 = sb.toString();
        System.out.println(s6);

        sb = new StringBuilder();//класс для соединения строк
        start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            sb.append(i);//операция над строкой порождает новую строку
        }
        sb.insert(2, "aaa");//вставка в строку
        sb.delete(6, 8);//удаление из стороки
        s6 = sb.toString();
        end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(s6);

        String s7 = s1.concat(s2);//s1+s2;

        int l = s7.length();//длина строки
        System.out.println(l);
        char c1 = s7.charAt(l - 1);//обращение к символу по номеру
        System.out.println(c1);
        //работа со строкой как с массивом
        for (int i = 0; i < s7.length(); i++) {
            System.out.println(s7.charAt(i));//обращение к символу по номеру
        }

        char[] chars = s7.toCharArray();//преобразование сктроки в массив симолов
        chars[chars.length - 1] = '%';//обращение к символу по номеру
        String s8 = new String(chars);//преобразование массива символов в строку
        System.out.println(s7);
        System.out.println(s8);

        //обертки для примитивов
        //Character
        //Integer - int
        //Boolean
        //Float
        //Double
        //Long Byte Short
        String s9 = Integer.toString(11);
        int a = Integer.valueOf("1234");
        System.out.println(Integer.MAX_VALUE);


        String s10 = "Sys\ntem.out.prin.out.tln.out(Integer.MAX_VALUE);";
        System.out.println(s10.startsWith("system"));
        System.out.println(s10.endsWith(");"));
        System.out.println(s10.contains("out"));//поиск в строке
        System.out.println(s10.indexOf("out"));//поиск сначала строки
        System.out.println(s10.lastIndexOf("out"));//поиск c конца строки

        String s11 = s10.substring(8);//извлечение подстроки
        System.out.println(s11);

        int l1 = s10.indexOf("ut");
        String s12 = s10.substring(l1 + 2, l1 + 2 + 5);//извлечение подстроки
        System.out.println(s12);
        System.out.println(s10.toUpperCase());//в верхний регистр
        System.out.println(s10.toLowerCase());//в нижний регистр
        System.out.println("   21   ".trim());//удаление пробелов

        s10 = "Sys\n11.tem.out.prin.out.tln.out(Integer.MAX_VALUE);";
        String[] strings = s10.split("[\\.\\(\\s]");//разбиение на подстроки
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }
        System.out.println("------------------------");
        StringTokenizer tokenizer = new StringTokenizer(s10, ".(\n");
        while (tokenizer.hasMoreElements()) {
            Object t = tokenizer.nextElement();
            System.out.println(t.getClass());
        }

        //регулярные выражения
        String s13 = "56123aaaaaa45b6789";
        String s14 = s13.replace("56","aaa");
        String s15 = s13.replaceAll("[a-z]"," ");//заменить все каждую букву на пробел
        String s16 = s13.replaceAll("[a-z]+"," ");//заменить все группу подряд идущих букв на пробел
        System.out.println(s15);

//        String reg = "^(([12]\\d)|(3[01])|(0[1-9]))\\.((1[012])|(0[1-9]))\\.\\d{4}$"; //целая строка должна быть датой
        String reg = "(([12]\\d)|(3[01])|(0[1-9]))\\.((1[012])|(0[1-9]))\\.\\d{4}";//поиск даты
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher("wqeqw01.02.2019qwewqe11.22.2019");
        while (matcher.find()) {
            String t = matcher.group();
            System.out.println(t);
        }


    }
}
