package homeworks.onlineMarket.storage;

import homeworks.onlineMarket.model.OrderStatus;
import homeworks.onlineMarket.exception.NotFoundException;
import homeworks.onlineMarket.model.Order;
import homeworks.onlineMarket.model.User;
import homeworks.onlineMarket.util.StorageSerializeUtil;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class OrderStorage implements Serializable {
    private final List<Order> orders = new LinkedList<>();

    public OrderStorage() {
    }

    public void addOrder(Order order) {
        orders.add(order);
        StorageSerializeUtil.serializeOrderStorage(this);
    }

    public void printAll() {
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    public void printMyOrders(User user) {
        for (Order order : orders) {
            if (order.getUser().equals(user)) {
                System.out.println(order);
            }
        }
    }

    public Order getOrderById(String id) throws NotFoundException {
        for (Order order : orders) {
            if (order.getOrderId().equals(id)) {
                return order;
            }
        }
        throw new NotFoundException("no such order");
    }

    public void changeOrderStatus(Order order, OrderStatus orderStatus) {
        for (Order order1 : orders) {
            if (order1.equals(order)) {
                order1.setOrderStatus(orderStatus);
                StorageSerializeUtil.serializeOrderStorage(this);
                break;
            }
        }
    }

}
