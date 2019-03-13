package ru.sstu.lessons.lesson16;

import java.util.Date;
import java.util.Objects;

public class User {
    private int id;
    private String name;
    private int age;
    private double salary;
    private Date dateCreate;

    public User()
    {

    }

    public User(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public User(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", date=" + dateCreate +
                '}';
    }
}
