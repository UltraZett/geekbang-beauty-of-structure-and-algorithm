package cn.com.pzliu.linkedlist;


import java.util.Comparator;

public class ListNode <T extends Comparable> {

    public T value;

    public ListNode<T> next;

    public ListNode<T> pre;

    public ListNode() {
    }

    public ListNode(T value) {
        this.value = value;
    }


    public ListNode setNext(ListNode<T> next) {
        this.next = next;
        return next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "value=" + value +
                '}';
    }
}
