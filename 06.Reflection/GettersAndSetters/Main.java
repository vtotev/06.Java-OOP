package Reflection.GettersAndSetters;

import java.lang.reflect.Method;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Class refl = Reflection.class;
        Method[] declaredMethods = refl.getDeclaredMethods();
        Set<Method> getters = new TreeSet<>((f, s) -> f.getName().compareTo(s.getName()));
        Set<Method> setters = new TreeSet<>((f, s) -> f.getName().compareTo(s.getName()));
        for (Method meth: declaredMethods) {
            if (meth.getName().contains("set")) {
                setters.add(meth);
            } else if (meth.getName().contains("get")) {
                getters.add(meth);
            }
        }
        getters.stream().forEach(m -> System.out.printf("%s will return class %s%n", m.getName(), m.getReturnType().getName()));
        setters.stream().forEach(m -> System.out.printf("%s and will set field of class %s%n", m.getName(), m.getParameterTypes()[0].getName()));
    }
}
