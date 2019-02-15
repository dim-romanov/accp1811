package ru.sstu.lessons.lesson6;

public class Main {
    public static void main(String[] args) {
        System.out.println("Полиморфизм");
        //User u = new User("sa",12,12);
////        u.gender= "male";
////        u.height=12;
////        u.job();

        Employee employee = new Employee();
        employee.job();

        TopManager topManager = new TopManager();
        topManager.job();

        Employee[] employees = new Employee[2];
        employees[0] = employee;
        //нельзя сделать присвоение
        //employees[1] = topManager;

        User u1 = employee;//преобазование ссылки из Employee к User (сам объект employee изменен не будет)
        Object o1 = u1;//преобазование ссылки из User к Object
        u1.job();//с помощью данной ссылки можно вызывать только методы, описанные в классе User
        employee.service();//вызов уникального метода класса Employee
        //u1.service(); //нельзя вызывать, т.к нет данного метода в классе User

        //u1 = new Buch();

        //проверка на тип
        if (u1 instanceof Employee) {
            //явное преобразование типа
            Employee emp1 = (Employee) u1;//преобразование ссылки из User к Employee
            emp1.service();
        }

        Manager m2 = topManager;
        User u2 = m2;
        Object o2 = u2;
        System.out.println(o2.toString());


        //хранение разных объетов(имеющих общего родителя)
        //в одном массиве, для дальшей общей их обработки
        User[] users = new User[4];
        users[0] = new Buch();
        users[1] = new LowManager();
        users[2] = new LowManager();
        users[3] = new Employee();
        for (int i = 0; i < users.length; i++) {
            fee(users[i]);
        }

        topManager.job();//форма топ менеджера
        fee(topManager);//форма юзера
        System.out.println(topManager);// форма Object
        fee(employee);//

    }

    //полиморфный метод
    //принимает тип User и всего его наследников
    public static void fee(User e) {
        double s = e.getSalary();
        System.out.println(s * 0.13);
    }

    public static void serciveFromUser(User u) {
        if (u instanceof Employee) {
            Employee e = (Employee) u;
            e.service();
        }
        if (u instanceof Manager) {
            Manager e = (Manager) u;
            double d = e.getBonus();
        }
        System.out.println("service success");
    }

//    public static void fee(Manager e) {
//        double s = e.getSalary();
//        System.out.println(s * 0.13);
//    }
//
//    public static void fee(Buch e) {
//        double s = e.getSalary();
//        System.out.println(s * 0.13);
//    }
//
//    public static void fee(TopManager e) {
//        double s = e.getSalary();
//        System.out.println(s * 0.13);
//    }
//
//    public static void fee(LowManager e) {
//        double s = e.getSalary();
//        System.out.println(s * 0.13);
//    }
}
