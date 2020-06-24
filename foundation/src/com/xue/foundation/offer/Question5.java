package com.xue.foundation.offer;


import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * 重建二叉树
 * 根据二叉树的前序遍历和中序遍历的结果，重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字
 * pre：3,9,20,15,7
 * in:9,3,15,20,7
 * 算法思想：
 */
public class Question5 {
    public static void main(String[] args) {
        int[] pre = {3,9,20,15,7};
        int[] in = {9,3,15,20,7};

    }
    public static TreeNode rebuildTree(int[] pre, int[] in) {
        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            index.put(in[i], i);
        }

        TreeNode root = null;
        TreeNode curr = root;
        int rootIndex =0;
        for (int i = 0; i < pre.length; i++) {
            if (i == 0) {
                root = new TreeNode(pre[0]);
                curr = root;
                rootIndex = index.get(pre[0]);
            } else {
                TreeNode node = new TreeNode(pre[i]);
                if (index.get(pre[i]) < rootIndex) {
                    curr.setL(node);
                }

            }
        }
        return root;

    }
}
class TreeNode{
    int val;
    TreeNode l;
    TreeNode r;


    public TreeNode(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getL() {
        return l;
    }

    public void setL(TreeNode l) {
        this.l = l;
    }

    public TreeNode getR() {
        return r;
    }

    public void setR(TreeNode r) {
        this.r = r;
    }
}
