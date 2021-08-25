package Reflection.Reflection;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class refl = Reflection.class;
        System.out.println(refl);
        Class superClass = refl.getSuperclass();
        System.out.println(superClass);
        Class[] interfaces = refl.getInterfaces();
        for (Class interf: interfaces) {
            System.out.println(interf);
        }
        Object reflObj = refl.getDeclaredConstructor().newInstance();
        System.out.println(reflObj);
    }
}
