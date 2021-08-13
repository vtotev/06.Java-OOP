package InterfacesAndAbstraction.Тelephony;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> numbers = Arrays.stream(scan.nextLine().split("\\s+")).collect(Collectors.toList());
        List<String> urls = Arrays.stream(scan.nextLine().split("\\s+")).collect(Collectors.toList());
        Smartphone phone = new Smartphone(numbers, urls);
        while (!phone.getNumbers().isEmpty()) {
            System.out.println(phone.call());
        }
        while (!phone.getUrls().isEmpty()) {
            System.out.println(phone.browse());
        }
    }
}
