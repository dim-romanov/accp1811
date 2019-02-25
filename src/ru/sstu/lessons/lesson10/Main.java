package ru.sstu.lessons.lesson10;

import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    static int n = 0;

    public static void main(String[] args) {
        System.out.println("Множества и карты");

        //очередь
        LinkedList<Integer> qeueue = new LinkedList<>();
        qeueue.addLast(2);//добавить в конец очереди
        qeueue.addLast(4);
        qeueue.addLast(-4);

        int n = qeueue.removeFirst();//удалить из начала очереди
        n = qeueue.removeFirst();

        qeueue.addLast(40);
        qeueue.addLast(-45);

        n = qeueue.removeFirst();

        print(qeueue, false);

        qeueue.addLast(5);
        print(qeueue, false);

        //стек
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(1);//добавить в стек
        stack.push(2);
        stack.push(10);

        n = stack.pop();//удалитьиз стека
        n = stack.pop();

        stack.push(15);
        stack.push(-1);

        n = stack.pop();
        print(stack, true);

        //множество (уникальность элементов)
        HashSet<Integer> setInt = new HashSet<>();
        setInt.add(3);
        setInt.add(1);
        setInt.add(2);
        setInt.add(3);
        setInt.add(-3);
        setInt.add(-3);
        setInt.add(-3);
        setInt.add(-3);

        Iterator<Integer> it = setInt.iterator();
        while ((it.hasNext())) {
            int x = it.next();
            System.out.print(x + " ");
        }
        System.out.println();
        System.out.println("size " + setInt.size());

        for (Integer i : setInt) {
            System.out.print(i + " ");
        }
        System.out.println();

        HashSet<User> users = new HashSet<>();
        User u = new User("Ivan", 18, 10000);
        users.add(u);
        users.add(new User("Masha", 18, 12000));
        users.add(new User("Petr", 18, 14000));
        users.add(new User("Ivan", 18, 10000));
        for (User us : users) {
            System.out.println(us);
        }

        boolean b = users.contains(u);
        users.remove(new User("Ivan", 18, 10000));

        HashSet<String> setA = new HashSet<>();
        setA.add("A");
        setA.add("B");
        setA.add("C");
        HashSet<String> setB = new HashSet<>();
        setB.add("B");
        setB.add("C");
        setB.add("D");

        //объединие множеств (общие элементы)
        HashSet<String> setC = new HashSet<>();
        setC.addAll(setA);
        setC.addAll(setB);
        for (String s : setC) {
            System.out.print(s + " ");
        }
        System.out.println();

        //вычитание мнижеств (A-B) в А уникаольные элементы
        setC = new HashSet<>();
        setC.addAll(setA);
        setC.removeAll(setB);
        for (String s : setC) {
            System.out.print(s + " ");
        }
        System.out.println();

        //пересечение множеств //общие элементы для A и B
        setC = new HashSet<>();
        setC.addAll(setA);
        setC.retainAll(setB);
        for (String s : setC) {
            System.out.print(s + " ");
        }
        System.out.println();

        //упорядоченное множество
        TreeSet<Integer> treeInt = new TreeSet<>();
        treeInt.add(3);
        treeInt.add(23);
        treeInt.add(53);
        treeInt.add(-3);
        treeInt.add(3);
        treeInt.add(63);
        treeInt.add(-3);
        treeInt.add(-13);
        treeInt.add(36);

        for (Integer s : treeInt) {
            System.out.print(s + " ");
        }
        System.out.println();

        int n1 = treeInt.lower(5);//количесвто элементов меньших 5
        System.out.println(n1);
        SortedSet<Integer> integers = treeInt.subSet(-3, 50);//множестов элементов от -3 до 50

        for (Integer s : integers) {
            System.out.print(s + " ");
        }
        System.out.println();

        TreeSet<User> users1 = new TreeSet<>();

        users1.addAll(users);
        users1.add(new User("Masha", 18, 2000));
        users1.add(new User("Petr", 18, 13000));
        users1.add(new User("Ivan1", 18, 10000));

        for (User us : users1) {
            System.out.println(us);
        }

        TreeSet<User> users2 = new TreeSet<>(new UserComparator());//новая сортровка
        users2.addAll(users1);

        users2.add(new User("Masha", 18, 2000));
        users2.add(new User("Masha", 18, 4000));
        users2.add(new User("Masha", 18, 25000));

        System.out.println("-------------");
        for (User us : users2) {
            System.out.println(us);
        }


        //карта (ключ-значение)
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "Ivan");//добавить элемент

        if (hashMap.containsKey(1)) {//проверкан на содержение ключа
            //
        } else {
            hashMap.put(1, "Pasha");
        }
        hashMap.put(1, "Pasha");
        hashMap.put(-3, "Vasay");
        hashMap.put(2, "Masha");

        //перебор элементов
        for (Map.Entry<Integer, String> item : hashMap.entrySet()) {
            System.out.println(item.getKey() + " " + item.getValue());
        }

        HashMap<Integer, User> userHashMap = new HashMap<>();
        userHashMap.put(1, new User("Masha", 18, 2000));
        userHashMap.put(2, new User("Masha", 18, 4000));
        if (userHashMap.containsKey(1)) {
            User u1 = userHashMap.get(1);//получение элемента по ключу
            System.out.println(u1.getSalary());
            u1.setSalary(100000);
        } else {
            userHashMap.put(1, new User("Ivan", 18, 2000));
        }

        TreeMap<Integer, String> map = new TreeMap<>();
        map.putAll(hashMap);

        for (Map.Entry<Integer, String> item : map.entrySet()) {
            System.out.println(item.getKey() + " " + item.getValue());
        }

        HashMap<User, List<Map<Integer, String>>> map1 = new HashMap<>();

        Set<User> set = map1.keySet();

        User u2 = new User("1", 2, 2);
        map1.put(u2, new ArrayList<Map<Integer, String>>());
        List<Map<Integer, String>> list = map1.get(u2);
        list.add(hashMap);


        try {
            code("");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void print(List<?> list, boolean newLine) {
        if (newLine) print(list);
        else {
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
        }
    }

    public static void print(List<?> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }


    public static void code(String s) throws FileNotFoundException {
//        try {

        if (false)
            throw new FileNotFoundException();
//        } catch (FileNotFoundException ex) {
//            throw ex;
//        }catch (Exception e){
//
//        }
    }
}
