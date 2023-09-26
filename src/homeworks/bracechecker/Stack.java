package homeworks.bracechecker;

public class Stack {
    private char[] array = new char[10];
    private int size;

    Stack() {
        size = -1;
    }

    public void push(char smth) {
        if (size == array.length - 1) {
            extend();
        }
        array[++size] = smth;
    }

    public char pop() {
        if (size < 0) {
            return 0;
        }
        return array[size--];
    }

    private void extend() {
        char[] temp = new char[array.length + 10];
        for (int i = 0; i < array.length; i++) {
            temp[i] = array[i];
        }
        array = temp;
    }
}
