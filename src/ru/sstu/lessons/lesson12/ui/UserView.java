package ru.sstu.lessons.lesson12.ui;

import ru.sstu.lessons.lesson12.entities.User;
import ru.sstu.lessons.lesson12.service.UserService;

import java.util.List;

public class UserView {

    UserService service = new UserService();

    public void showUsers() {
        List<User> list = service.getList();
        System.out.println("Все пользователи");
        for (User u : list) {
            System.out.println(u);
        }
    }
}
