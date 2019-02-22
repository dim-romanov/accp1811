package ru.sstu.lessons.lesson9;

import java.io.IOException;
import java.io.Serializable;

public class Book extends Object implements MyInterface,Runnable,Cloneable,Appendable,Serializable {
    @Override
    public void print() {
        System.out.println("Info book");
    }

    @Override
    public int sum(int x1, int x2) {
        return (x2 - x1) * 100;
    }

    @Override
    public Appendable append(CharSequence csq) throws IOException {
        return null;
    }

    @Override
    public Appendable append(CharSequence csq, int start, int end) throws IOException {
        return null;
    }

    @Override
    public Appendable append(char c) throws IOException {
        return null;
    }

    @Override
    public void run() {

    }
}
