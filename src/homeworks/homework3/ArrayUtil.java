package homeworks.homework3;

public class ArrayUtil {
    void sout(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    void smallestnumber(int[] array) {
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        System.out.println("The smallest member is " + min);
    }

    void middlenumber(int[] array) {
        if (array.length > 2) {
            if (array.length % 2 != 0) {
                System.out.println("The middle number is " + array[(array.length - 1) / 2]);
            } else {
                System.out.println("The middle numbers are " + array[(array.length - 1) / 2] + " and " + array[(array.length - 1) / 2 + 1]);
            }
        } else {
            System.out.println("Can't print middle values");
        }
    }

    void numberofcouple(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                sum++;
            }
        }
        System.out.println("The number of couple numbers is " + sum);
    }

    void numberofodd(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                sum++;
            }
        }
        System.out.println("The number of odd numbers is " + sum);
    }

    void sum(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        System.out.println("The sum is " + sum);
    }

    void average(int[] array) {
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        sum /= (double) (array.length);
        System.out.println("The middle sum is " + sum);
    }
}