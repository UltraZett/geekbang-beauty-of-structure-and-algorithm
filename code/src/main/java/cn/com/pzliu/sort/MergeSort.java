package cn.com.pzliu.sort;

import java.util.Arrays;

/**
 * 归并排序
 * 分割
 * 合并
 */
public class MergeSort {

    public void sort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    private void mergeSort(int[] array, int low, int high) {
        // 终止条件
        if (high <= low) {
            return;
        }
        //分
        int mid = (low + high) / 2;
        mergeSort(array, low, mid);
        mergeSort(array, mid + 1, high);
        //合并
        merge(array, low, mid, high);
    }

    /**
     * 这是两个待合并的有序数组
     * array[low,mid]
     * array[mid+1,high]
     *
     * @param array
     * @param low
     * @param mid
     * @param high
     */
    private void merge(int[] array, int low, int mid, int high) {
        int p = low;
        int q = mid + 1;
        int index = 0;
        int[] temp = new int[high - low + 1];
        while (p <= mid && q <= high) {
            if (array[p] < array[q]) {
                temp[index] = array[p];
                p++;
            } else {
                temp[index] = array[q];
                q++;
            }
            index++;
        }

        int start = p;
        int end = mid;
        if (q<=high){
            start = q;
            end = high;
        }

        while (start <= end){
            temp[index++] = array[start++];
        }

        int j = 0;
        for (int i = low; i <= high; i++) {
            array[i] = temp[j];
            j++;
        }

    }


    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] array = {1, 4, 5, 2, 7, 6, 9, 8, 3};
        mergeSort.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
