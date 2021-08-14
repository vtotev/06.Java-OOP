package Polymorphism.Animals;

public class Cat extends Animal {

    public Cat(String name, String food) {
        super(name, food);
    }

    @Override
    public String explainSelf() {
        return String.format("I am %s and my favourite food is %s%nMEEOW", super.getName(), super.getFavouriteFood());
    }
}
