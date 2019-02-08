package ru.sstu.lessons.lesson3;

public class Main {

    public static void main(String[] args) {
        System.out.println("Классы");
        //создание объекта пользователя
        User ivan = new User();
        //установка значений для полей
        ivan.name = "Ivan";
        ivan.age = 30;
        ivan.salary = 10000;

        //создание объекта пользователя
        User mariya = new User();
        mariya.name = "Mariya";
        mariya.age = 29;
        mariya.salary = 10000;


        //создание объекта пользователя
        User defaultUser = new User();
        //присвоение объекта ivan в ссылку user1
        User user1 = ivan;

        //вывод на экран информации о пользователе
        System.out.println(ivan.name + " " + ivan.salary);
        System.out.println(defaultUser.name + " " + defaultUser.salary);
        System.out.println(user1.name + " " + user1.salary);

        //создание пользователя с помощью конструктора с 3 параметрами
        User vasya = new User("Vasay", 35, 15000);
        System.out.println(vasya.name + " " + vasya.salary);
//        User u2= new User()

        System.out.println();
        //вывод информации о пользователе с использованием метода getInfo
        System.out.println(ivan.getInfo());
        System.out.println(mariya.getInfo());
        System.out.println(vasya.getInfo());
        System.out.println(defaultUser.getInfo());

        double p = 5.5;
        ivan.addSalary(p);//увеличение зарплаты на p процентов
        System.out.println(ivan.getInfo());

        //увеличение з/п для пользователя на 5% на протяжении 10 лет
        for (int i = 0; i < 10; i++) {
            ivan.addSalary(5);
        }
        System.out.println(ivan.getInfo());

        int a = ivan.getAge();//получение возраста пользователя

//        ivan.age = -31;
        ivan.setAge(-31);//задание нового возраста для пользователя
    }
}
