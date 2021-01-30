package storage;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public class Products {
    public static final List<Product> products = new ArrayList<>();

    public static List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    public static void addProduct(Product product) {
        products.add(product);
    }
}
