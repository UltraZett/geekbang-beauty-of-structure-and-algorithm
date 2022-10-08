package cn.com.pzliu.sort;

import java.util.Arrays;

/**
 * 选择排序
 * 从未排序区间中找到最小的，放入已排序的末尾
 */
public class SelectSort {

    public void sort(int[] array){
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[minIndex] > array[j]){
                    minIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }


    public static void main(String[] args) {
        SelectSort selectSort = new SelectSort();
        int[] array = {1, 4, 5, 2, 7, 6, 9, 8, 3};
        selectSort.sort(array);
        System.out.println(Arrays.toString(array));
    }

}
