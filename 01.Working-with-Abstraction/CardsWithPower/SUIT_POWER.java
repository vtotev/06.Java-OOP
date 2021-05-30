package WorkingWithAbstraction.CardsWithPower;

public enum SUIT_POWER {
    CLUBS (0),
    DIAMONDS (13),
    HEARTS (26),
    SPADES (39);
    private int suitPower;
    SUIT_POWER (int suitPower) {
        this.suitPower = suitPower;
    }

    public int getSuitPower() {
        return suitPower;
    }
}
