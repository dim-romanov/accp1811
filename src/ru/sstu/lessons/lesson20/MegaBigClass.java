package ru.sstu.lessons.lesson20;

public class MegaBigClass implements MegaInterface {

//    @SecurityAnnotation(level = {"SuperAdmin"})
    public void mA() {
        System.out.println("A");
    }

//    @SecurityAnnotation(level = {"SuperAdmin", "Admin"})
    public void mB() {
        System.out.println("B");
    }

//    @SecurityAnnotation(level = {"SuperAdmin", "Admin", "User"})
    public void mC() {
        System.out.println("C");
    }

    @Override
    public void mD() {
        System.out.println("D");
    }
}
