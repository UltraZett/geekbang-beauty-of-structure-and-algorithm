package cn.com.pzliu.queue;

public class CircularQueue<T> implements IQueue<T> {


    private T[] array;

    /**
     * 队列长度
     */
    private int size;

    /**
     * 尾指针
     */
    private int tail;

    /**
     * 头指针
     */
    private int head;


    public CircularQueue(int size) {
        this.size = size + 1;
        this.array = (T[]) new Object[this.size];
        this.tail = 0;
        this.head = 0;
    }

    @Override
    public boolean enQueue(T value) {
        if (isFull()){
            return false;
        }

        this.array[tail] = value;
        tail = (tail+1)%size;
        return true;
    }

    @Override
    public boolean deQueue() {
        if (isEmpty()){
            return false;
        }

        head = (head + 1)%size;
        return true;
    }

    @Override
    public T front() {
        if (isEmpty()){
            throw new IllegalStateException("队空");
        }
        return this.array[head];
    }

    @Override
    public T rear() {

        if (isEmpty()){
            throw new IllegalStateException("对空");
        }

        return null;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public boolean isFull() {
        return (tail + 1)%size == head;
    }


    public static void main(String[] args) {
        CircularQueue<Integer> circularQueue = new CircularQueue<>(3);
        System.out.println(circularQueue.enQueue(1));
        System.out.println(circularQueue.enQueue(2));
        System.out.println(circularQueue.enQueue(3));
        System.out.println(circularQueue.enQueue(4));
        System.out.println(circularQueue.rear());
        System.out.println(circularQueue.isFull());
        System.out.println(circularQueue.deQueue());
        System.out.println(circularQueue.enQueue(4));
        System.out.println(circularQueue.rear());

    }

}
