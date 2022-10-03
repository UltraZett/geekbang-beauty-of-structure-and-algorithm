package cn.com.pzliu.linkedlist;


public class ListNode <T>{

    public T value;

    public ListNode<T> next;


    public ListNode() {
    }

    public ListNode(T value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return "ListNode{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }
}
