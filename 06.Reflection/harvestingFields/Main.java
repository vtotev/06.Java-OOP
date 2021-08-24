package Reflection.harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Field[] declaredFields = RichSoilLand.class.getDeclaredFields();
        String line;
        while (!"HARVEST".equals(line = scan.nextLine())) {
            String modifier = line;
            if (line.equals("all")) {
                printFields(declaredFields);
            } else {
                Field[] fields = Arrays.stream(declaredFields).filter(f -> Modifier.toString(f.getModifiers()).equals(modifier)).toArray(Field[]::new);
                printFields(fields);
            }
        }
    }

    private static void printFields(Field[] fields) {
        Arrays.stream(fields).forEach( field -> System.out.printf("%s %s %s%n",
                Modifier.toString(field.getModifiers()),
                field.getType().getSimpleName(),
                field.getName()));
    }
}
