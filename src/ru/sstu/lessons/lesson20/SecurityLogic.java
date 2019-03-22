package ru.sstu.lessons.lesson20;


import java.lang.annotation.Annotation;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class SecurityLogic {
    public static MegaInterface create(MegaInterface m, String role) throws IllegalAccessException {
        Object o = Proxy.newProxyInstance(m.getClass().getClassLoader(),
                m.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    Annotation a = method.getAnnotation(SecurityAnnotation.class);
                    if (a != null) {
                        SecurityAnnotation s = (SecurityAnnotation) a;
                        String[] levels = s.level();
                        for (String s1 : levels) {
                            if (s1.equals(role)) {
                                return method.invoke(m, args);
                            }
                        }
                        throw new IllegalAccessException("НЕт доступа у данного метода");
                    }
                    return method.invoke(m, args);
                });
        if (o instanceof MegaInterface) {
            return (MegaInterface) o;
        }
        System.out.println(m);
        System.out.println(o);
        return null;

    }

    public static Object create(Object m, String role) throws IllegalAccessException {
        Object o = Proxy.newProxyInstance(m.getClass().getClassLoader(),
                m.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    Annotation a = method.getAnnotation(SecurityAnnotation.class);
                    if (a != null) {
                        SecurityAnnotation s = (SecurityAnnotation) a;
                        String[] levels = s.level();
                        for (String s1 : levels) {
                            if (s1.equals(role)) {
                                return method.invoke(m, args);
                            }
                        }
                        throw new IllegalAccessException("НЕт доступа у данного метода");
                    }
                    return method.invoke(m, args);
                });

        System.out.println(m);
        System.out.println(o);
        return o;

    }
}
