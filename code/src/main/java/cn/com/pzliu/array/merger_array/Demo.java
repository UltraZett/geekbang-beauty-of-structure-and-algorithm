package cn.com.pzliu.array.merger_array;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        Integer[] array1 = {1,4,6,7};
        Integer[] array2 = {2,3,5,8,10};

        Merger<Integer> merger = new Merger<Integer>();
        Object[] merger1 = merger.merger(array1, new Integer[0]);
        System.out.println(Arrays.toString(merger1));
        Object[] merger2 = merger.merger(new Integer[0], array2);
        System.out.println(Arrays.toString(merger2));

        Object[] merger3 = merger.merger(array1, array2);
        System.out.println(Arrays.toString(merger3));

    }
}
