package ru.sstu.lessons.lesson6;
//абстрактный класс - может содержать абстрактные методы
public abstract class User {
    private String name;
    private int age;

    //про модификаторы доступа
    private double salary;//private - доступ только внутри класса
    String gender;// по умолчанию (пакетный) - доспут в классах одного пакета
    protected int height; //protected - доспут в классах одного пакета и в наследниках
    public int weight;//public - доступ в любом классе

    public User() {
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

    void setGender(String g) {
        this.gender = g;
    }

    public String toShortString() {
        return name + " " + age;
    }

    public String toString() {
        String result = name + " "
                + age + "y $" + salary;
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    void addSalary(double per) {
        salary = salary * per / 100 + salary;
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

//    public void job(){
//        System.out.println("Что-то делает");
//    }

    //если реализация метода не известна
    //то метод необходимо сделать абстрактным
    //реадизация метода ложится на классы-наследники
    public abstract void job();
}
