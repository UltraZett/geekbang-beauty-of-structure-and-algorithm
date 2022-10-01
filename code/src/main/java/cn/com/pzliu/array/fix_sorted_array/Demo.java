package cn.com.pzliu.array.fix_sorted_array;

public class Demo {


    public static void main(String[] args) {

//        FixedSortedArray<Integer> array = new FixedSortedArray<Integer>(2);
//
//        array.add(5);
//        System.out.println(array.toString());
//        array.add(2);
//        System.out.println(array.toString());
//        array.add(10);
//        System.out.println(array.toString());


//        FixedSortedArray<Integer> array = new FixedSortedArray<Integer>(3);
//
//        array.add(5);
//        System.out.println(array.toString());
//        array.add(2);
//        System.out.println(array.toString());
//        array.add(10);
//        System.out.println(array.toString());
//        array.remove(0);
//        System.out.println(array.toString());
//        array.remove(2);
//        System.out.println(array.toString());


        FixedSortedArray<Integer> array = new FixedSortedArray<Integer>(3);

        array.add(5);
        System.out.println(array.toString());
        array.add(2);
        System.out.println(array.toString());
        array.insert(0,10);
        System.out.println(array.toString());


    }

}
