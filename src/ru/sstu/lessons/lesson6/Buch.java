package ru.sstu.lessons.lesson6;

public class Buch extends User {
    Buch(){
        super("Buch");
    }
    //реализация абстрактного метода
    @Override
    public void job() {
        System.out.println("Деньги");
    }
}
