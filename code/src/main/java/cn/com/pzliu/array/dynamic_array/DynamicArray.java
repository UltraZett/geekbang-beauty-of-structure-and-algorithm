package cn.com.pzliu.array.dynamic_array;

import java.util.Arrays;

/**
 * 支持动态扩容的数组
 *
 * @Autho pzliu
 */
public class DynamicArray<T> {

    private Object[] array;
    private int size;

    private int tail = -1;

    private static final int DEFAULT_SIZE = 20;

    public DynamicArray(int size) {
        this.size = size;
        this.array = new Object[size];
    }


    public DynamicArray() {
        this(DEFAULT_SIZE);
    }

    public int getSize() {
        return size;
    }

    public int getTail() {
        return tail;
    }

    /**
     * 添加元素
     * @param e
     */
    public void add(T e){
        if (tail == size - 1){
            capacityExpansion();
        }
        this.array[++tail] = e;
    }


    /**
     * 指定位置插入一个元素
     * @param i
     * @param e
     */
    public void insert(int i,T e){
        if (tail == size - 1){
            capacityExpansion();
        }

        for (int j = tail + 1; j > i; j--) {
            this.array[j] = this.array[j-1];
        }

        this.array[i] = e;
        tail++;
    }


    /**
     * 获取index位置的元素
     * @param i index
     * @return
     */
    public T get(int i){
        if (i<0||i >= size){
            throw new IndexOutOfBoundsException();
        }
        return (T)this.array[i];
    }


    private boolean isEmpty(){
        return tail == -1;
    }

    /**
     * 修改一个位置的元素
     * @param i
     * @param e
     */
    public void set(int i,T e){
        if (i<0||i >= size){
            throw new IndexOutOfBoundsException();
        }
        this.array[i] = e;
    }


    @Override
    public String toString() {
        return "DynamicArray{" +
                "array=" + Arrays.toString(array) +
                ", size=" + size +
                ", tail=" + tail +
                '}';
    }

    /**
     * 删除一个元素
     * @param i
     */
    public void remove(int i){

        if (i<0||i>tail){
            throw new IndexOutOfBoundsException();
        }

        if (i == tail){

        }else {
            for (int j = i; j < tail; j++) {
                this.array[j] = this.array[j + 1];
            }
        }
        tail--;
    }

    /**
     * 扩容
     */
    private void capacityExpansion(){
        size = size * 2;
        Object[] newArray = new Object[size];

        for (int i = 0; i < this.array.length; i++) {
            newArray[i] = array[i];
        }

        this.array = newArray;
    }

}
