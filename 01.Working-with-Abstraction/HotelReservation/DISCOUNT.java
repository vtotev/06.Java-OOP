package WorkingWithAbstraction.HotelReservation;

public enum DISCOUNT {
    VIP (20),
    SecondVisit (10),
    None (0);
    private int discount;
    DISCOUNT (int discount) {
        this.discount = discount;
    }

    public int getDiscount() {
        return discount;
    }
}
