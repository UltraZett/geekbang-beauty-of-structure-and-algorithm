package cn.com.pzliu.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * 思想：相邻的元素相互比较然后进行交换
 */
public class BubbleSort {

    public void sort(int[] array){

        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[i]>array[j]){
                    //交换
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

    }


    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] array = {1, 4, 5, 2, 7, 6, 9, 8, 3};
        bubbleSort.sort(array);
        System.out.println(Arrays.toString(array));
    }

}
