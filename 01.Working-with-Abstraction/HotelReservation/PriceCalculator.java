package WorkingWithAbstraction.HotelReservation;

public class PriceCalculator {

    public static double Calculate(double pricePerDay, int numberOfDays, SEASON season, DISCOUNT discount) {
        double result = 0.00;
        result = pricePerDay * numberOfDays * season.getMultiplier();
        result -= result * (discount.getDiscount() / 100.0);
        return result;
    }
}
