package com.xue.foundation.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

/**
 * 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级... 它也可以跳上 n 级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法
 */
public class Question10 {

    public static void main(String[] args) {
        System.out.println(guihua(3));
        System.out.println(tuidao(3));
    }

    public static int guihua(int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            for (int j=0; j < i; j++) {
                dp[i] += dp[j];
            }
        }
        return dp[n - 1];
    }

    /**
     *
     * 跳上 n-1 级台阶，可以从 n-2 级跳 1 级上去，也可以从 n-3 级跳 2 级上去...，那么
     *
     * f(n-1) = f(n-2) + f(n-3) + ... + f(0)
     *
     * 同样，跳上 n 级台阶，可以从 n-1 级跳 1 级上去，也可以从 n-2 级跳 2 级上去... ，那么
     *
     * f(n) = f(n-1) + f(n-2) + ... + f(0)
     *
     * 综上可得
     *
     * f(n) - f(n-1) = f(n-1)
     *
     * 即
     *
     * f(n) = 2*f(n-1)
     *
     * 所以 f(n) 是一个等比数列
     * @param n
     * @return
     */
    public static int tuidao(int n) {
        return (int) Math.pow(2, n - 1);
    }
}
