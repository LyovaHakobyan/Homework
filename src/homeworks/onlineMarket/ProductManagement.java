package homeworks.onlineMarket;

import homeworks.onlineMarket.model.OrderStatus;
import homeworks.onlineMarket.model.PaymentMethod;
import homeworks.onlineMarket.model.ProductType;
import homeworks.onlineMarket.model.UserType;
import homeworks.onlineMarket.exception.NotFoundException;
import homeworks.onlineMarket.exception.OutOfStockException;
import homeworks.onlineMarket.model.Order;
import homeworks.onlineMarket.model.Product;
import homeworks.onlineMarket.model.User;
import homeworks.onlineMarket.storage.OrderStorage;
import homeworks.onlineMarket.storage.ProductStorage;
import homeworks.onlineMarket.storage.UserStorage;
import homeworks.onlineMarket.util.Command;
import homeworks.onlineMarket.util.StorageSerializeUtil;
import homeworks.onlineMarket.util.UuidUtil;


import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;


public class ProductManagement implements Command {
    static Scanner in = new Scanner(System.in);
    static UserStorage userStorage = StorageSerializeUtil.deserializeUserStorage();
    static OrderStorage orderStorage = StorageSerializeUtil.deserializeOrderStorage();
    static ProductStorage productStorage = StorageSerializeUtil.deserializeProductStorage();
    static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm");

    public static void main(String[] args) {
        boolean process = true;
        while (process) {
            Command.loginRegisterCommands();
            int choice;
            try {
                choice = Integer.parseInt(in.nextLine());
            } catch (NumberFormatException e) {
                choice = -1;
            }
            switch (choice) {
                case LOG_IN:
                    logIn();
                    break;
                case REGISTER:
                    register();
                    break;
                case FINISH_PROCESS:
                    process = false;
                    break;
                default:
                    System.out.println("-- Wrong command, try again --");
                    break;
            }
        }
    }

    private static void register() {
        System.out.println("-- Register as " + UserType.USER + "( Press 0 ), " + UserType.ADMIN + "( Press 1 ) --");
        UserType userType;
        int choice;
        try {
            choice = Integer.parseInt(in.nextLine());
        } catch (NumberFormatException e) {
            choice = -1;
        }
        switch (choice) {
            case 0:
                userType = UserType.USER;
                break;
            case 1:
                userType = UserType.ADMIN;
                break;
            default:
                System.out.println("-- Wrong command --");
                return;
        }
        System.out.println("Name...");
        String name = in.nextLine();
        System.out.println("Id...");
        String id;
        while (true) {
            id = in.nextLine();
            try {
                userStorage.returnUserById(id);
                System.out.println("-- This Id is already used, try again --");
            } catch (NotFoundException e) {
                break;
            }
        }
        System.out.println("Email...");
        String email;
        while (true) {
            email = in.nextLine();
            try {
                userStorage.getUserByEmail(email);
                System.out.println("-- This Email is already used, try again --");
            } catch (NotFoundException e) {
                break;
            }
        }
        System.out.println("Password...");
        String password = in.nextLine();
        User user = new User(id, name, email, password, userType);
        userStorage.addUser(user);
        System.out.println("-- Completed --");
    }

    private static void logIn() {
        System.out.println("Email...");
        String email = in.nextLine();
        User user;
        try {
            user = userStorage.getUserByEmail(email);
        } catch (NotFoundException e) {
            System.out.println("-- Wrong Email --");
            return;
        }
        System.out.println("Password...");
        String password = in.nextLine();
        try {
            if (!userStorage.checkPassword(user, password)) {
                throw new NotFoundException();
            }
        } catch (NotFoundException e) {
            System.out.println("-- Wrong Password --");
            return;
        }
        switch (user.getUserType()) {
            case ADMIN:
                loginAsAdmin(user);
                break;
            case USER:
                loginAsUser(user);
                break;
        }

    }


    private static void loginAsAdmin(User user) {
        boolean process = true;
        while (process) {
            Command.adminCommands();
            int choice;
            try {
                choice = Integer.parseInt(in.nextLine());
            } catch (NumberFormatException e) {
                choice = -1;
            }
            switch (choice) {
                case LOGOUT:
                    System.out.println("Logout...");
                    process = false;
                    break;
                case ADD_PRODUCT:
                    addProduct();
                    break;
                case REMOVE_PRODUCT:
                    removeProduct();
                    break;
                case PRINT_PRODUCTS:
                    printProducts();
                    break;
                case PRINT_USERS:
                    printUsers();
                    break;
                case PRINT_ORDERS:
                    printOrders();
                    break;
                case CHANGE_ORDER_STATUS:
                    changeOrderStatus();
                    break;
                default:
                    System.out.println("-- Wrong command --");
                    break;
            }
        }
    }


    private static void loginAsUser(User user) {
        boolean process = true;
        while (process) {
            Command.userCommands();
            int choice;
            try {
                choice = Integer.parseInt(in.nextLine());
            } catch (NumberFormatException e) {
                choice = -1;
            }
            switch (choice) {
                case LOGOUT:
                    System.out.println("Logout...");
                    process = false;
                    break;
                case PRINT_MY_ORDERS:
                    printMyOrders(user);
                    break;
                case BUY_PRODUCT:
                    buyProduct(user);
                    break;
                case PRINT_PRODUCTS:
                    printProducts();
                    break;
                case CANCEL_ORDER:
                    cancelMyOrder();
                    break;
                default:
                    System.out.println("-- Wrong command --");
                    break;
            }
        }
    }


    private static void addProduct() {
        System.out.println("Product Id...");
        String id = in.nextLine();
        System.out.println("Product name...");
        String name = in.nextLine();
        System.out.println("Description...");
        String description = in.nextLine();
        System.out.println("Price...");
        double price;
        while (true) {
            try {
                price = Integer.parseInt(in.nextLine());
                if (price < 0) {
                    throw new NumberFormatException();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("-- Wrong price, try again --");
            }
        }
        System.out.println("Quantity...");
        int quantity;
        while (true) {
            try {
                quantity = Integer.parseInt(in.nextLine());
                if (quantity < 0) {
                    throw new NumberFormatException();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("-- Wrong quantity, try again --");
            }
        }
        System.out.println("ProductType" + Arrays.toString(ProductType.values()) + "...");
        ProductType productType;
        try {
            productType = ProductType.valueOf(in.nextLine().toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("-- Wrong product, process if failed --");
            return;
        }
        Product product = new Product(id, name, description, price, quantity, productType);
        productStorage.addProduct(product);
        System.out.println("-- Completed --");
    }

    private static void removeProduct() {
        System.out.println("Id...");
        String idOfProduct = in.nextLine();
        try {
            productStorage.removeProductById(idOfProduct);
            System.out.println("-- Product is removed ! --");
        } catch (NotFoundException e) {
            System.out.println("-- Product by this Id is not found --");
        }
    }

    private static void printUsers() {
        System.out.println("-- Here are all users --");
        userStorage.printAllUsers();
    }

    private static void printProducts() {
        System.out.println("-- Here are all products --");
        productStorage.printAll();
    }

    private static void printOrders() {
        System.out.println("-- Here are all orders --");
        orderStorage.printAll();
    }

    private static void changeOrderStatus() {
        System.out.println("-- Enter order Id --");
        String orderId = in.nextLine();
        Order order;
        try {
            order = orderStorage.getOrderById(orderId);
        } catch (NotFoundException e) {
            System.out.println("-- Order by this Id is not found --");
            return;
        }
        System.out.println(order);
        System.out.println("-- Enter new status " + Arrays.toString(OrderStatus.values()));
        String newStatus = in.nextLine();
        OrderStatus orderStatus;
        try {
            orderStatus = OrderStatus.valueOf(newStatus.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("-- Wrong status, process is failed --");
            return;
        }
        switch (orderStatus) {
            case NEW:
                if (order.getOrderStatus() == OrderStatus.DELIVERED) {
                    System.out.println("-- You cannot renew delivered product --");
                    break;
                }
                orderStorage.changeOrderStatus(order, orderStatus);
                System.out.println("-- Order is changed --");
                break;
            case CANCELED:
                orderStorage.changeOrderStatus(order, orderStatus);
                System.out.println("-- Order is changed --");
                break;
            case DELIVERED:
                if (order.getOrderStatus() == OrderStatus.CANCELED) {
                    System.out.println("-- You cannot deliver canceled product --");
                    break;
                }
                orderStorage.changeOrderStatus(order, orderStatus);
                try {
                    productStorage.buyProduct(orderId, order.getQuantity());
                    StorageSerializeUtil.serializeOrderStorage(orderStorage);
                    System.out.println("-- Order is changed --");
                } catch (OutOfStockException e) {
                    System.out.println("-- There is not as much product as you have entered --");
                }
                break;
        }
    }

    private static void buyProduct(User user) {
        System.out.println("Id of product...");
        String id = in.nextLine();
        Product product;
        try {
            product = productStorage.returnProductById(id);
        } catch (NotFoundException e) {
            System.out.println("-- Product by this Id is not found --");
            return;
        }
        System.out.println("Quantity...");
        int quantity;
        while (true) {
            try {
                quantity = Integer.parseInt(in.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("-- Wrong quantity, try again --");
            }
        }
        System.out.println("Payment type " + PaymentMethod.CARD + "( Press 0 ), " + PaymentMethod.CASH + "( Press 1 ), " + PaymentMethod.PAYPAL + " ( Press 2 )");
        PaymentMethod paymentMethod = null;
        boolean processCommand = true;
        while (processCommand) {
            int paymentIndex;
            try {
                paymentIndex = Integer.parseInt(in.nextLine());
            } catch (NumberFormatException e) {
                paymentIndex = -1;
            }
            switch (paymentIndex) {
                case 0:
                    paymentMethod = PaymentMethod.CARD;
                    processCommand = false;
                    break;
                case 1:
                    paymentMethod = PaymentMethod.CASH;
                    processCommand = false;
                    break;
                case 2:
                    paymentMethod = PaymentMethod.PAYPAL;
                    processCommand = false;
                    break;
                default:
                    System.out.println("-- Wrong number, try again --");
                    break;
            }
        }
        double orderPrice = quantity * product.getProductPrice();
        System.out.println("-- The product you want to buy:" + product + " Quantity:" + quantity + " Price:" + orderPrice + " --");
        System.out.println("-- Enter 'yes' if you want to BUY --");
        String wish = in.nextLine();
        if (wish.equalsIgnoreCase("yes")) {
            try {
                productStorage.checkExistenceOfProduct(id, quantity);
            } catch (OutOfStockException e) {
                System.out.println("-- There is not as much product as you have entered --");
                return;
            }
        } else {
            System.out.println("-- Wrong command--");
            return;
        }
        String orderId = UuidUtil.getUuid();
        Order order = new Order(orderId, user, product, sdf.format(new Date()), orderPrice, OrderStatus.NEW, quantity, paymentMethod);
        orderStorage.addOrder(order);
        System.out.println("-- The bought is completed --");
    }

    private static void printMyOrders(User user) {
        System.out.println("-- Here are my orders --");
        orderStorage.printMyOrders(user);
    }

    private static void cancelMyOrder() {
        System.out.println("Id for canceling order...");
        String idForCancel = in.nextLine();
        Order order;
        try {
            order = orderStorage.getOrderById(idForCancel);
        } catch (NotFoundException e) {
            System.out.println("-- Order not found by this Id --");
            return;
        }
        orderStorage.changeOrderStatus(order, OrderStatus.CANCELED);
        System.out.println("-- Order is canceled --");
    }
}
