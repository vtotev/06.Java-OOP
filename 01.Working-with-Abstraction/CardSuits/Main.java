package WorkingWithAbstraction.CardSuits;

public class Main {
    public static void main(String[] args) {
        System.out.println("Card Suits");
        for (CARDSUITS card: CARDSUITS.values()) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", card.ordinal(), card.name());
        }
    }
}
