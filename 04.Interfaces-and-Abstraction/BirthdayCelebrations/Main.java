package InterfacesAndAbstraction.BirthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        List<Birthable> list = new ArrayList<>();
        while (!input.equalsIgnoreCase("end")) {
            String[] data = input.split(" ");
            switch (data[0]) {
                case "Citizen":
                    list.add(new Citizen(data[1], Integer.parseInt(data[2]), data[3], data[4]));
                    break;
                case "Pet":
                    list.add(new Pet(data[1], data[2]));
                    break;
                case "Robot":
                    Robot robot = new Robot(data[1], data[2]);
                    break;
            }
            input = scan.nextLine();
        }
        String date = scan.nextLine();
        list.stream().filter(o -> o.getBirthDate().endsWith(date)).forEach(o -> System.out.println(o.getBirthDate()));
    }
}
