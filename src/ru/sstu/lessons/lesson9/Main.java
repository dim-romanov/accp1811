package ru.sstu.lessons.lesson9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Коллекции");
        Book b = new Book();
        MyInterface m = b;
        Object o = b;
        methtod(b);

        //списки на массивах
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);//добавление в конец
        integers.add(3);
        integers.add(5);
        integers.add(6);
        integers.add(0);

        integers.set(1, -3);//добавление на позицию 1
        int a = integers.get(1);//получение из позиции 1

        int l = integers.size();//размер списка

        for (int i = 0; i < integers.size(); i++) {
            System.out.print(integers.get(i) + " ");
        }
        System.out.println();

        integers.add(1);
        integers.add(55);

        for (int i = 0; i < integers.size(); i++) {
            System.out.print(integers.get(i) + " ");
        }
        System.out.println();

        integers.add(1, 0);
        integers.add(0, 99);

        for (int i = 0; i < integers.size(); i++) {
            System.out.print(integers.get(i) + " ");
        }
        System.out.println();

        integers.remove(4);//удалить из 4 позиции
        integers.remove(new Integer(99));//удалить первый элемент со значением 99

        for (int i = 0; i < integers.size(); i++) {
            System.out.print(integers.get(i) + " ");
        }
        System.out.println();

        ArrayList<String> strings = new ArrayList<>();
        strings.add("a");
        strings.add("abc");
        strings.add("abcz");

        ArrayList<User> users = new ArrayList<>();
        User u = new User("Ivan", 18, 10000);
        users.add(u);
        users.add(new User("Masha", 18, 12000));
        users.add(new User("Petr", 18, 14000));
        users.add(new User("Ivan", 18, 16000));

        print(users);
        print(strings);
        users.remove(new User("Ivan", 18, 10000.5));//удаление пользователя
        System.out.println("-------------");
        print(users);

        //проверка на содержание элемента в списке
        if (users.contains(new User("Petr", 18, 10000))) {
            System.out.println("ok");
        } else {
            System.out.println("no");
        }
        //поиск пользователей с маленькой зп
        ArrayList<User> lowSalary = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            User u1 = users.get(i);
            if (u1.getSalary() < 15000) {
                lowSalary.add(u1);
            }
        }
        print(lowSalary);
        //увеличение зп на tax процентов
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int tax = Integer.valueOf(bf.readLine());
        for (int i = 0; i < lowSalary.size(); i++) {
            lowSalary.get(i).setSalary(lowSalary.get(i).getSalary() * (tax / 100. + 1));
        }
        System.out.println("---------");
        print(lowSalary);

        //двунаправленый двузвязный список
        LinkedList<Integer> list = new LinkedList<>();
        list.add(123);
        list.add(0, 3);
        list.addFirst(1);
        list.addLast(3);
        list.addAll(integers);
        print(list, false);

        //последовательный перебор элементов с помощью итератора
        Iterator<Integer> it = list.iterator();
        int sum = 0;
        while (it.hasNext()) {
            int t = it.next();
            // sum += t;
        }

        //последовательный перебор элементов с помощью foreach
        for (Integer i : list) {
            if (i % 2 == 0) {
                //list.add(5);
                System.out.println(i);
            }
        }

        //Collections.fill(list,5);
        //print(list, false);


        //сортаривка списка
        Collections.sort(list);
        print(list, false);

        print(users);
        int command = 0;
        switch (command) {
            case 0:
                Collections.sort(users);
                break;
            case 1:
                Collections.sort(users, new UserBySalaryComparator());//сортировка по зп
                break;
            case 2:
                Collections.sort(users, new UserComparator());//сортировка по зп и имени
                break;
        }
        System.out.println("-------------");
        print(users);


    }

    public static void print(List<?> list, boolean newLine) {
        if (newLine) print(list);
        else {
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
        }
    }

    public static void print(List<?> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public static void methtod(MyInterface m) {
        m.print();
    }

}
//[^,\.&&\W]