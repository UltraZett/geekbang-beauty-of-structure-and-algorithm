package cn.com.pzliu.array.fix_sorted_array;

import cn.com.pzliu.array.IArray;

import java.util.Arrays;


/**
 * 定长的排序数组
 *
 * @Auth pzliu
 */
public class FixedSortedArray<T extends Comparable> implements IArray<T> {
    private Object[] array;
    private final int size;
    private int tail = -1;

    public FixedSortedArray(int size) {
        this.size = size;
        this.array = new Object[size];
    }

    public int getCapacity() {
        return size;
    }

    public int getCount() {
        return tail + 1;
    }

    public boolean isEmpty() {
        return tail == -1;
    }

    public void set(int index, T e) {
        checkIndex(index);
        checkElement(index, e);
        this.array[index] = e;
    }

    private void checkElement(int index, T e) {
        if (index == size -1){
            if (e.compareTo(this.array[index -1])>=0){
                return;
            }else {
                throw new IllegalArgumentException("破坏了数组的有序性，无法将该元素设置在次处");
            }

        }

        if (index == 0){
            if (e.compareTo(this.array[index +1])<=0){
                return;
            }else {
                throw new IllegalArgumentException("破坏了数组的有序性，无法将该元素设置在次处");
            }

        }

        if ((e.compareTo(this.array[index-1]) >=0) && e.compareTo(this.array[index + 1]) <=0){
            return;
        }else {
            throw new IllegalArgumentException("破坏了数组的有序性，无法将该元素设置在次处");
        }
    }

    public T get(int index) {
        checkIndex(index);
        return(T) array[index];
    }

    public boolean contains(T e) {
        // TODO: 2022/10/1 此处可用二分搜索优化
        for (int i = 0; i <= tail; i++) {
            if (this.array[i].equals(e)){
                return true;
            }
        }

        return false;
    }

    public int find(T e) {
        // TODO: 2022/10/1 此处可以用二分查找优化
        for (int i = 0; i <= tail; i++) {
            if (this.array[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    public void add(T e) {

        this.insert(tail+1,e);
    }

    public void insert(int index, T e) {
        // TODO: 2022/10/1 可优化
        checkIndex(index);
        if (isFull()){
            throw new IllegalArgumentException("数组已满,无法再继续插入");
        }

        if (isEmpty()){
            this.array[++tail] =e;
            return;
        }

        boolean isInsert = false;
        for (int i = 0; i <= tail; i++) {
            if (((T)this.array[i]).compareTo(e)>=0){
                //此时可插入
                for (int j = tail; j >=i ; j--) {
                    array[j+1] = array[j];
                }
                this.array[i] = e;
                tail++;
                isInsert = true;
                break;
            }
        }

        if (!isInsert){
            this.array[++tail] = e;
        }
    }

    private boolean isFull() {
        return tail + 1 == size;
    }

    public void remove(int index) {
        checkIndex(index);

        for (int i = index; i < tail; i++) {
            this.array[i] = this.array[i +1];
        }
        this.array[tail] = null;
        tail--;

    }


    private void checkIndex(int index){
        if (index <0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
    }


    @Override
    public String toString() {
        return "FixedSortedArray{" +
                "array=" + Arrays.toString(array) +
                ", size=" + size +
                ", tail=" + tail +
                '}';
    }
}
