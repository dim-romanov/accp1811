package ru.sstu.lessons.lesson13;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        System.out.println("JDBC");

        try {
            //загрузка класса-драйвера
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:myuser.db");//создание соединения с бд
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from users");//выполнение select запроса

        //чтение даных из таблицы
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            double s = rs.getDouble("salary");
            System.out.println(id + " " + name + " " + age + " " + s);
        }


        rs = st.executeQuery("select name,salary from users");
        while (rs.next()) {
            String name = rs.getString(1);//получение строки из первого столбца
            double s = rs.getDouble(2);
            System.out.println(name + " " + s);
        }
        printUsers(conn);


        List<User> users = getUsersByName(conn, "Ivan"); //поиск пользователя по имени
        printUsers(conn);

        String n = null;
        int age = 12;
        double s = 34234;
        insertUser(conn, new User(n, age, s));//метод для встаки пользователей
        printUsers(conn);

        users = getUsers(conn);
        User user = users.get(0);
        user.setSalary(6666666);
        updateUser(conn, user);//метод для обновления пользователей
        printUsers(conn);


        users = getUsers(conn);
        user = users.get(4);
        deleteUser(conn, user);//метод для уделения пользователей
        printUsers(conn);

        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void printUsers(Connection conn) {
        List<User> users = getUsers(conn);
        for (User u : users) {
            System.out.println(u);
        }
        System.out.println("--------------------------");
    }

    /**
     * Удаление пользователя
     * @param conn Соединение с БД
     * @param user Пользователь
     */
    public static void deleteUser(Connection conn, User user) {
        try {
            PreparedStatement st = conn.prepareStatement("delete from users where id=?");
            st.setInt(1, user.getId());
            st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * Обнолвление пользователя
     * @param conn Соединение с БД
     * @param user Удаляемый пользователь
     */
    public static void updateUser(Connection conn, User user) {
        try {
            PreparedStatement st = conn.prepareStatement("update users set name=?, age=?, salary=? where id=?");
            st.setString(1, user.getName());
            st.setInt(2, user.getAge());
            st.setDouble(3, user.getSalary());
            st.setInt(4, user.getId());
            st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    /**
     * Вставка нового пользователя в БД
     * @param conn Соединение с БД
     * @param user Новый пользователь
     */
    public static void insertUser(Connection conn, User user) {
        try {
            PreparedStatement st = conn.prepareStatement("insert into users (name,age,salary) values (?,?,?)");
            st.setString(1, user.getName());
            st.setInt(2, user.getAge());
            st.setDouble(3, user.getSalary());
            st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * Получить список пользователей, отфильтрованных по имени
     * @param conn Соединение с бд
     * @param name Параметр фильтрации
     * @return Список пользователей
     */
    public static List<User> getUsersByName(Connection conn, String name) {
        List<User> users = new ArrayList<>();
        try {

            //select * from user where name like 'ivan'
//            Statement st = conn.createStatement();
//            ResultSet rs = st.executeQuery("select * from users where name like '" + name + "'");

            PreparedStatement st = conn.prepareStatement("select * from users where name like ?");
            st.setString(1, name);
//            st.setInt(2, 4);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name1 = rs.getString("name");
                int age = rs.getInt("age");
                double s = rs.getDouble("salary");
                User u = new User(id, name1, age, s);
                users.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    /**
     * Получить список всех пользователей
     * @param conn Соединение с бд
     * @return Список пользователей
     */
    public static List<User> getUsers(Connection conn) {
        List<User> users = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from users");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                double s = rs.getDouble("salary");
                User u = new User(id, name, age, s);
                users.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }


}
