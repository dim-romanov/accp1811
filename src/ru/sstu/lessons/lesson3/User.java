package ru.sstu.lessons.lesson3;

//Класс Пользователь
public class User {
    //поля класса (характеристика пользователя)
    String name;//имя
    int age;//возраст
    double salary;//з/п

    //скрытые поля (используем private перед типом )
//    private String name;
//    private int age;
//    private double salary;


    //конструкторы

    /**
     * Конструктор без параметров
     * Необходим для задания полям значений по умолчанию
     */
    User() {
        // this("неопределено",18,1);
        name = "неопределено";
        age = 18;
        salary = 1;
    }

    /**
     * Конструктор, устанавливающий все значения
     *
     * @param name   имя пользователя
     * @param age    возраст
     * @param salary з/п
     */
    User(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    /**
     * конструктор, устанавливающий только имя пользователя
     *
     * @param n имя пользователя
     */
    User(String n) {
        this();
        name = n;
        age = 18;
        if (name == "aaa") {
            System.out.println("error");
        }
    }

    /**
     * Конструктор принимающий только целое число
     * Для примера
     *
     * @param i
     */
    User(int i) {

    }
    //методы

    /**
     * Возвращает информацию о пользователе
     *
     * @return информация
     */
    String getInfo() {
        String result = name + " "
                + age + "y $" + salary;
        return result;
    }

    /**
     * Увеличение
     *
     * @param per
     */
    void addSalary(double per) {
        salary = salary * per / 100 + salary;
    }

    /**
     * Создание дукликата объекта
     * @return копия объекта
     */
    User createDublicate() {
        User t = new User(this.name, this.age, this.salary);
        return t;
    }

    /**
     * Установка нового возраста для пользователя
     * Если новый возраст не попадает в диапазон,
     * то установка не производится
     * @param age новый возраст
     */
    void setAge(int age) {
        if (age > 0 && age < 200) {
            this.age = age;
        }
    }

    /**
     * Возращает возраст пользователя
     * @return
     */
    int getAge() {
        return this.age;
    }
}
