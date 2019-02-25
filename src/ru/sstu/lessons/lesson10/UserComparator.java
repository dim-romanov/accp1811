package ru.sstu.lessons.lesson10;



import java.util.Comparator;

//правила сортировки для пользователя
//сортировка по имени и зп
public class UserComparator implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        int s = o1.getName().compareTo(o2.getName());
        if (s == 0) {
            UserBySalaryComparator comparator = new UserBySalaryComparator();
            int f = comparator.compare(o1, o2);
            return -f;
//            if (o1.getSalary() == o2.getSalary()) return 0;
//            if (o1.getSalary() > o2.getSalary()) {
//                return -1;
//            } else {
//                return 1;
//            }
        }
        return s;
    }
}
