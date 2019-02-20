package ru.sstu.lessons.lesson8;

import java.io.IOException;

public class MyErrorException extends RuntimeException {
    public MyErrorException(String message) {
        super(message);
    }
}
