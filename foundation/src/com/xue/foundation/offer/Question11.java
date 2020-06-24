package com.xue.foundation.offer;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1
 * 思路：
 */
public class Question11 {

    public static void main(String[] args) {
        int[] array = {3,4,5,1,2};
        System.out.println(binsearch(array));
        System.out.println(search2(array));
    }

    /**
     * 如果数组中没有重复数字，可以使用二分查找法
     * @param arrays
     * @return
     */
    public static int binsearch(int[] arrays) {
        if (arrays.length == 0) return 0;
        int low = 0, high = arrays.length -1;
        while (low < high) {
            int middle = low + (high - low) / 2;
            if (arrays[middle] < arrays[high]) {
                high = middle;
            } else {
                low = middle + 1;
            }
        }
        return arrays[low];
    }

    /**
     *如果存在arrays[middle]==arrays[low]==arrays[high]则需要顺序查找
     */
    public static int search2(int[] arrays) {
        if (arrays.length == 0) return 0;
        int low = 0, high = arrays.length -1;
        while (low < high) {
            int middle = low + (high - low) / 2;
            if (arrays[middle] == arrays[high] && arrays[middle] == arrays[low]) {
                return minNum(arrays, low, high);
            } else if (arrays[middle] <= arrays[high]) {
                high = middle;
            } else {
                low = middle + 1;
            }
        }
        return arrays[low];
    }

    public static int minNum(int[] arrays, int start, int end) {
        for (int i = start; i < end; i++) {
            if (arrays[i] > arrays[i + 1]) {
                return arrays[i + 1];
            }
        }
        return arrays[start];
    }




}
