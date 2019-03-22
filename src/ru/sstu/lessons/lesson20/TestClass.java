package ru.sstu.lessons.lesson20;

public class TestClass {

    @SecurityAnnotation(level = {"SuperAdmin"})
    public void mA() {
        System.out.println("A");
    }
}
