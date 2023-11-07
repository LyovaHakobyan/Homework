package homeworks.onlineMarket.model;

import java.io.Serializable;

public class Order implements Serializable {
    private String orderId;
    private User user;
    private Product product;
    private String date;
    private double orderPrice;
    private OrderStatus orderStatus;
    private int quantity;
    private PaymentMethod paymentMethod;

    public Order(String orderId, User user, Product product, String date, double orderPrice, OrderStatus orderStatus, int quantity, PaymentMethod paymentMethod) {
        this.orderId = orderId;
        this.user = user;
        this.product = product;
        this.date = date;
        this.orderPrice = orderPrice;
        this.orderStatus = orderStatus;
        this.quantity = quantity;
        this.paymentMethod = paymentMethod;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "{" + getUser() + "} OrderId:" + orderId + " Product{" + getProduct() + "} Price:" + orderPrice + " Status:" + orderStatus + " Quantity:" + quantity + " PaymentMethod:" + paymentMethod + " Date:" + date;
    }
}
