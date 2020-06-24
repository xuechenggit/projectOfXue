package com.xue.foundation.tree;

public class AVLNode {

    public int data;

    public int depth;

    public int balance;

    public AVLNode left;

    public AVLNode right;

    public AVLNode parent;

    public AVLNode(int data) {
        this.data = data;
        depth = 1;
        balance = 0;
        left = null;
        right = null;
    }
}
