package ru.sstu.lessons.lesson12.service;

import ru.sstu.lessons.lesson12.dao.StaticUserRepository;
import ru.sstu.lessons.lesson12.dao.UserRepository;
import ru.sstu.lessons.lesson12.entities.User;

import java.util.List;

public class UserService {
    UserRepository repository =new StaticUserRepository();

    public List<User> getList(){
        return repository.getAlL();
    }
    public List<User> getUserOrderByAge(){
        List<User> users = repository.getAlL();
       // users.sort();
        return users;
    }
}
