package ru.sstu.lessons.lesson5;

//Класс менеджер
//Наследник класса Пользователь (дочерний)
public class Manager extends User {
    private double bonus;//поле Менеджера
    private int name = 1;

    Manager() {
        super("d");//вызов конструктора базового класса
        this.name=2;//обращение к полю класса манаджер
    }

    Manager(String name, int age, double salary, double bonus) {
        super(name, age, salary);//вызов конструктора базового класса
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    //переопределение метода базового класса
    //если необходимо заменить реализацию метода базоваого класса
    @Override
    public double getSalary() {
        //super.getSalary() вызов метода (не переопределенного) родительского класса
        //this.getSalary() вызов метода  класса менеджер
        return super.getSalary() + bonus;
    }

    //перегруженные метод
    //новый метод который должен отличаться количеством и типом аргументов
    //должен иметь схожую логику работы
    /**
     * @param kurs >0 <100
     * @return
     */
    public double getSalary(int kurs) {
        return kurs + 2;
    }

    //переопределенный метод
    @Override
    public String toString() {
        return super.toString()+" "+bonus;
    }
}
