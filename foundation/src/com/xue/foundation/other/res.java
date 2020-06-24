package com.xue.foundation.other;

import java.util.LinkedList;
import java.util.List;

public class res {


    public static void main(String[] args) {
        ListNode root = new ListNode();
        ListNode node1 = new ListNode();
        ListNode node2 = new ListNode();
        ListNode node3 = new ListNode();
        root.setVal(1);
        node1.setVal(2);
        node2.setVal(3);
        node3.setVal(4);
        root.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        System.out.println(re(root).val);
    }

    public static ListNode re(ListNode node){
        if (node.next == null) {
            return node;
        }
        ListNode node1 = node.next;
        ListNode temp = re(node.getNext());
        node1.next = node;
        node.next = null;
        return temp;
    }
}

class ListNode{
    int val;

    ListNode next;

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
