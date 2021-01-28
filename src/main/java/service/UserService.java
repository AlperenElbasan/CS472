package service;

import storage.Users;

public class UserService {
    private static UserService instance;
    private UserService() {}

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    public boolean isCookieAuthenticated(String uuid) {
        return Users.getUsers().stream().anyMatch(u -> u.getUuid().equals(uuid));
    }

}
