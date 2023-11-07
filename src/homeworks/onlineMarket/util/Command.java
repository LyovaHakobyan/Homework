package homeworks.onlineMarket.util;

public interface Command {
    int LOG_IN = 0;
    int REGISTER = 1;
    int FINISH_PROCESS = 2;
    int LOGOUT = 0;
    int ADD_PRODUCT = 1;
    int REMOVE_PRODUCT = 2;
    int PRINT_PRODUCTS = 3;
    int PRINT_USERS = 4;
    int PRINT_ORDERS = 5;
    int CHANGE_ORDER_STATUS = 6;
    int PRINT_MY_ORDERS = 1;
    int BUY_PRODUCT = 2;
    int CANCEL_ORDER = 4;


    static void loginRegisterCommands() {
        System.out.println("-- Press " + LOG_IN + ": LOGIN --");
        System.out.println("-- Press " + REGISTER + ": REGISTER --");
        System.out.println("-- Press " + FINISH_PROCESS + ": FINISH PROCESS --");
    }

    static void adminCommands() {
        System.out.println("-- Press " + LOGOUT + ": LOGOUT --");
        System.out.println("-- Press " + ADD_PRODUCT + ": ADD PRODUCT --");
        System.out.println("-- Press " + REMOVE_PRODUCT + ": REMOVE PRODUCT BY ID --");
        System.out.println("-- Press " + PRINT_PRODUCTS + ": PRINT ALL PRODUCTS --");
        System.out.println("-- Press " + PRINT_USERS + ": PRINT USERS --");
        System.out.println("-- Press " + PRINT_ORDERS + ": PRINT ORDERS --");
        System.out.println("-- Press " + CHANGE_ORDER_STATUS + ": CHANGE ORDER STATUS --");
    }

    static void userCommands() {
        System.out.println("-- Press " + LOGOUT + ": LOGOUT --");
        System.out.println("-- Press " + PRINT_MY_ORDERS + ": PRINT MY ORDERS --");
        System.out.println("-- Press " + BUY_PRODUCT + ": BUY PRODUCT --");
        System.out.println("-- Press " + PRINT_PRODUCTS + ": PRINT ALL PRODUCTS --");
        System.out.println("-- Press " + CANCEL_ORDER + ": CANCEL MY ORDER BY ID --");
    }
}
