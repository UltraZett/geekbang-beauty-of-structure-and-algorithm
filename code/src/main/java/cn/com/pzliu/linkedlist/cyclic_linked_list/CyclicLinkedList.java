package cn.com.pzliu.linkedlist.cyclic_linked_list;

import cn.com.pzliu.linkedlist.ILinkedList;
import cn.com.pzliu.linkedlist.ListNode;

public class CyclicLinkedList<T> implements ILinkedList {

    private ListNode<T> head;

    private ListNode<T> tail;

    private int length = 0;

    public CyclicLinkedList() {
        head = new ListNode<T>();
        this.tail = head;
        this.tail.next = this.head;
    }

    public boolean isEmpty(){
        return this.head.next == this.head;
    }


    public void add(ListNode node) {
        node.next = head;
        this.tail.next = node;
        this.tail = node;
        length++;
    }

    public void insert(ListNode preNode, ListNode insertNode) {
        if (preNode == this.tail){
            this.add(insertNode);
            return;
        }else {
            // 和单链表一样
            ListNode p = this.head.next;
            while (p != this.head){

                if (p.next == preNode){
                    insertNode.next = preNode.next;
                    preNode.next = insertNode;
                    length++;
                    return;
                }else {
                    p = p.next;
                }

            }
        }
        throw new IllegalArgumentException("前驱节点在链表中不存在。");
    }

    public void delete(ListNode node) {
        ListNode p = this.head;

        while (p.next != this.head){
            if (p.next == node){
                if (node == tail){
                    // 最后一个节点
                    p.next = this.head;
                    this.tail = p;
                }else {
                    // 其他节点 正常删除
                    p.next = p.next.next;
                }
                length--;
                break;
            }else {
                p = p.next;
            }
        }

    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        ListNode p = head.next;
        sb.append("[").append(head);
        while (p != head){
            sb.append(p.toString()+",");
            p = p.next;
        }
        sb.append("]");
        return sb.toString();

    }

}
