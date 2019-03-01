package ru.sstu.lessons.lesson12.dao;

import ru.sstu.lessons.lesson12.entities.User;

import java.util.List;

public interface UserRepository {

    void getById(int id);
    List<User> getAlL();
    void add(User u);
    void update(User u);
    void delete(User u);
}
