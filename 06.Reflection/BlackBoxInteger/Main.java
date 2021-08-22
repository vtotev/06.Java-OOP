package Reflection.BlackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Scanner scan = new Scanner(System.in);
        Constructor<BlackBoxInt> ctor = BlackBoxInt.class.getDeclaredConstructor();
        ctor.setAccessible(true);
        BlackBoxInt blackBoxInt = ctor.newInstance();

        Method[] methods = blackBoxInt.getClass().getDeclaredMethods();
        Field innerValue = blackBoxInt.getClass().getDeclaredField("innerValue");
        innerValue.setAccessible(true);

        String line;

        while (!"END".equals(line = scan.nextLine())) {
            String[] tokens = line.split("_");
            String command = tokens[0];
            int param = Integer.parseInt(tokens[1]);
            Method method = Arrays.stream(methods).filter(m -> m.getName().equals(command)).findFirst().get();
            method.setAccessible(true);
            method.invoke(blackBoxInt, param);
            System.out.println(innerValue.getInt(blackBoxInt));
        }
    }
}
