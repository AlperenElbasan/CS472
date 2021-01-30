package storage;

import model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Users {
    private static final Map<String, User> users = new HashMap<>();

    public static List<User> list() {
        return new ArrayList<>(users.values());
    }

    public static void add(User user) {
        users.put(user.getUuid(), user);
    }

    public static User get(String uuid) { return users.get(uuid); }

    public static boolean exists(String uuid) { return users.containsKey(uuid); }
}
