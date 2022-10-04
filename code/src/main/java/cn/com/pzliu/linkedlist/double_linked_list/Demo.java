package cn.com.pzliu.linkedlist.double_linked_list;

import cn.com.pzliu.linkedlist.ListNode;

public class Demo {

    public static void main(String[] args) {
        DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<Integer>();

        ListNode<Integer> node1 = new ListNode<Integer>(1);
        ListNode<Integer> node2 = new ListNode<Integer>(2);
        ListNode<Integer> node3 = new ListNode<Integer>(3);
        ListNode<Integer> node4 = new ListNode<Integer>(4);
        ListNode<Integer> node5 = new ListNode<Integer>(5);
        ListNode<Integer> node6 = new ListNode<Integer>(6);

        System.out.println(doubleLinkedList);

        doubleLinkedList.add(node1);
        doubleLinkedList.add(node2);
        doubleLinkedList.add(node3);
        doubleLinkedList.add(node4);
        System.out.println(doubleLinkedList);
        doubleLinkedList.insert(node4,node5);
        System.out.println(doubleLinkedList);
        doubleLinkedList.insert(node2,node6);
        System.out.println(doubleLinkedList);
        doubleLinkedList.delete(node1);
        System.out.println(doubleLinkedList);

    }

}
