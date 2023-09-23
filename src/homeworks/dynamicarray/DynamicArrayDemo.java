package homeworks.dynamicarray;

public class DynamicArrayDemo {
    public static void main(String[] args) {
        DynamicArray da = new DynamicArray();
        for (int i = 0; i < 10; i++) {
            da.add(i);
        }
        da.add(99);
        da.print();
        da.deleteByIndex(0);
        da.print();
        da.set(9, 777);
        da.print();
        da.add(0, 888);
        da.print();
        da.add(11, 888);
        da.print();
        System.out.println(da.exists(777));
        da.add(2, 888);
        da.add(0, 646);
        da.print();
        System.out.println(da.getIndexByValue(1));
        System.out.println(da.exists(1));
        da.add(16);
        da.print();
        da.set(13, 600);
        da.print();
        da.add(0, 444);
        da.print();
        da.deleteByIndex(13);
        da.print();
        System.out.println(da.exists(888));
    }
}
