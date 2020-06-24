package com.xue.foundation.offer;

/**
 * 斐波那契数列
 *
 */
public class Question9 {
    public static void main(String[] args) {
        System.out.println(recursive(7));
        System.out.println(guihua(7));
    }

    /**
     * 递归
     * @param n
     * @return
     */
    public static int recursive(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return recursive(n-1) + recursive(n-2);
    }

    /**
     * 动态规划，
     * 当前值是前两项值的和所以只需要记录下前两项
     */
    public static int guihua(int n) {
        if (n <= 1) return n;
        int pre2 = 0, pre1 = 1;
        int c=0;
        for (int i = 2; i <= n; i++) {
            c = pre1 + pre2;
            pre2 = pre1;
            pre1 = c;
        }
        return c;
    }


}
