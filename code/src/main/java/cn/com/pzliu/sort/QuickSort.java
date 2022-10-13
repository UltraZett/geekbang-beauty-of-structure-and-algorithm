package cn.com.pzliu.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 选择一个区分点，小的放左边，大的放右边
 */
public class QuickSort {

    public void sort(int[] array){
        quickSort(array,0,array.length - 1);

    }

    private void quickSort(int[] array, int start, int end) {
        if (start >= end){
            return;
        }
        int pivot = partition(array,start,end);
        quickSort(array,start,pivot -1);
        quickSort(array,pivot + 1,end);
    }

    /**
     * 分区函数——非原地算法，将小于的放入左边，大于的放入右边
     * @param array
     * @param start
     * @param end
     * @return
     */
    private int partition(int[] array, int start, int end) {
        Random random = new Random();
        int partition = random.nextInt(end - start) + start;
        int value = array[partition];
        System.out.println(Arrays.toString(array));
        System.out.println("Start:"+start+",End:"+end+",partition:"+partition+",value:"+value);
        int[] a=new int[end -start];
        int[] b=new int[end - start];
        int aIndex = 0;
        int bIndex = 0;
        for (int i = start; i <= end; i++) {
            if (array[i] == array[partition]){
                continue;
            }
            if (array[i] > array[partition]){
                a[aIndex] = array[i];
                aIndex++;
            }else {
                b[bIndex] = array[i];
                bIndex++;
            }
        }

        int index = start;
        for (int i = 0; i <bIndex; i++) {
            array[index] = b[i];
            index++;
        }
        array[index] = value;
        partition = index;
        index++;

        for (int i = 0; i < aIndex; i++) {
            array[index] = a[i];
            index++;
        }

        System.out.println(Arrays.toString(array));
        return partition;
    }


    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] array = {1, 4, 5, 2, 7, 6, 9, 8, 3};
        quickSort.sort(array);
        System.out.println(Arrays.toString(array));
    }

}
