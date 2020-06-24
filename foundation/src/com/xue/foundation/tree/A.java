package com.xue.foundation.tree;

public class A {

    public static void main(String[] args) {
        AVLNode node = new AVLNode(3);
        int[] datas = {2, 5, 7,4,9};
        for (int i = 0; i< datas.length; i++) {
            insert(node, datas[i]);
        }
        AVLNode parent = null;
        while (node != null) {
            parent = node;
            node = node.parent;
        }

        AVLNode newNode = delete(parent, 9);
        System.out.println(newNode);
    }

    public static void insert(AVLNode node, int data) {
        if (node.data > data) {
            if (node.left != null) {
                insert(node.left, data);
            }else {
                AVLNode tempNode = new AVLNode(data);
                node.left = tempNode;
                tempNode.parent = node;
            }
        } else {
            if (node.right != null) {
                insert(node.right, data);
            } else {
                AVLNode tempNode = new AVLNode(data);
                node.right = tempNode;
                tempNode.parent = node;
            }
        }

        int balance = calBalance(node);

        if (balance >= 2) {
            if (node.left.balance == -1) {
                left_rotate(node.left);
            }
            right_rotate(node);
        }

        if (balance <= -2) {
            if (node.right.balance == 1) {
                right_rotate(node.right);
            }
            left_rotate(node);
        }

        node.balance = calBalance(node);
        node.depth = calDepth(node);

    }

    public static AVLNode delete(AVLNode root, int value) {
        if (root == null) return null;
        if (root.data == value) {
            if (root.left != null && root.right != null) {
                AVLNode temp = root.left;
                while (temp.right != null) {
                    temp = temp.right;
                }
                root.data = temp.data;
                delete(temp, temp.data);
            } else if (root.left != null && root.right == null) {
                root = root.left;
                root.left = null;
            } else if (root.left == null && root.right != null) {
                root = root.right;
                root.right = null;
            } else {
                if (root.parent != null) {
                    if (root.parent.left != null && root.parent.left.data == value) {
                        root.parent.left = null;
                    } else {
                        root.parent.right = null;
                    }
                } else {

                }
            }
        } else if (root.data < value){
            delete(root.right, value);
        } else {
            delete(root.left, value);
        }

        if (root == null) {
            return null;
        }
        int balance = calBalance(root);

        if (balance >= 2) {
            if (root.left.balance == -1) {
                left_rotate(root.left);
            }
            right_rotate(root);
        }

        if (balance <= -2) {
            if (root.right.balance == 1) {
                right_rotate(root.right);
            }
            left_rotate(root);
        }

        root.balance = calBalance(root);
        root.depth = calDepth(root);
        return root;
    }

    public static void left_rotate(AVLNode node) {
        AVLNode parentNode = node.parent;
        AVLNode orginalRight = node.right;
        AVLNode rightLeftGrandSon = orginalRight.left;

        orginalRight.parent = parentNode;
        if (parentNode != null) {
            if (node == parentNode.right) {
                parentNode.right = orginalRight;
            } else {
                parentNode.left = orginalRight;
            }
        }

        orginalRight.left = node;
        node.parent = orginalRight;

        node.right = rightLeftGrandSon;
        if (rightLeftGrandSon != null) {
            rightLeftGrandSon.parent = node;
        }

        node.depth = calDepth(node);
        node.balance = calBalance(node);

        orginalRight.depth = calDepth(orginalRight);
        orginalRight.balance = calBalance(orginalRight);

    }

    public static void right_rotate(AVLNode node) {
        AVLNode parent = node.parent;
        AVLNode orginalLeft = node.left;
        AVLNode leftRightGrandSon = orginalLeft.right;

        orginalLeft.parent = parent;
        if (parent != null) {
            if (node == parent.left) {
                parent.left = orginalLeft;
            } else {
                parent.right = orginalLeft;
            }
        }

        orginalLeft.right = node;
        node.parent = orginalLeft;

        node.left = leftRightGrandSon;
        if (leftRightGrandSon != null) {
            leftRightGrandSon.parent = node;
        }

        node.depth = calDepth(node);
        node.balance = calBalance(node);

        orginalLeft.depth = calDepth(orginalLeft);
        orginalLeft.balance = calBalance(orginalLeft);
    }

    public static int calBalance(AVLNode node) {
        int left_depth;
        int right_depth;
        if (node.left != null) {
            left_depth = node.left.depth;
        }  else {
            left_depth = 0;
        }
        if (node.right != null) {
            right_depth = node.right.depth;
        } else {
            right_depth = 0;
        }
        return left_depth - right_depth;
    }

    public static int calDepth(AVLNode node) {
        int depth = 0;
        if (node.left != null) {
            depth = node.left.depth;
        }
        if (node.right != null && node.right.depth > depth) {
            depth = node.right.depth;
        }
        depth++;
        return depth;
    }
}
