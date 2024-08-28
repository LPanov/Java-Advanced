package SetsAndMapsAdvanced.Lab;

import java.util.*;

public class ProductShop {
    public static class Product {
        private String name;
        private double price;

        public Product(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, List<Product>> stores = new TreeMap<>();

        String command = sc.nextLine();
        while (!command.equals("Revision")) {
            String[] token = command.split(", ");
            String nameStore = token[0];
            String nameProduct = token[1];
            double priceProduct = Double.parseDouble(token[2]);

            if (!stores.containsKey(nameStore)) {
                stores.put(nameStore, new ArrayList<>());
                stores.get(nameStore).add(new Product(nameProduct, priceProduct));
            } else {
                stores.get(nameStore).add(new Product(nameProduct, priceProduct));
            }

            command = sc.nextLine();
        }

        stores.entrySet().stream().forEach(entry -> {
            System.out.println(entry.getKey() + "->");
            entry.getValue().forEach(p ->
                    System.out.println("Product: " + p.getName() + ", "
                + "Price: " + String.format("%.1f", p.getPrice())));
        });
    }
}
