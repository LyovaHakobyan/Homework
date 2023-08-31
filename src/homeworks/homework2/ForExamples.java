package homeworks.homework2;

public class ForExamples {
    public static void main(String[] args) {
        char simvol = '-';
        for (int i = 1; i < 1001; i++) {
            System.out.print(i);
            if (i < 1000) {
                System.out.print(simvol);
            }
        }
        System.out.println();
        System.out.println();
        for (int i = 1; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
        System.out.println();
        int[] array = {2, 5, 8, 4, 9, 3, 7};
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            max = array[i] > max ? array[i] : max;
        }
        System.out.print(max);
    }
}
