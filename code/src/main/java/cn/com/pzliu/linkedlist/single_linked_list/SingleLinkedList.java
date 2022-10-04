package cn.com.pzliu.linkedlist.single_linked_list;

import cn.com.pzliu.linkedlist.ILinkedList;
import cn.com.pzliu.linkedlist.ListNode;

/**
 * 单链表的实现
 *
 * @param <T>
 */
public class SingleLinkedList<T> implements ILinkedList {

    private ListNode<T> head = new ListNode<T>();

    private ListNode<T> tail = head;

    private int length = 0;

    public SingleLinkedList() {
    }


    public void add(ListNode node) {
        tail.next = node;
        tail = tail.next;
        length++;
    }

    public void insert(ListNode preNode, ListNode insertNode) {
        ListNode p = this.head;
        while (p != null){
            if (p == preNode){
                // 插入
                if (p.next != null) {
                    insertNode.next = p.next;
                }
                p.next = insertNode;
                if (tail.next != null){
                    tail = tail.next;
                }
                length++;
                return;
            }else {
                p = p.next;
            }
        }

        throw new IllegalArgumentException("未找到前驱节点，无法插入");
    }

    public void delete(ListNode node) {
        ListNode<T> p = this.head;
        while (p != null) {
            if (p.equals(node)) {
                if (p.next == null) {
                    // 是最后一个节点，把自己释放掉
                    p = null;
                } else {
                    //不是最后一个节点
                    p.next = p.next.next;
                }
                length--;
                return;
            } else {
                p = p.next;
            }
        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder( "SingleLinkedList{" +
                "head=" + head +
                ", tail=" + tail +
                ", length=" + length +
                '}');
        sb.append("\n");

        ListNode p = head;
        sb.append("[");
        while (p != null){
            sb.append(p.value+",");
            p = p.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
