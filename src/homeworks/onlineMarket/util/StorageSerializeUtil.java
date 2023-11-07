package homeworks.onlineMarket.util;

import homeworks.onlineMarket.storage.OrderStorage;
import homeworks.onlineMarket.storage.ProductStorage;
import homeworks.onlineMarket.storage.UserStorage;

import java.io.*;

public abstract class StorageSerializeUtil {
    private static final String ORDER_FILE_PATH = File.separator + "Users" + File.separator + "Dell" + File.separator + "IdeaProjects" + File.separator + "Homework" + File.separator + "src" + File.separator + "homeworks" + File.separator + "onlineMarket" + File.separator + "data" + File.separator + "orderStorage.dat";
    private static final String PRODUCT_FILE_PATH = File.separator + "Users" + File.separator + "Dell" + File.separator + "IdeaProjects" + File.separator + "Homework" + File.separator + "src" + File.separator + "homeworks" + File.separator + "onlineMarket" + File.separator + "data" + File.separator + "productStorage.dat";
    private static final String USER_FILE_PATH = File.separator + "Users" + File.separator + "Dell" + File.separator + "IdeaProjects" + File.separator + "Homework" + File.separator + "src" + File.separator + "homeworks" + File.separator + "onlineMarket" + File.separator + "data" + File.separator + "userStorage.dat";

    public static void serializeOrderStorage(OrderStorage orderStorage) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ORDER_FILE_PATH))) {
            oos.writeObject(orderStorage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static OrderStorage deserializeOrderStorage() {
        File file = new File(ORDER_FILE_PATH);
        if (!file.exists()) {
            return new OrderStorage();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ORDER_FILE_PATH))) {
            Object o = ois.readObject();
            if (o instanceof OrderStorage orderStorage) {
                return orderStorage;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new OrderStorage();
    }

    public static void serializeProductStorage(ProductStorage productStorage) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PRODUCT_FILE_PATH))) {
            oos.writeObject(productStorage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ProductStorage deserializeProductStorage() {
        File file = new File(PRODUCT_FILE_PATH);
        if (!file.exists()) {
            return new ProductStorage();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PRODUCT_FILE_PATH))) {
            Object o = ois.readObject();
            if (o instanceof ProductStorage productStorage) {
                return productStorage;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new ProductStorage();
    }

    public static void serializeUserStorage(UserStorage userStorage) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(USER_FILE_PATH))) {
            oos.writeObject(userStorage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static UserStorage deserializeUserStorage() {
        File file = new File(USER_FILE_PATH);
        if (!file.exists()) {
            return new UserStorage();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(USER_FILE_PATH))) {
            Object o = ois.readObject();
            if (o instanceof UserStorage userStorage) {
                return userStorage;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new UserStorage();
    }
}
