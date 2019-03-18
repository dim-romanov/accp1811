package ru.sstu.lessons.lesson18;

public class SumExpression implements Expression {
    @Override
    public void calc(int a, int b) {
        int c = a + b;
        System.out.println(c);
    }

    public boolean isZero(int x) {
        return x == 0;
    }
}
