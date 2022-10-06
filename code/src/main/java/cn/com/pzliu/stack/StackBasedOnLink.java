package cn.com.pzliu.stack;

import cn.com.pzliu.linkedlist.ListNode;

public class StackBasedOnLink <T extends Comparable> implements IStack<T>{

    private ListNode<T> tail = new ListNode<>();

    private int length = 0;


    @Override
    public void push(T value) {
        ListNode<T> node = new ListNode<>(value);

        tail.next = node;
        node.pre = tail;
        tail = tail.next;
        length++;
    }

    @Override
    public T pop() {
        if (isEmpty()){
            throw new IllegalStateException("栈为空，无法操作");
        }
        ListNode<T> result = tail;
        tail = tail.pre;
        tail.next = null;
        length--;

        return result.value;
    }

    @Override
    public T peek() {

        if (isEmpty()){
            throw new IllegalStateException("栈为空，无法操作");
        }

        return tail.value;
    }

    @Override
    public boolean isEmpty() {
        return tail.pre == null;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("StackBasedOnLink{"+"length="+length+ "value:[");

        ListNode p = tail;

        while (p.pre != null){
            sb.append(p.value).append(",");
            p = p.pre;
        }

        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        StackBasedOnLink<Integer> linkStack = new StackBasedOnLink<>();
        linkStack.push(1);
        linkStack.push(2);
        System.out.println(linkStack);
        System.out.println(linkStack.peek());
        System.out.println(linkStack);
        System.out.println(linkStack.pop());
        System.out.println(linkStack);
        System.out.println(linkStack.pop());
        linkStack.peek();
    }
}
