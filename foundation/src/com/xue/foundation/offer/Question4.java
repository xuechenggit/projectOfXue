package com.xue.foundation.offer;

import java.util.Stack;

/**
 * 打印链表
 * 从尾到头反过来打印单链表的值
 *
 * 算法思想：第一种使用递归
 *           第二种使用栈
 */
public class Question4 {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1, null);
        ListNode listNode2 = new ListNode(2, listNode1);
        ListNode listNode3 = new ListNode(3, listNode2);
        printList(listNode3);
        printStack(listNode3);
    }

    public static void printList(ListNode listNode) {
        if (listNode.next != null) {
            printList(listNode.next);
        }
        System.out.println(listNode.val);
    }

    public static void printStack(ListNode listNode) {
        Stack stack = new Stack();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }

    }
}
class ListNode{
    int val;
    ListNode next;
    public ListNode(int val){
        this.val = val;
        next = null;
    }
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
