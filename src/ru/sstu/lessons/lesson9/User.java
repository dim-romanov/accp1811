package ru.sstu.lessons.lesson9;

//Comparable форма для сортировки элементов
public class User implements Comparable<User> {

    private String name;
    private int age;
    private double salary;

    public User(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
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
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this == obj) return true;
        if (!(obj instanceof User)) return false;
        User u = (User) obj;
        //if (this.id==u.id) return true;
        if (!this.name.equals(u.name)) return false;
        if (this.age != u.age) return false;
        if (this.salary != u.salary) return false;

        return true;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

    //правило сортировки (по умолчанию)
    @Override
    public int compareTo(User o) {

        return this.name.compareTo(o.name);

    }
}
