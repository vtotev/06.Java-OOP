package Polymorphism.WildFarm;

public abstract class Food {
    private int quantity;

    public Food(int quantity) {
        setQuantity(quantity);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
