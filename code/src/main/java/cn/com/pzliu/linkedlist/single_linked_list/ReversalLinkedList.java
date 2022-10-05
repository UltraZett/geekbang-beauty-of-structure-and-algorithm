package cn.com.pzliu.linkedlist.single_linked_list;

import cn.com.pzliu.linkedlist.ListNode;

public class ReversalLinkedList {


    public ListNode reversal(ListNode list){
        ListNode tail = list;

        while (tail.next != null){
            tail = tail.next;
        }

        ListNode head = list;

        while (head != tail){
            // 头插法翻转
            ListNode temp = head;
            head = head.next;
            headInsert(tail,temp);
        }
        return tail;
    }

    private void headInsert(ListNode tail, ListNode temp) {
        temp.next = tail.next;
        tail.next =temp;
    }


    public static void main(String[] args) {
        ListNode<Integer> node1 = new ListNode<Integer>(1);
        ListNode<Integer> node2 = new ListNode<Integer>(2);
        ListNode<Integer> node3 = new ListNode<Integer>(3);
        ListNode<Integer> node4 = new ListNode<Integer>(4);
        ListNode<Integer> node5 = new ListNode<Integer>(5);
        ListNode<Integer> node6 = new ListNode<Integer>(6);

        node1.setNext(node2).setNext(node3).setNext(node4).setNext(node5).setNext(node6);
        System.out.println(node1);

        ReversalLinkedList reversalLinkedList = new ReversalLinkedList();
        System.out.println(reversalLinkedList.reversal(node1));
    }
}
