package cn.com.pzliu.linkedlist.single_linked_list;

import cn.com.pzliu.linkedlist.ListNode;

public class Demo {

    public static void main(String[] args) {
        SingleLinkedList<Integer> linkedList = new SingleLinkedList<Integer>();
        System.out.println("1"+linkedList);
        ListNode<Integer> node1 = new ListNode<Integer>(1);
        ListNode<Integer> node2 = new ListNode<Integer>(2);
        ListNode<Integer> node3 = new ListNode<Integer>(3);
        ListNode<Integer> node4 = new ListNode<Integer>(4);
        ListNode<Integer> node5 = new ListNode<Integer>(5);
        ListNode<Integer> node6 = new ListNode<Integer>(6);
        System.out.println("2"+linkedList);
        linkedList.add(node1);
        linkedList.add(node2);
        System.out.println("3"+linkedList);
        linkedList.add(node3);
        linkedList.add(node4);
        System.out.println("4"+linkedList);
        linkedList.add(node5);
        System.out.println("5"+linkedList);
        linkedList.insert(node1,node6);
        System.out.println("6"+linkedList);
        linkedList.delete(node1);
        System.out.println("7"+linkedList);

    }
}
