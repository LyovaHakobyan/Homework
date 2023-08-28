package homework1;

public class FigurePainter {
    public static void main(String[] args) {
        byte sizeoftringle = 5;
        int a = 0;
        char empty = ' ';
        for (int i = 0; i < sizeoftringle; i++) {
            a++;
            for (int j = 0; j < a; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i < sizeoftringle; i++) {
            for (int j = 0; j < a; j++) {
                System.out.print("*");
            }
            a--;
            System.out.println();
        }
        a++;
        for (int i = 0; i < sizeoftringle; i++) {
            for (int j = 0; j < sizeoftringle - a; j++) {
                System.out.print(empty);
            }
            a++;
            for (int j = 0; j < i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
        a = 0;
        for (int i = 0; i < sizeoftringle; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(empty);
            }
            for (int j = 0; j < sizeoftringle - a; j++) {
                System.out.print("*");
            }
            a++;
            System.out.println();
        }
        int b = 0;
        int c = 5;
        System.out.println();
        for (int p = 0; p < 5; p++) {
            c--;
            for (int i = 0; i < c; i++) {
                System.out.print(" ");
            }
            b++;
            for (int i = 0; i < b; i++) {
                System.out.print("* ");
            }
            for (int i = 0; i < c; i++) {
                System.out.print(" ");
            }
            System.out.println();
        }
        for (int i = 0; i < 4; i++) {
            for (int q = 0; q < c; q++) {
                System.out.print(" ");
            }
            c++;
            b--;
            for (int j = 0; j < b; j++) {
                System.out.print(" *");
            }
            for (int k = 0; k < c; k++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
