package homeworks.onlineMarket.interfaces;

public interface Command {
    static void loginRegisterCommands() {
        System.out.println("-- Press 0: LOGIN --");
        System.out.println("-- Press 1: REGISTER --");
        System.out.println("-- Press 2: FINISH PROCESS --");
    }

    static void adminCommands() {
        System.out.println("-- Press 0: LOGOUT --");
        System.out.println("-- Press 1: ADD PRODUCT --");
        System.out.println("-- Press 2: REMOVE PRODUCT BY ID --");
        System.out.println("-- Press 3: PRINT ALL PRODUCTS --");
        System.out.println("-- Press 4: PRINT USERS --");
        System.out.println("-- Press 5: PRINT ORDERS --");
        System.out.println("-- Press 6: CHANGE ORDER STATUS --");
    }

    static void userCommands() {
        System.out.println("-- Press 0: LOGOUT --");
        System.out.println("-- Press 1: PRINT ALL PRODUCTS --");
        System.out.println("-- Press 2: BUY PRODUCT --");
        System.out.println("-- Press 3: PRINT MY ORDERS --");
        System.out.println("-- Press 4: CANCEL MY ORDER BY ID --");
    }
}
