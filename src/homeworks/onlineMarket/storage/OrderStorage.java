package homeworks.onlineMarket.storage;

import homeworks.onlineMarket.model.OrderStatus;
import homeworks.onlineMarket.exception.NotFoundException;
import homeworks.onlineMarket.model.Order;
import homeworks.onlineMarket.model.User;
import homeworks.onlineMarket.util.StorageSerializeUtil;

import java.io.Serializable;

public class OrderStorage implements Serializable {
    private Order[] orders;
    private int size;

    public OrderStorage() {
        orders = new Order[10];
        size = 0;
    }

    public void addOrder(Order order) {
        if (size == orders.length - 1) {
            extend();
        }
        orders[size++] = order;
        StorageSerializeUtil.serializeOrderStorage(this);
    }

    public void printAll() {
        for (int i = 0; i < size; i++) {
            System.out.println(orders[i]);
        }
    }

    public void printMyOrders(User user) {
        for (int i = 0; i < size; i++) {
            if (orders[i].getUser().equals(user)) {
                System.out.println(orders[i]);
            }
        }
    }

    public Order getOrderById(String id) throws NotFoundException {
        for (int i = 0; i < size; i++) {
            if (orders[i].getOrderId().equals(id)) {
                return orders[i];
            }
        }
        throw new NotFoundException("no such order");
    }

    public void changeOrderStatus(Order order, OrderStatus orderStatus) {
        for (int i = 0; i < size; i++) {
            if (orders[i].equals(order)) {
                orders[i].setOrderStatus(orderStatus);
                StorageSerializeUtil.serializeOrderStorage(this);
                break;
            }
        }
    }

    private void extend() {
        Order[] temp = new Order[orders.length + 10];
        System.arraycopy(orders, 0, temp, 0, size);
        orders = temp;
    }
}
