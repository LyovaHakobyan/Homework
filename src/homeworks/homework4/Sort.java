package homeworks.homework4;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] array = {4, 7, 1, 3, 9, 0, 2, -9, 648, -941, 0, 68481};
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int c = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = c;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
