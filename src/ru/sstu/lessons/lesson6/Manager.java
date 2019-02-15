package ru.sstu.lessons.lesson6;


public abstract class Manager extends User {
    private double bonus;
    private int name = 1;

    Manager() {
        super("d");
        this.name = 2;
    }

    Manager(String name, int age, double salary, double bonus) {
        super(name, age, salary);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public double getSalary() {
        return super.getSalary() + bonus;
    }

    public double getSalary(int kurs) {
        return kurs + 2;
    }

    @Override
    public String toString() {
        return super.toString() + " " + bonus;
    }


}
