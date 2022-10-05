package cn.com.pzliu.linkedlist.single_linked_list;

import cn.com.pzliu.linkedlist.ListNode;

public class MergerLinkedList {

    public ListNode merger(ListNode list1 ,ListNode list2){
        ListNode head = new ListNode();
        ListNode p = head;
        while (list1 != null || list2 != null){

            ListNode min;

            if (list1 == null){
                p.next = list2;
                break;
            } else if (list2 == null){
                p.next = list1;
                break;
            }else {
                if (list1.value.compareTo(list2.value) > 0){
                    min = list2;
                    list2 = list2.next;
                }else {
                    min = list1;
                    list1 = list1.next;

                }
                min.next =null;
                p.next = min;
                p = p.next;
            }
        }

        return head;
    }


    public static void main(String[] args) {
        ListNode<Integer> node1 = new ListNode<Integer>(1);
        ListNode<Integer> node2 = new ListNode<Integer>(2);
        ListNode<Integer> node3 = new ListNode<Integer>(3);
        ListNode<Integer> node4 = new ListNode<Integer>(4);
        ListNode<Integer> node5 = new ListNode<Integer>(5);
        ListNode<Integer> node6 = new ListNode<Integer>(6);
        ListNode<Integer> node7 = new ListNode<Integer>(7);
        ListNode<Integer> node8 = new ListNode<Integer>(8);
        ListNode<Integer> node9 = new ListNode<Integer>(9);
        ListNode<Integer> node10 = new ListNode<Integer>(10);

        node1.setNext(node4).setNext(node5).setNext(node9).setNext(node10);
        // list1 为空
        MergerLinkedList mergerLinkedList = new MergerLinkedList();
        System.out.println(mergerLinkedList.merger(node1, null));
        // 一场一短
        node2.setNext(node3).setNext(node6).setNext(node7).setNext(node8);
        System.out.println(mergerLinkedList.merger(node1, node2));

    }

}
