package ru.sstu.lessons.lesson6;

public class Employee extends User {

    //реализация абстрактного метода
    @Override
    public void job() {
        System.out.println("Вся работа");
    }

    public void service() {
        System.out.println("service");
    }
}
