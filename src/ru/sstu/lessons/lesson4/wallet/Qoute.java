package ru.sstu.lessons.lesson4.wallet;

public class Qoute {
    private Currency basa;
    private Currency qoute;
    private double kurs;

    public String getReverKurs() {
        return qoute.getType() + "/"
                + basa.getType() + "="
                + (1 / kurs);

    }

    //rus/eur
    //rus/dol
    static Qoute[] qoutes = new Qoute[10];

    //eur/dol
    static double getKursByCurrency(Currency c1, Currency c2) {
        return 0;
    }


}
