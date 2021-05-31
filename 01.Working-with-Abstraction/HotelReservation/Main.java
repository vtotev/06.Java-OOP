package WorkingWithAbstraction.HotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\s+");
        PriceCalculator calc = new PriceCalculator();
        System.out.printf("%.2f", calc.Calculate(Double.parseDouble(input[0]),
                Integer.parseInt(input[1]), SEASON.valueOf(input[2]), DISCOUNT.valueOf(input[3])));
    }
}
