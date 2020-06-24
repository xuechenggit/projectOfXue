package com.xue.foundation.tree;

import java.util.Stack;

public class SearchTree {

    public static void main(String[] args) {
        Node n1 = new Node();
        Node n2 = new Node();
        Node n3 = new Node();
        Node n4 = new Node();
        n1.setValue(4);
        n2.setValue(2);
        n3.setValue(8);
        n4.setValue(3);
        n2.setRightNode(n4);
        n1.setLeftNode(n2);
        n1.setRightNode(n3);
        /*Node node = binarySearch1(n1, 2);
        System.out.println(node.getValue());
        insert(n1,1);
        deleteNode(n1, 4);
        System.out.println(n1);*/
        //preOrderTraverse2(n1);
        //inOrderTraverse2(n1);
        postOrderTraverse2(n1);
    }

    /**
     * 递归前序
     * @param node
     */
    public static void preOrderTraverse1(Node node) {
        if (node != null) {
            System.out.println(node.getValue());
            preOrderTraverse1(node.getLeftNode());
            preOrderTraverse1(node.getRightNode());
        }
    }

    /**
     * 非递归前序遍历
     * @param root
     */
    public static void preOrderTraverse2(Node root) {
        Stack<Node> stack = new Stack<>();
        Node node = root;
        while (node != null || !stack.empty()) {
            if (node != null) {
                System.out.println(node.getValue());
                stack.push(node);
                node = node.getLeftNode();
            } else {
                node = stack.pop().getRightNode();
            }

        }
    }

    /**
     * 递归中序遍历
     * @param node
     */
    public static void inOrderTraverse1(Node node) {
        if (node != null) {
            inOrderTraverse1(node.getLeftNode());
            System.out.println(node.getValue());
            inOrderTraverse1(node.getRightNode());
        }
    }

    /**
     * 非递归中序遍历
     * @param root
     */
    public static void inOrderTraverse2(Node root) {
        Stack<Node> stack = new Stack<>();
        Node node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.getLeftNode();
            } else {
                Node temp = stack.pop();
                System.out.println(temp.getValue());
                node = temp.getRightNode();
            }
        }
    }

    /**
     * 递归后序遍历
     * @param node
     */
    private static void postOrderTraverse1(Node node) {
        if (node != null) {
            postOrderTraverse1(node.getLeftNode());
            preOrderTraverse1(node.getRightNode());
            System.out.println(node.getValue());
        }
    }

    /**
     * 非递归后序遍历
     * @param root
     */
    private static void postOrderTraverse2(Node root) {
        Stack<Node> stack = new Stack<>();
        Node curNode;
        Node preNode = null;
        stack.push(root);
        while (!stack.empty()) {
            curNode = stack.peek();
            if ((curNode.getLeftNode() == null && curNode.getRightNode() == null) ||
                    (preNode != null &&
                            (preNode == curNode.getLeftNode() || preNode == curNode.getRightNode()))) {
                System.out.println(curNode.getValue());
                stack.pop();
                preNode = curNode;
            } else {
                if (curNode.getRightNode() != null) {
                    stack.push(curNode.getRightNode());
                }
                if (curNode.getLeftNode() != null) {
                    stack.push(curNode.getLeftNode());
                }
            }
        }
    }

    public static Node binarySearch1(Node node, int target) {
        if (node == null) return null;
        if (target == node.getValue()) {
            return node;
        } else if (target > node.getValue()){
            return binarySearch1(node.getRightNode(), target);
        } else {
            return binarySearch1(node.getLeftNode(), target);
        }
    }


    public static boolean binarySearch2(Node node, int target) {
        if (node == null) return false;
        if (target == node.getValue()) {
            return true;
        } else if (target > node.getValue()){
            return binarySearch2(node.getRightNode(), target);
        } else {
            return binarySearch2(node.getLeftNode(), target);
        }
    }
    public static void insert(Node node, int value) {
        if (node.getValue() > value){
            if (node.getLeftNode() == null) {
                Node node1 = new Node();
                node1.setValue(value);
                node.setLeftNode(node1);
            } else {
                insert(node.getLeftNode(), value);
            }
        } else {
            if (node.getRightNode() == null) {
                Node node1 = new Node();
                node1.setValue(value);
                node.setRightNode(node1);
            } else {
                insert(node.getRightNode(), value);
            }
        }
    }

    public static void deleteNode(Node node, int v) {
        if (node == null) return;
        if (node.getValue() == v) {
            delete(node, v);
        } else if (node.getValue() > v) {
            deleteNode(node.getLeftNode(), v);
        } else {
            deleteNode(node.getRightNode(), v);
        }
    }

    public static void delete(Node node, int v) {
        if (node.getValue() == v) {
            if (node.getLeftNode() == null && node.getRightNode() == null) {
                node = null;
            } else if (node.getLeftNode() == null && node.getRightNode() != null) {
                node.setValue(node.getRightNode().getValue());
                node.setRightNode(node.getRightNode().getRightNode());
            } else if (node.getLeftNode() != null && node.getRightNode() == null) {
                node.setValue(node.getLeftNode().getValue());
                node.setLeftNode(node.getLeftNode().getLeftNode());
            } else {
                Node t = node.getLeftNode();
                Node s = node;
                while (t.getRightNode() != null) {
                    s = t;
                    t = t.getRightNode();
                }
                node.setValue(t.getValue());
                if (s.getValue() == node.getValue()) {
                    s.setLeftNode(t.getLeftNode());
                } else {
                    s.setRightNode(t.getLeftNode());
                }

            }
        }
    }

}
