package homeworks.homework3;

public class ArrayUtilTest {
    public static void main(String[] args) {
        int[] numbers = {1, 6, 3, 9, 15, 52, -3, 5, 8};
        ArrayUtil aut = new ArrayUtil();
        aut.sout(numbers);
        System.out.println("The first member is  " + numbers[0]);
        System.out.println("The last member is " + numbers[numbers.length - 1]);
        System.out.println("The length is " + numbers.length);
        aut.smallestnumber(numbers);
        aut.middlenumber(numbers);
        aut.numberofcouple(numbers);
        aut.numberofodd(numbers);
        aut.sum(numbers);
        aut.average(numbers);
    }
}
