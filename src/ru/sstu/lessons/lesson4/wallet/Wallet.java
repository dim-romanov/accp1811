package ru.sstu.lessons.lesson4.wallet;

public class Wallet {
    private Kupura[] kupuras;

    void addKupura(Kupura k){

    }

    void addKupura(Currency c,double count){
        Kupura k = new Kupura(c,count);
        addKupura(k);
    }

    double getSum(Currency c){
        if (c.getIso()==kupuras[0].getCurrency().getIso()){

        }
        return 0;
    }
}
