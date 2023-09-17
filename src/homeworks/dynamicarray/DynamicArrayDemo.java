package homeworks.dynamicarray;

public class DynamicArrayDemo {
    public static void main(String[] args) {
        DynamicArray da = new DynamicArray();
        for (int i = 0; i < 10; i++) {
            da.add(i);
        }
        da.print();
        da.add(77);
        System.out.println();
        da.print();
        System.out.println();
        int temp = da.getByIndex(99);
        System.out.println(temp);
    }
}
