package homeworks.onlineMarket.storage;

import homeworks.onlineMarket.model.UserType;
import homeworks.onlineMarket.exception.NotFoundException;
import homeworks.onlineMarket.model.User;
import homeworks.onlineMarket.util.StorageSerializeUtil;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class UserStorage implements Serializable {
    private final Map<String, User> users = new HashMap<>();

    public UserStorage() {
    }

    public void addUser(String id, User user) {
        users.put(id, user);
        StorageSerializeUtil.serializeUserStorage(this);
    }

    public void printAllUsers() {
        for (User value : users.values()) {
            if (value.getUserType() == UserType.USER) {
                System.out.println(value);
            }
        }
    }

    public User getUserById(String id) throws NotFoundException {
        for (User user : users.values()) {
            if (user.getUserId().equals(id)) {
                return user;
            }
        }
        throw new NotFoundException("no such user");
    }

    public User getUserByEmail(String email) throws NotFoundException {
        for (User user : users.values()) {
            if (user.getUserEmail().equals(email)) {
                return user;
            }
        }
        throw new NotFoundException("no such user");
    }

    public boolean checkPassword(User user, String password) {
        for (User value : users.values()) {
            if (value.equals(user) && value.getUserPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
