package cn.com.pzliu.array;

public interface IArray<T> {

    int getCapacity();

    int getCount();

    boolean isEmpty();

    void set(int index, T e);

    T get(int index);


    boolean contains(T e);

    int find(T e);


    void add(T e);


    void remove(int index);
}
