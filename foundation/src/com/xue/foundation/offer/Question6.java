package com.xue.foundation.offer;

import java.util.Stack;

/**
 * 链表的逆序
 *
 */
public class Question6 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        print(node1);
    }

    /**
     * 使用递归
     */
    public static ListNode print(ListNode node) {
        if (node.next == null) {
            System.out.println(node.getVal());
            return node;
        }
        ListNode temp = node.next;
        ListNode newHead = print(node.next);
        temp.next = node;
        node.next = null;
        System.out.println(node.getVal());
        return newHead;
    }


}

