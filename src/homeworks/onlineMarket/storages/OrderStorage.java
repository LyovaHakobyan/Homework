package homeworks.onlineMarket.storages;

import homeworks.onlineMarket.models.OrderStatus;
import homeworks.onlineMarket.exceptions.NotFoundException;
import homeworks.onlineMarket.interfaces.Printable;
import homeworks.onlineMarket.models.Order;
import homeworks.onlineMarket.models.User;

public class OrderStorage implements Printable {
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
    }

    @Override
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

    public Order returnOrderById(String id) throws NotFoundException {
        for (int i = 0; i < size; i++) {
            if (orders[i].getOrderId().equals(id)) {
                return orders[i];
            }
        }
        throw new NotFoundException();
    }

    public void changeOrderStatus(Order order, OrderStatus orderStatus) {
        for (int i = 0; i < size; i++) {
            if (orders[i].equals(order)) {
                orders[i].setOrderStatus(orderStatus);
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
