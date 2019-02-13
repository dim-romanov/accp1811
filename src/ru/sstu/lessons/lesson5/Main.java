package ru.sstu.lessons.lesson5;

public class Main {
    public static void main(String[] args) {
        System.out.println("Наследование");

        Manager m = new Manager();
        System.out.println(m.toString());

        User u = new User("not",0,0);
        m.setBonus(10);
        System.out.println(m.getSalary());
        System.out.println(m.getSalary(2));
        System.out.println(m.toString());
        System.out.println(u.toString());
        System.out.println(u);

        System.out.println(m);




    }
}
