package ru.sstu.lessons.lesson4;

//Класс Пользователь
public class User {
    //поля класса (характеристика пользователя)
    private String name;//имя
    private int age;//возраст
    private double salary;//з/п
    private String gender;
    private Document[] documents = new Document[10];//список документов пользователя
    private int docCount;

    /**
     * Статические переменные (общие переменные для всего класса в целом)
     */
    static int countUser;
    static final String GENDER_MALE = "MALE";//константа
    static final String GENDER_FEMALE = "FEMALE";//константа

    //блочный инициализатор
    //выполняется в момент создания объекта (до выполения конструктора)
    {
        System.out.println("Подгрузка инфромации для класса");
        System.out.println("Подгрузка инфромации для класса - 3");
        countUser++;
        //GENDER_FEMALE = "dsa";
    }

    //статичый блочный инициализатор
    //выполняется в момент первого обращения к классу или объекту
    static {
        System.out.println("Static inizializator");
    }

    //статический метод (общий для всего класса)
    static String[] getGenders() {
        countUser = 0;
        return new String[]{GENDER_MALE, GENDER_FEMALE};
    }

    //метод который принимает объект
    void addDocument(Document d) {
        this.documents[docCount] = d;
        docCount++;
    }

    //метод, который возвращает объект
    Document lastDocument() {
        return documents[docCount - 1];
    }

    //передача аргумента по значению (для примитивот это копия числа, т.е. само число)
    void methodA(int a) {
        a = 10;
    }

    //передача аргумента по значению (для ссылочных это копия ссылки
    void methodB(User u) {
        // u = new User("Masha", 30, 2000);
        u.setAge(50);
    }

    void setGender(String g) {
        this.gender = g;
    }

    User() {
        //this("неопределено",18,1);
        name = "неопределено";
        age = 18;
        salary = 1;
        System.out.println("Конструктор");
    }


    User(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    User(String n) {
        this();
        name = n;
        age = 18;
        if (name == "aaa") {
            System.out.println("error");
        }
    }

    String getInfo() {
        String result = name + " "
                + age + "y $" + salary;

        if (docCount > 0) {
            String doc = "";
            for (int i = 0; i < docCount; i++) {
                doc += "\t" + documents[i].getInfo() + "\n";
            }
            result += "\n" + doc;
        }
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
}
