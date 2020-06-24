package com.xue.foundation.offer;

/**
 * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字
 * Input:
 * {2, 3, 1, 0, 2, 5}
 * Output:
 * 2
 * 要求时间复杂度O(n),空间复杂度O(1)
 * 算法思想：从头遍历数组，将数组的值放到索引对应的位置，例如2 放到索引位置2上，然后将原索引位置2上的值1，放到索引位置1上，在放入前做比较如果相等说明有重复数字
 */
public class Question1 {

    public static void main(String[] args) {
        int[] input = {2, 3, 1, 0, 2, 5};
        searchVal(input);
    }

    public static void searchVal(int[] input) {
        if (input == null || input.length < 2) {
            return;
        }
        for (int i = 0; i < input.length; i++) {
            while (input[i] != i) {
                if (input[i] != input[input[i]]) {
                    swap(input, i, input[i]);
                } else {
                    System.out.println(input[i]);
                    return;
                }
            }
        }
    }

    public static void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}
