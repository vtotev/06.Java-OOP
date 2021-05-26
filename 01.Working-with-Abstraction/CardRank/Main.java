package WorkingWithAbstraction.CardRank;

public class Main {
    public static void main(String[] args) {
        System.out.println("Card Ranks");
        for (CARD_RANKS card: CARD_RANKS.values()) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", card.ordinal(), card.name());
        }
    }
}
