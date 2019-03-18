package ru.sstu.lessons.lesson18;

public class UserView {

    private String name;
    private double salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public UserView(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "UserView{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
