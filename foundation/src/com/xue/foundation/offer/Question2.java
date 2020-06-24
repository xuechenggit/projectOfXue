package com.xue.foundation.offer;

/**
 * 二维数组中的查找
 * 给定一个二维数组，其每一行从左到右递增排序，从上到下也是递增排序。给定一个数，判断这个数是否在该二维数组中。
 *
 * Consider the following matrix:
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 *
 * Given target = 5, return true.
 * Given target = 20, return false.
 *
 * 算法思想：从右上角a[0][4]开始,如果target < a[0][4]则target在a[0][4]左边，如果target大于a[0][4]则target在a[0][4]下方，如果相等则返回
 */
public class Question2 {
    public static void main(String[] args) {
        int[][] input = {{1, 4, 7, 11, 15},{2, 5, 8, 12, 19},{3, 6, 9, 16, 22},{10, 13, 14, 17, 24},{18, 21, 23, 26, 30}};
        System.out.println(input.length);
        System.out.println(input[2][3]);
        System.out.println(searchVal(input, 5));
    }

    public static boolean searchVal(int[][] input, int target) {
        boolean res = false;
        int i = 0;
        int j = input[0].length -1;
        while (j >= 0 && i < input.length) {
            if (input[i][j] < target){
                i++;
            } else if (input[i][j] > target) {
                j--;
            } else {
                return true;
            }
        }
        return res;
    }
}
