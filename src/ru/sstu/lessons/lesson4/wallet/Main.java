package ru.sstu.lessons.lesson4.wallet;

public class Main {
    public static void main(String[] a) {
        Wallet w1 = new Wallet();
        w1.addKupura(new Kupura(Currency.currencies[0], 2));
        w1.addKupura(Currency.currencies[1], 22);
        double s= w1.getSum(Currency.currencies[2]);
    }
}
