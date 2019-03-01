package ru.sstu.lessons.lesson12.entities;

import ru.sstu.lessons.lesson4.Document;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

//Comparable форма для сортировки элементов
public class User implements Serializable {

    private String name;
    private int age;
    private double salary;
    private int exp;

    private User u;

    public static final long serialVersionUID = 2;

    public User(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }



    public User getU() {
        return u;
    }

    public void setU(User u) {
        this.u = u;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                Double.compare(user.salary, salary) == 0 &&
                Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, salary);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", exp=" + exp +
                ", user=" + u.name +
                '}';
    }
}
