package ru.sstu.lessons.lesson9;

public class Printer implements MyInterface {
    @Override
    public void print() {
        System.out.println("print document");
    }

    @Override
    public int sum(int x1, int x2) {
        return (x2 + x1) / 2;
    }
}
