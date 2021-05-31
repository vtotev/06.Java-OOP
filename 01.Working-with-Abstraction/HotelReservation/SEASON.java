package WorkingWithAbstraction.HotelReservation;

public enum SEASON {
    Autumn (1),
    Spring (2),
    Winter (3),
    Summer (4);

    private int multiplier;
    SEASON(int multiplier) {
        this.multiplier = multiplier;
    }

    public int getMultiplier() {
        return multiplier;
    }
}
