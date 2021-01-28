package dao;

public class UserDao {
    private final String uuid;
    private String name;
    private String password;

    public UserDao(String uuid, String name, String password) {
        this.uuid = uuid;
        this.name = name;
        this.password = password;
    }

    public String getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User is {" +
                "uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
