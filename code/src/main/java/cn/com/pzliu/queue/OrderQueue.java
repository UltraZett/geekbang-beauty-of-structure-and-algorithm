package cn.com.pzliu.queue;


public class OrderQueue<T> implements IQueue<T> {

    private T[] array;
    private int size;
    private int head;
    private int tail;


    public OrderQueue(int size) {
        this.size = size;
        array = (T[]) new Object[size+1];
        this.head=-1;
        this.tail=0;
    }

    @Override
    public boolean enQueue(T value) {
        if (isFull()){
            return false;
        }

        if (this.tail == size ){
            move();
        }

        this.array[tail++] = value;

        return true;
    }

    @Override
    public boolean deQueue() {
        if (isEmpty()){
            return false;
        }

        this.head++;


        return true;
    }

    @Override
    public T front() {
        if (isEmpty()){
            throw new IllegalStateException("队列为空");
        }
        return this.array[head + 1];
    }

    @Override
    public T rear() {
        if (isEmpty()){
            throw new IllegalStateException("队列为空");
        }

        return this.array[tail];
    }

    @Override
    public boolean isEmpty() {
        return head + 1 ==tail;
    }

    @Override
    public boolean isFull() {
        return tail - head -1 == size;
    }


    /**
     * 移动数组
     */
    private void move(){
        int offset = head + 1;
        for (int i = offset; i <= tail; i++) {
            this.array[i-offset] = this.array[i];
        }
        this.tail = tail - offset;
        this.head = -1;
    }


    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("[");

        for (int i = head + 1; i < tail; i++) {
            sb.append(array[i]).append(",");
        }

        sb.append("]");
        return "OrderQueue{" +
                "array=" + sb.toString() +
                ", size=" + size +
                ", head=" + head +
                ", tail=" + tail +
                '}';
    }

    public static void main(String[] args) {
        OrderQueue<Integer> queue = new OrderQueue<Integer>(4);
        System.out.println(queue);
        queue.enQueue(1);
        System.out.println(queue);
        queue.enQueue(2);
        System.out.println(queue);
        queue.enQueue(3);
        System.out.println(queue);
        queue.enQueue(4);
        System.out.println(queue);
        System.out.println(queue.enQueue(5));
        System.out.println(queue.front());
        System.out.println(queue.rear());
        System.out.println(queue.deQueue());
        queue.enQueue(5);
        System.out.println(queue);
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        queue.enQueue(6);
        System.out.println(queue);
    }


}
