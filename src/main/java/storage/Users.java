package storage;

import dao.UserDao;

import java.util.ArrayList;
import java.util.List;

public class Users {
    private static final List<UserDao> users = new ArrayList<UserDao>();

    public static List<UserDao> getUsers() {
        return new ArrayList<>(users);
    }

    public static void addUser(UserDao user) {
        users.add(user);
    }
}
