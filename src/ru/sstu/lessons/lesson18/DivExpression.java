package ru.sstu.lessons.lesson18;

public class DivExpression implements Expression {
    @Override
    public void calc(int a, int b) {
        System.out.println(a - b);
    }
}
