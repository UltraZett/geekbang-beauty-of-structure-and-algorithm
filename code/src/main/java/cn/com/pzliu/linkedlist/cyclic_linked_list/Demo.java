package cn.com.pzliu.linkedlist.cyclic_linked_list;

import cn.com.pzliu.linkedlist.ListNode;

public class Demo {


    public static void main(String[] args) {
        CyclicLinkedList<Integer> cyclicLinkedList = new CyclicLinkedList<Integer>();

        ListNode<Integer> node1 = new ListNode<Integer>(1);
        ListNode<Integer> node2 = new ListNode<Integer>(2);
        ListNode<Integer> node3 = new ListNode<Integer>(3);
        ListNode<Integer> node4 = new ListNode<Integer>(4);
        ListNode<Integer> node5 = new ListNode<Integer>(5);
        ListNode<Integer> node6 = new ListNode<Integer>(6);

        System.out.println(cyclicLinkedList);

        cyclicLinkedList.add(node1);
        cyclicLinkedList.add(node2);
        cyclicLinkedList.add(node3);
        cyclicLinkedList.add(node4);
        System.out.println(cyclicLinkedList);
        cyclicLinkedList.insert(node4,node5);
        System.out.println(cyclicLinkedList);
        cyclicLinkedList.insert(node2,node6);
        System.out.println(cyclicLinkedList);
        cyclicLinkedList.delete(node1);
        System.out.println(cyclicLinkedList);

    }

}
