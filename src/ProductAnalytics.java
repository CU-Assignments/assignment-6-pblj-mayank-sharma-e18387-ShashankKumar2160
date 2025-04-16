import java.util.*;
import java.util.stream.*;
import java.util.function.*;

class Product {
    String name;
    String category;
    double price;

    Product(String name, String category, double price) {
        this.name = name; this.category = category; this.price = price;
    }

    public String toString() {
        return name + " (" + category + ") - $" + price;
    }

    public String getCategory() { return category; }
    public double getPrice() { return price; }
}

public class ProductAnalytics {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", "Electronics", 1200),
            new Product("TV", "Electronics", 900),
            new Product("Sofa", "Furniture", 800),
            new Product("Chair", "Furniture", 150),
            new Product("Book", "Stationery", 20),
            new Product("Pen", "Stationery", 2)
        );

        Map<String, List<Product>> grouped = products.stream()
            .collect(Collectors.groupingBy(Product::getCategory));
        System.out.println("Grouped by category:");
        grouped.forEach((k, v) -> System.out.println(k + ": " + v));

        Map<String, Optional<Product>> mostExpensive = products.stream()
            .collect(Collectors.groupingBy(
                Product::getCategory,
                Collectors.maxBy(Comparator.comparingDouble(Product::getPrice))
            ));
        System.out.println("\nMost expensive product in each category:");
        mostExpensive.forEach((k, v) -> System.out.println(k + ": " + v.get()));

        double averagePrice = products.stream()
            .collect(Collectors.averagingDouble(Product::getPrice));
        System.out.println("\nAverage price of all products: $" + averagePrice);
    }
}
