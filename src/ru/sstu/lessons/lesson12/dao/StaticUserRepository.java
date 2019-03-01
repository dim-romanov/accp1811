package ru.sstu.lessons.lesson12.dao;

import ru.sstu.lessons.lesson12.entities.User;

import java.util.ArrayList;
import java.util.List;

public class StaticUserRepository implements UserRepository {

    static List<User> users = new ArrayList<>();

    @Override
    public void getById(int id) {

    }

    @Override
    public List<User> getAlL() {
        return users;
    }

    @Override
    public void add(User u) {
        users.add(u);
    }

    @Override
    public void update(User u) {

    }

    @Override
    public void delete(User u) {

    }
}
