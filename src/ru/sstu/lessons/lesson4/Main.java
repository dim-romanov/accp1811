package ru.sstu.lessons.lesson4;

public class Main {
    public static void main(String[] args) {
        System.out.println("Статика");

        User ivan = new User("Ivan", 30, 1000);

        //про передачу параметров в метод
        int a = 5;
        System.out.println(a);
        ivan.methodA(a);
        System.out.println(a);

        System.out.println(ivan.getInfo());
        ivan.methodB(ivan);
        System.out.println(ivan.getInfo());

        User masha = new User();

        User u = new User();
        masha.countUser = 50;//изменение статичной переменной
        masha.setGender(User.GENDER_FEMALE);//передача в метод статичной переменной

        System.out.println(u.countUser);
        System.out.println(ivan.countUser);
        System.out.println(masha.countUser);
        System.out.println(User.countUser);//к статичным полям можно обращатся через имя Класса
        String[] s = User.getGenders();//к статичным методам можно обращатся через имя Класса

        //создание документов
        Document d = new Document("doc1", "24342342AA");
        Document d2 = new Document("doc2", "1111 342AA");
        Document d3 = new Document("doc3", "1111 aaaaa");

        //добавление документов для конкретного пользователя
        ivan.addDocument(d);
        ivan.addDocument(d2);
        ivan.addDocument(d3);
        System.out.println(ivan.getInfo());

        //добавление документов для конкретного пользователя
        masha.addDocument(new Document("doc22", "233231"));
        System.out.println(masha.getInfo());
        //получение документа
        Document document = masha.lastDocument();
        System.out.println(document.getNumber());

        //Пример работы со статичным массивом
        System.out.println("---------------------------");
        UserRepository.add(ivan);//добавление пользователя в бд
        UserRepository.add(masha);//добавление пользователя в бд
        User[] users = UserRepository.getUsers();//получение всех пользователей
        for (int i = 0; i < users.length; i++) {
            System.out.println(users[i].getInfo());
        }

        User[] users1 = UserRepository.getUserMolod();//получение молодых пользователей
        System.out.println("молодые");
        for (int i = 0; i < users1.length; i++) {
            System.out.println(users1[i].getInfo());
        }

        User iv = UserRepository.getUserByInd(3);//получение пользователей по его номеру
        iv.setAge(66);//изменение возраста

        users = UserRepository.getUsers();
        for (int i = 0; i < users.length; i++) {
            System.out.println(users[i].getInfo());
        }
    }
}
