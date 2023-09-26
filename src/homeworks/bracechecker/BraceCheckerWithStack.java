package homeworks.bracechecker;

public class BraceCheckerWithStack {
    private String text;

    BraceCheckerWithStack(String text) {
        this.text = text;
    }

    Stack stack = new Stack();
    Stack stack2 = new Stack();

    public void check() {
        char temp;
        for (int i = 0; i < text.length(); i++) {
            switch (text.charAt(i)) {
                case '(':
                case '{':
                case '[':
                    stack.push(text.charAt(i));
                    break;
                case ')':
                    temp = stack.pop();
                    if (temp == 0) {
                        System.out.println("Error: closed ) without being opened - " + i);
                    }
                    switch (temp) {
                        case '{':
                            System.out.println("Error: opened { but closed ) - " + i);
                            break;
                        case '[':
                            System.out.println("Error: opened [ but closed ) - " + i);
                            break;
                    }
                    break;
                case '}':
                    temp = stack.pop();
                    if (temp == 0) {
                        System.out.println("Error: closed } without being opened - " + i);
                    }
                    switch (temp) {
                        case '(':
                            System.out.println("Error: opened ( but closed } - " + i);
                            break;
                        case '[':
                            System.out.println("Error: opened [ but closed } - " + i);
                            break;
                    }
                    break;
                case ']':
                    temp = stack.pop();
                    if (temp == 0) {
                        System.out.println("Error: closed ] without being opened - " + i);
                    }
                    switch (temp) {
                        case '{':
                            System.out.println("Error: opened { but closed ] - " + i);
                            break;
                        case '(':
                            System.out.println("Error: opened ( but closed ] - " + i);
                            break;
                    }
                    break;
            }
        }
        for (int i = text.length() - 1; i >= 0; i--) {
            switch (text.charAt(i)) {
                case ')':
                case '}':
                case ']':
                    stack2.push(text.charAt(i));
                    break;
                case '(':
                    temp = stack2.pop();
                    if (temp == 0) {
                        System.out.println("Error: opened ( without being closed - " + i);
                    }
                    break;
                case '{':
                    temp = stack2.pop();
                    if (temp == 0) {
                        System.out.println("Error: opened { without being closed - " + i);
                    }
                    break;
                case '[':
                    temp = stack2.pop();
                    if (temp == 0) {
                        System.out.println("Error: opened [ without being closed - " + i);
                    }
                    break;
            }
        }
    }
}
