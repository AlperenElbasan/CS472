package model;

import java.util.List;
import java.util.ArrayList;

public class ShoppingCart {
    private final List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }
}
