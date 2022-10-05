package cn.com.pzliu.linkedlist.single_linked_list;

import cn.com.pzliu.linkedlist.ListNode;

import java.util.Objects;

public class CalLinkedListMid {


    public ListNode calMid(ListNode head){
        ListNode p1 = head;
        ListNode p2 = head;

        while (p1!=null&&p2 !=null&&p2.next!=null){
            p1 = p1.next;
            p2 = Objects.isNull(p2.next) ? null:p2.next.next;
        }

        return p1;
    }

    public static void main(String[] args) {
        ListNode<Integer> node1 = new ListNode<Integer>(1);
        ListNode<Integer> node2 = new ListNode<Integer>(2);
        ListNode<Integer> node3 = new ListNode<Integer>(3);
        ListNode<Integer> node4 = new ListNode<Integer>(4);
        ListNode<Integer> node5 = new ListNode<Integer>(5);
        ListNode<Integer> node6 = new ListNode<Integer>(6);
        node1.setNext(node2).setNext(node3).setNext(node4).setNext(node5).setNext(node6);
//        node1.setNext(node2).setNext(node3).setNext(node4).setNext(node5);

        CalLinkedListMid calLinkedListMid = new CalLinkedListMid();
        System.out.println(calLinkedListMid.calMid(node1));


    }
}
