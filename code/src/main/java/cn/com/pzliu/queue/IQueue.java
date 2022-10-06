package cn.com.pzliu.queue;

public interface IQueue<T> {

    boolean enQueue(T value);

    boolean deQueue();

    T front();

    T rear();

    boolean isEmpty();

    boolean isFull();
}
