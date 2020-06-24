package com.xue.foundation.offer;

/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * 思路：中序遍历左跟右，如果节点的右子树不为空，后继节点为该节点的最左节点，如果右子树为空，向上找父节点
 */
public class Question7 {
    public static void main(String[] args) {
        TreeLinkNode node1 = new TreeLinkNode(1);
        TreeLinkNode node2 = new TreeLinkNode(2);
        TreeLinkNode node3 = new TreeLinkNode(3);
        TreeLinkNode node4 = new TreeLinkNode(4);
        node1.left = node2;
        node2.left = node3;
        node2.right=node4;
        node2.parent = node1;
        node3.parent = node2;
        node4.parent = node2;
        System.out.println(getNextNode(node2).val);
        System.out.println(getNextNode(node4).val);
    }

    public static TreeLinkNode getNextNode(TreeLinkNode node){
        if (node.right != null) {
            TreeLinkNode r= node.right;
            while (r.left != null) {
                r = r.left;
            }
            return r;
        }
        while (node.parent != null) {
            TreeLinkNode p = node.parent;
            if (p.left == node) {
                return p;
            }
            node = node.parent;
        }
        return null;
    }
}

class TreeLinkNode {

    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode parent = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
