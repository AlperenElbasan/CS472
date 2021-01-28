package storage;

import dao.UserDao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Users {
    private static final Map<String, UserDao> users = new HashMap<>();

    public static List<UserDao> list() {
        return new ArrayList<>(users.values());
    }

    public static void add(UserDao user) {
        users.put(user.getUuid(), user);
    }

    public static UserDao get(String uuid) { return users.get(uuid); }

    public static boolean exists(String uuid) { return users.containsKey(uuid); }
}
