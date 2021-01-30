package model;

import java.util.UUID;

public class User {
    private final ShoppingCart shoppingCart;
    private final String uuid;
    private String username;
    private String password;

    public User() {
        this.uuid = UUID.randomUUID().toString();
        this.shoppingCart = new ShoppingCart();
    }

    public User(String name, String password) {
        this();
        this.username = name;
        this.password = password;
    }

    public String getUuid() {
        return uuid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    @Override
    public String toString() {
        return "User has " +
                "uuid " + uuid +
                "\nand username is " + username;
    }
}
