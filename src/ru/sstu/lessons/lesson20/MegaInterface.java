package ru.sstu.lessons.lesson20;

public interface MegaInterface {

    @SecurityAnnotation(level = {"SuperAdmin"})
    public void mA();

    @SecurityAnnotation(level = {"SuperAdmin", "Admin"})
    public void mB();

    @SecurityAnnotation(level = {"SuperAdmin", "Admin", "User"})
    public void mC();

    public void mD();
}
