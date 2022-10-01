package cn.com.pzliu.array.dynamic_array;

public class Demo {
    public static void main(String[] args) {
        DynamicArray<Integer> array = new DynamicArray<Integer>(1);
        array.add(1);
        System.out.println(array.toString());
        array.add(10);
        System.out.println(array.toString());
        array.insert(1,3);
        System.out.println(array.toString());
        System.out.println("获取到"+array.get(1));
        array.remove(0);
        System.out.println(array.toString());
        array.get(2);
    }
}
