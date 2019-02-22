package ru.sstu.lessons.lesson9;

import java.util.Comparator;
//правила сортировки для пользователя
//сортровка по зп
public class UserBySalaryComparator implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        if (o1.getSalary() == o2.getSalary()) return 0;
        if (o1.getSalary() > o2.getSalary()) {
            return 1;
        } else {
            return -1;
        }
    }
}
