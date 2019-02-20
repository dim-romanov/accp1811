package ru.sstu.lessons.lesson8;

public class SumNegativeException extends MyErrorException {
    int a;
    int b;

    public SumNegativeException(String message, int a, int b) {
        super(message);
        this.a = a;
        this.b = b;
    }

}
