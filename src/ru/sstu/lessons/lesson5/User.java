package ru.sstu.lessons.lesson5;

//Класс Пользователь
//Базовый класс (радительский)
public class User {
    private String name;
    private int age;
    private double salary;
    private String gender;

    void setGender(String g) {
        this.gender = g;
    }


    User() {
        name = "неопределено";
        age = 18;
        salary = 1;
    }

    User(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    User(String n) {
        name = n;
        age = 18;
        if (name == "aaa") {
            System.out.println("error");
        }
    }

    public String toShortString() {
        return name + " " + age;
    }

    //переопределение медота класса Object
    //формирует строковое представление объекта
    public String toString() {
        String result = name + " "
                + age + "y $" + salary;
        return result;
    }

    void addSalary(double per) {
        salary = salary * per / 100 + salary;
    }

    User createDublicate() {
        User t = new User(this.name, this.age, this.salary);
        return t;
    }

    void setAge(int age) {
        if (age > 0 && age < 200) {
            this.age = age;
        }
    }

    int getAge() {
        return this.age;
    }

    public double getSalary() {
        return salary;
    }
}
