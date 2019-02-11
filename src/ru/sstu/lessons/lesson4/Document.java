package ru.sstu.lessons.lesson4;

public class Document {
    private String type;
    private String number;

    public Document(String type, String number) {
        this.number = number;
        this.type = type;
    }

    String getInfo() {
        return type + " №" + number;
    }

    public String getNumber() {
        return number;
    }
}
