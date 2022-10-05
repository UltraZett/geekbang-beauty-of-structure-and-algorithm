package cn.com.pzliu.linkedlist.double_linked_list;

import cn.com.pzliu.linkedlist.ILinkedList;
import cn.com.pzliu.linkedlist.ListNode;

public class DoubleLinkedList<T extends Comparable> implements ILinkedList {

    private ListNode<T> head;

    private ListNode<T> tail;

    private int length = 0;


    public DoubleLinkedList() {
        head = new ListNode<T>();
        tail = head;
    }

    public void add(ListNode node) {
        tail.next = node;
        node.pre = tail;
        tail = node;
        length++;
    }

    public void insert(ListNode preNode, ListNode insertNode) {
        if (contains(preNode)){
            if (preNode.next == null){
                add(insertNode);
            }else {
                insertNode.next = preNode.next;
                preNode.next.pre = insertNode;
                insertNode.pre = preNode;
                preNode.next = insertNode;
            }
        }else {
            throw new IllegalArgumentException("前驱节点不在链表中");
        }
    }

    private boolean contains(ListNode preNode) {
        ListNode<T> p = this.head;
        while (p != null){
            if (p == preNode){
                return true;
            }else {
                p = p.next;
            }
        }
        return false;
    }

    public void delete(ListNode node) {
        if (contains(node)){
            if (node.next != null){
                ListNode p = node.next;
                node.pre.next = p;
                p.pre = node.pre;
                node = null;
            }else {
                tail = node.pre;
                node.pre.next = null;
                node = null;
            }
        }
    }


    public ListNode<T> getHead() {
        return head;
    }

    public ListNode<T> getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder( "DoubleLinkedList{" +
                "head=" + head +
                ", tail=" + tail +
                ", length=" + length +
                '}');
        sb.append("\n");

        ListNode p = head;
        sb.append("[");
        while (p != null){
            sb.append(p.toString()+",");
            p = p.next;
        }
        sb.append("]");
        return sb.toString();

    }
}
