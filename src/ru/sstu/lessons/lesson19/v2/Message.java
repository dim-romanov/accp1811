package ru.sstu.lessons.lesson19.v2;

import java.io.Serializable;


public class Message implements Serializable {
    String athour;
    String message;

    public Message(){}

    public Message(String athour, String message) {
        this.athour = athour;
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "athour='" + athour + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    public String getAthour() {
        return athour;
    }

    public void setAthour(String athour) {
        this.athour = athour;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
