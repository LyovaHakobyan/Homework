package homeworks.onlineMarket.storage;

import homeworks.onlineMarket.model.UserType;
import homeworks.onlineMarket.exception.NotFoundException;
import homeworks.onlineMarket.model.User;
import homeworks.onlineMarket.util.StorageSerializeUtil;

import java.io.Serializable;

public class UserStorage implements Serializable {
    private User[] users;
    private int size;

    public UserStorage() {
        users = new User[10];
        size = 0;
    }

    public void addUser(User user) {
        if (size == users.length - 1) {
            extend();
        }
        users[size++] = user;
        StorageSerializeUtil.serializeUserStorage(this);
    }

    public void printAll() {
        for (int i = 0; i < size; i++) {
            System.out.println(users[i]);
        }
    }

    public void printAllUsers() {
        for (int i = 0; i < size; i++) {
            if (users[i].getUserType() == UserType.USER) {
                System.out.println(users[i]);
            }
        }
    }

    public User returnUserById(String id) throws NotFoundException {
        for (int i = 0; i < size; i++) {
            if (users[i].getUserId().equals(id)) {
                return users[i];
            }
        }
        throw new NotFoundException("no such user");
    }

    public User getUserByEmail(String email) throws NotFoundException {
        for (int i = 0; i < size; i++) {
            if (users[i].getUserEmail().equals(email)) {
                return users[i];
            }
        }
        throw new NotFoundException("no such user");
    }

    public boolean checkPassword(User user, String password) {
        for (int i = 0; i < size; i++) {
            if (users[i].equals(user) && users[i].getUserPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    private void extend() {
        User[] temp = new User[users.length + 10];
        System.arraycopy(users, 0, temp, 0, size);
        users = temp;
    }
}
