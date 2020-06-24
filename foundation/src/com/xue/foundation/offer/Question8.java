package com.xue.foundation.offer;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的 Push 和 Pop 操作
 * 思路：两个栈一个用来存放入栈数据一个用来处理出站
 */
public class Question8 {
    public static void main(String[] args) {
        CusQueue queue = new CusQueue();
        queue.push(3);
        queue.push(2);
        System.out.println(queue.pop());
        queue.push(1);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }


}

class CusQueue{
    private Stack<Integer> in = new Stack<>();
    private Stack<Integer> out = new Stack<>();

    public void push(int i) {
        in.push(i);
    }

    public Integer pop() {
        if (out.empty()) {
            while (!in.empty()) {
                out.push(in.pop());
            }
            if (out.empty()) {
                return null;
            }
        }
        return out.pop();
    }

}
