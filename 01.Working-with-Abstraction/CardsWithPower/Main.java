package WorkingWithAbstraction.CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String card = scan.nextLine();
        String suit = scan.nextLine();
        System.out.printf("Card name: %s of %s; Card power: %d%n", CARD.valueOf(card), SUIT_POWER.valueOf(suit),
                CARD.valueOf(card).getCardPower() + SUIT_POWER.valueOf(suit).getSuitPower());
    }
}
