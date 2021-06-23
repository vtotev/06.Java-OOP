package Encapsulation.ShoppingSpree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        products = new ArrayList<>();
    }

    private void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public double getMoney() {
        return money;
    }

    public void buyProduct (Product product) {
        if (product.getCost() <= getMoney()) {
            products.add(product);
            setMoney(getMoney() - product.getCost());
        } else throw new IllegalArgumentException(String.format("%s can't afford %s", getName(), product.getName()));
    }

    @Override
    public String toString() {
        if (products.isEmpty())
            return String.format("%s – Nothing bought", getName());

        List<String> sb = new ArrayList<>();
        for (Product prod : products) {
            sb.add(prod.getName());
        }
        return String.format("%s - %s", getName(), String.join(", ", sb));
    }
}
