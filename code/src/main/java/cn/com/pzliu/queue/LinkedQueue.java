package cn.com.pzliu.queue;

import cn.com.pzliu.linkedlist.ListNode;

public class LinkedQueue<T extends Comparable> implements IQueue<T> {

    private ListNode<T> head;

    private int length;

    private ListNode<T> tail;

    public LinkedQueue() {
        head = new ListNode<>();
        tail = head;
        length = 0;
    }

    @Override
    public boolean enQueue(T value) {
        // TODO: 2022/10/6 需要研究一下 为什么赋值的方式会导致链表链接不上
//        ListNode<T> listNode = new ListNode<>(value);
//        tail = listNode;
//        tail = tail.next;
        if (isEmpty()){
            tail = head;
        }

        tail.next = new ListNode<>(value);
        tail = tail.next;
        length++;
        return true;
    }

    @Override
    public boolean deQueue() {

        if (isEmpty()){
            return false;
        }

        head.next = head.next.next;
        length--;
        if (isEmpty()){
            tail = head;
        }

        return true;
    }

    @Override
    public T front() {
        if (isEmpty()){
            throw new IllegalStateException("队列为空");
        }

        return head.next.value;
    }

    @Override
    public T rear() {

        if (isEmpty()){
            throw new IllegalStateException("队列为空");
        }

        return tail.value;
    }

    @Override
    public boolean isEmpty() {
        return head.next == null;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("[");

        ListNode<T> p = head.next;
        while (p!=null){
            sb.append(p.value).append(",");
            p = p.next;
        }

        sb.append("]");
        return "LinkedQueue{" +
                "head=" + head +
                "Queue=" + sb +
                ", length=" + length +
                ", tail=" + tail +
                '}';
    }


    public static void main(String[] args) {
        LinkedQueue<Comparable> queue = new LinkedQueue<>();
        System.out.println(queue);
        System.out.println(queue.deQueue());
        queue.enQueue(1);
        System.out.println(queue);
        queue.enQueue(2);
        System.out.println(queue);
        System.out.println(queue.front());
        System.out.println(queue.rear());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue);
        System.out.println(queue.enQueue(3));
        System.out.println(queue);
    }

}
