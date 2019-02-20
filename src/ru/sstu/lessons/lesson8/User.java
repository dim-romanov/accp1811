package ru.sstu.lessons.lesson8;

//Класс Пользователь
public class User {

    String name;
    int age;
    double salary;

    User(String n) {
        name = n;
        age = 18;
        if (name == "aaa") {
            throw new IllegalArgumentException("Error user create");
        }
    }

    void setAge(int age) {
        if (age > 0 && age < 200) {
            this.age = age;
        }
        else {
            throw new IllegalArgumentException("Некоректный возраст");
        }
    }


}
