package homeworks.bracechecker;

public class BraceCheckerTest {
    public static void main(String[] args) {
        BraceCheckerWithStack braceCheckerWithStack = new BraceCheckerWithStack("Hello ({)[wor]l)t");
        BraceCheckerWithoutStack braceCheckerWithoutStack = new BraceCheckerWithoutStack("Hello ({)[wor]l((((]))})t");
        braceCheckerWithStack.check();
    }
}
