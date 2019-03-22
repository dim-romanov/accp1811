package ru.sstu.lessons.lesson20;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        User user = new User("Ivan", 13, 123213);
        user.setRole("SuperAdmin");

        MegaInterface megaBigClass = new MegaBigClass();
        megaBigClass = SecurityLogic.create(megaBigClass, user.getRole());
        megaBigClass.mA();
//
//        TestClass testClass = (TestClass) SecurityLogic.create(new TestClass(), "User");
//        testClass.mA();

        Class userClass = user.getClass();
        Class clazz = String.class;

        System.out.println(clazz.getName());
        System.out.println(clazz.getSimpleName());

        Field[] field = userClass.getFields();
        for (int i = 0; i < field.length; i++) {
            Field f = field[i];
            System.out.println(f.getType().getSimpleName() + " " + f.getName());
        }

        field = userClass.getDeclaredFields();
        for (int i = 0; i < field.length; i++) {
            Field f = field[i];
            if (Modifier.isPrivate(f.getModifiers())) System.out.print("private");
            if (Modifier.isPublic(f.getModifiers())) System.out.print("public");
            System.out.println(" " + f.getType().getSimpleName() + " " + f.getName());

        }
        try {
            Field ageField = userClass.getField("age");
            int age = (int) ageField.get(user);
            System.out.println(age);
            ageField.set(user, 133);
            System.out.println(user);


            Field salaryField = userClass.getDeclaredField("salary");
            salaryField.setAccessible(true);
            double salary = (double) salaryField.get(user);
            System.out.println(salary);
            salaryField.set(user, 133.5);
            System.out.println(user);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        Annotation a = userClass.getAnnotation(BaseAnnotation.class);
        if (a == null) System.out.println("not found");
        else {
            BaseAnnotation baseAnnotation = (BaseAnnotation) a;
            System.out.println(baseAnnotation.level() + " " + baseAnnotation.sqlQuery());
            //        Database.select(baseAnnotation.sqlQuery())
        }


    }
}
