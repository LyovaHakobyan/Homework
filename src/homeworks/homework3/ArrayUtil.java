package homeworks.homework3;

public class ArrayUtil {
    public static void main(String[] args) {
        int[] numbers = {1, 6, 3, 9, 15, 52, -3, 5, 8};
        int length = 0;
        int first = 0;
        int last = 0;
        int odd = 0;
        int couple = 0;
        int sum = 0;
        int smallest = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
            if (i == 0) {
                first = numbers[i];
            }
            if (i == numbers.length - 1) {
                System.out.println();
                last = numbers[numbers.length - 1];
            }
            if (smallest > numbers[i]) {
                smallest = numbers[i];
            }
            if (numbers[i] % 2 == 0) {
                couple++;
            } else {
                odd++;
            }
            sum += numbers[i];
            length++;
        }
        System.out.println("The first member is  " + first);
        System.out.println("The last member is " + last);
        System.out.println("The length is " + length);
        System.out.println("The smallest member is " + smallest);
        if (numbers.length > 2) {
            if (numbers.length % 2 != 0) {
                System.out.println("The middle number is " + numbers[(numbers.length - 1) / 2]);
            } else {
                System.out.println("The middle numbers are " + numbers[(numbers.length - 1) / 2] + " and " + numbers[(numbers.length - 1) / 2 + 1]);
            }
        } else {
            System.out.println("Can't print middle values");
        }
        System.out.println("The number of couple numbers is " + couple);
        System.out.println("The number of odd numbers is " + odd);
        System.out.println("The sum is " + sum);
        double middle = (double) sum / numbers.length;
        System.out.println("The middle sum is " + middle);
    }
}
