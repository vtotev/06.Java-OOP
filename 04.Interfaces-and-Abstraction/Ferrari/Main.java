package InterfacesAndAbstraction.Ferrari;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Ferrari ferrari = new Ferrari(scan.nextLine());
        System.out.println(ferrari);
    }
}
