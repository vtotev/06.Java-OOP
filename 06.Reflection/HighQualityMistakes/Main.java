package Reflection.HighQualityMistakes;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Class refl = Reflection.class;
        Field[] declaredFields = refl.getDeclaredFields();
        Method[] declaredMethods = refl.getDeclaredMethods();
        Set<Method> getters = new TreeSet<>((f, s) -> f.getName().compareTo(s.getName()));
        Set<Method> setters = new TreeSet<>((f, s) -> f.getName().compareTo(s.getName()));
        Arrays.stream(declaredMethods).forEach(m -> {
            if (m.getName().contains("get")) {
                getters.add(m);
            } else if (m.getName().contains("set")) {
                setters.add(m);
            }
        });
        Arrays.stream(declaredFields).filter(f -> !Modifier.isPrivate(f.getModifiers()))
                .sorted((f, s) -> f.getName().compareTo(s.getName()))
                .forEach(f -> System.out.printf("%s must be private!%n", f.getName()));
        getters.stream().filter(f -> !Modifier.isPublic(f.getModifiers()))
                .sorted((f, s) -> f.getName().compareTo(s.getName()))
                .forEach(f -> System.out.printf("%s have to be public!%n", f.getName()));
        setters.stream().filter(f -> !Modifier.isPrivate(f.getModifiers()))
                .sorted((f, s) -> f.getName().compareTo(s.getName()))
                .forEach(f -> System.out.printf("%s have to be private!%n", f.getName()));
    }
}
