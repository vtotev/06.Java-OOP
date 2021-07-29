package InterfacesAndAbstraction.BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        List<Identifiable> list = new ArrayList<>();
        while (!input.equalsIgnoreCase("end")) {
            String[] data = input.split("\\s+");
            if (data.length == 2) {
                list.add(new Robot(data[0], data[1]));
            } else {
                list.add(new Citizen(data[0], Integer.parseInt(data[1]), data[2]));
            }
            input = scan.nextLine();
        }
        String number = scan.nextLine();
        list.stream().filter(o -> o.getId().endsWith(number)).forEach(o -> System.out.println(o.getId()));
    }
}
