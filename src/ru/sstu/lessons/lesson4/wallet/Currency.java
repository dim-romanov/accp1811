package ru.sstu.lessons.lesson4.wallet;

public class Currency {
    private String type;
    private char sym;
    private int iso;

    public String getType() {
        return type;
    }

    public int getIso() {
        return iso;
    }

    public Currency(String type) {
        this.type = type;
    }

    static Currency[] currencies = new Currency[3];

    static {
        currencies[0] = new Currency("rub");
        currencies[1] = new Currency("eur");
        currencies[2] = new Currency("dol");
    }
}
