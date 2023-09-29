package homeworks.bracechecker;

public class BraceCheckerWithoutStack {
    private String text;

    BraceCheckerWithoutStack(String text) {
        this.text = text;
    }

    private int x = 0;
    private int y = 0;
    private int t = 0;

    public void check() {
        for (int i = text.length() - 1; i > 0; i--) {
            switch (text.charAt(i)) {
                case '(':
                    t--;
                    break;
                case ')':
                    t++;
                    break;
            }
            if (t < 0) {
                System.out.println("Error: (  is opened without being closed " + i);
                t = 0;
            }
        }
        for (int i = 0; i < text.length(); i++) {
            switch (text.charAt(i)) {
                case '(':
                    x++;
                    break;
                case ')':
                    x--;
                    break;
            }
            if (x < 0) {
                System.out.println("Error: )  is closed without being opened " + i);
                x = 0;
            }
        }
        t = 0;
        for (int i = text.length() - 1; i > 0; i--) {
            switch (text.charAt(i)) {
                case '{':
                    t--;
                    break;
                case '}':
                    t++;
                    break;
            }
            if (t < 0) {
                System.out.println("Error: {  is opened without being closed " + i);
                t = 0;
            }
        }
        for (int i = 0; i < text.length(); i++) {
            switch (text.charAt(i)) {
                case '{':
                    y++;
                    break;
                case '}':
                    y--;
                    break;
            }
            if (y < 0) {
                System.out.println("Error: }  is closed without being opened " + i);
                y = 0;
            }
        }
        y = 0;
        t = 0;
        for (int i = text.length() - 1; i > 0; i--) {
            switch (text.charAt(i)) {
                case '[':
                    t--;
                    break;
                case ']':
                    t++;
                    break;
            }
            if (t < 0) {
                System.out.println("Error: [  is opened without being closed " + i);
                t = 0;
            }
        }
        for (int i = 0; i < text.length(); i++) {
            switch (text.charAt(i)) {
                case '[':
                    y++;
                    break;
                case ']':
                    y--;
                    break;
            }
            if (y < 0) {
                System.out.println("Error: ]  is closed without being opened " + i);
                y = 0;
            }
        }
    }
}