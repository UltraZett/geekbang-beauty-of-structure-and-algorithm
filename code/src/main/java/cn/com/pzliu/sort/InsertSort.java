package cn.com.pzliu.sort;

import java.util.Arrays;

/**
 * 插入排序
 * 思想：读取未排序的数据，将其插入到已排序的区间内
 */
public class InsertSort {

    public void sort(int[] array){
        int[] temp = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            boolean isInsert = false;
            for (int j = 0; j < i; j++) {
                if (array[i] < temp[j]){
                    // 插入 跳出
                    insert(array[i],temp,j,i);
                    isInsert = true;
                    break;
                }
            }
            if (!isInsert){
                temp[i] = array[i];
            }
        }

        for (int i = 0; i < temp.length; i++) {
            array[i] = temp[i];
        }

    }

    private void insert(int value, int[] array, int index,int length) {
        for (int i = length - 1; i >=index ; i--) {
            array[i+1] = array[i];
        }
        array[index] = value;
    }


    public static void main(String[] args) {
        InsertSort insertSort = new InsertSort();
        int[] array = {1, 4, 5, 2, 7, 6, 9, 8, 3};
        insertSort.sort(array);
        System.out.println(Arrays.toString(array));
    }

}
