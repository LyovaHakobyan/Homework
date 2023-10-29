package homeworks.onlineMarket;

import homeworks.onlineMarket.models.OrderStatus;
import homeworks.onlineMarket.models.PaymentMethod;
import homeworks.onlineMarket.models.ProductType;
import homeworks.onlineMarket.models.UserType;
import homeworks.onlineMarket.exceptions.NotFoundException;
import homeworks.onlineMarket.exceptions.OutOfStockException;
import homeworks.onlineMarket.interfaces.Command;
import homeworks.onlineMarket.models.Order;
import homeworks.onlineMarket.models.Product;
import homeworks.onlineMarket.models.User;
import homeworks.onlineMarket.storages.OrderStorage;
import homeworks.onlineMarket.storages.ProductStorage;
import homeworks.onlineMarket.storages.UserStorage;
import homeworks.onlineMarket.util.UuidUtil;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.util.UUID;

public class ProductManagement {
    static Scanner in = new Scanner(System.in);
    static UserStorage userStorage = new UserStorage();
    static OrderStorage orderStorage = new OrderStorage();
    static ProductStorage productStorage = new ProductStorage();
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
                case 0:
                    logIn();
                    break;
                case 1:
                    register();
                    break;
                case 2:
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
                userStorage.returnUserByEmail(email);
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
            user = userStorage.returnUserByEmail(email);
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
                case 0:
                    System.out.println("Logout...");
                    process = false;
                    break;
                case 1:
                    addProduct();
                    break;
                case 2:
                    removeProduct();
                    break;
                case 3:
                    printProducts();
                    break;
                case 4:
                    printUsers();
                    break;
                case 5:
                    printOrders();
                    break;
                case 6:
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
                case 0:
                    System.out.println("Logout...");
                    process = false;
                    break;
                case 1:
                    printProducts();
                    break;
                case 2:
                    buyProduct(user);
                    break;
                case 3:
                    printMyOrders(user);
                    break;
                case 4:
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
            order = orderStorage.returnOrderById(orderId);
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
            order = orderStorage.returnOrderById(idForCancel);
        } catch (NotFoundException e) {
            System.out.println("-- Order not found by this Id --");
            return;
        }
        orderStorage.changeOrderStatus(order, OrderStatus.CANCELED);
        System.out.println("-- Order is canceled --");
    }
}
