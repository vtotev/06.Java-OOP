package Encapsulation.ShoppingSpree;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] persons = scan.nextLine().split(";");
        List<Person> personSet = readPersons(persons);
        String[] products = scan.nextLine().split(";");
        List<Product> productsSet = readProducts(products);
        String input = scan.nextLine();
        while (!input.equals("END")) {
            String[] data = input.split("\\s+");
            try {
                buyProduct(personSet, productsSet.get(getProduct(productsSet, data[1])), data);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            input = scan.nextLine();
        }

        for (Person person : personSet) {
            System.out.println(person.toString());
        }
    }

    private static void buyProduct(List<Person> personSet, Product product, String[] data) {
        int personIndex = getPerson(personSet, data[0]);
        if (personIndex != -1) {
            personSet.get(personIndex).buyProduct(product);
            System.out.printf("%s bought %s%n", data[0], data[1]);
        }
    }

    private static List<Product> readProducts(String[] products) {
        List<Product> productList = new ArrayList<>();
        for (String product : products) {
            String[] data = product.split("=");
            try {
                Product newProduct = new Product(data[0], Double.parseDouble(data[1]));
                productList.add(newProduct);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return productList;
    }

    private static List<Person> readPersons(String[] persons) {
        List<Person> personList = new ArrayList<>();
        for (String person : persons) {
            String[] data = person.split("=");
            try {
                Person newPerson = new Person(data[0], Double.parseDouble(data[1]));
                personList.add(newPerson);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return personList;
    }

    private static int getPerson(List<Person> personSet, String datum) {
        for (int i = 0; i < personSet.size(); i++) {
            if (personSet.get(i).getName().equals(datum)) {
                return i;
            }
        }
        return -1;
    }

    private static int getProduct(List<Product> productsList, String datum) {
        for (int i = 0; i < productsList.size(); i++) {
            if (productsList.get(i).getName().equals(datum)) {
                return i;
            }
        }
        return -1;
    }
}
