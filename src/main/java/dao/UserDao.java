package dao;

import java.util.UUID;

public class UserDao {
    private final String uuid;
    private String username;
    private String password;

    public UserDao() {
        this.uuid = UUID.randomUUID().toString();
    }

    public UserDao(String name, String password) {
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

    @Override
    public String toString() {
        return "User has " +
                "uuid " + uuid +
                "\nand username is " + username;
    }
}
