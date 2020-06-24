package com.xue.foundation.sort;

import com.sun.deploy.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sort {

    public static void main(String[] args) {
        int[] arrays = {3, 6, 1, 8, 2, 9, 5, 25};
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i : arrays) {
            arrayList.add(i);
        }
        //bubbleSort(arrays);
        //selectionSort(arrays);
        //insertSort(arrays);
        //shellSort(arrays);
        //int[] res= mergeSort(arrays);
        //qiuckSort(arrays, 0, arrays.length - 1);
        heapSort(arrays);
        //countSort(arrays);
        //ArrayList<Integer> res = bucketSort(arrayList, 5);
        //sout(arrays);
        //System.out.println(res);
        //radixSort(arrays);
        sout(arrays);
    }

    public static void bubbleSort(int[] arrays) {
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays.length - 1 - i; j++) {
                int temp = arrays[j];
                if (arrays[j] > arrays[j +1]) {
                    arrays[j] = arrays[j + 1];
                    arrays[j + 1] = temp;
                }
            }
        }
    }

    public static void selectionSort(int[] arrays) {
        for (int i = 0; i < arrays.length; i++) {
            int index = i;
            for (int j = i; j < arrays.length; j++) {
                if (arrays[index] > arrays[j]) {
                    index = j;
                }
            }
            int temp = arrays[i];
            arrays[i] = arrays[index];
            arrays[index] = temp;
        }
    }

    public static void insertSort(int[] arrays) {
        for (int i = 0; i < arrays.length; i++) {
            int temp = arrays[i];
            int index = i;
            for (int j = i - 1; j >= 0; j--) {
                if (arrays[j] > temp) {
                    index = j;
                    arrays[j + 1] = arrays[j];
                } else {
                    break;
                }
            }
            arrays[index] = temp;
        }
    }

    public static void shellSort(int[] array) {
        int gap = array.length / 2;
        while (gap > 0) {
            for (int i = 0; i < array.length; i++) {
                int temp = array[i];
                int index = i - gap;
                while (index >= 0 && array[index] > temp ) {
                    array[index + gap] = array[index];
                    index = index - gap;
                }
                array[index + gap] = temp;
            }
            gap = gap / 2;
        }
    }

    public static int[] mergeSort(int[] arrays) {
        if (arrays.length < 2) {
            return arrays;
        }
        int middle = arrays.length / 2;
        int[] left = Arrays.copyOfRange(arrays, 0, middle);
        int[] right = Arrays.copyOfRange(arrays, middle, arrays.length);
        return merge(mergeSort(left), mergeSort(right));
    }

    public static int[] merge(int[] left, int[] right) {
        int[] res = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < res.length; index++) {
            if (i >= left.length) {
                res[index] = right[j++];
            } else if (j >= right.length) {
                res[index] = left[i++];
            } else if (left[i] > right[j]) {
                res[index] = left[i++];
            } else {
                res[index] = right[j++];
            }
        }
        return res;
    }

    public static void qiuckSort(int[] arrays, int start, int end) {
        if (start > end) return;
        int temp = arrays[start];
        int i = start, j = end;
        while (i != j) {
            while (arrays[j] > temp && i < j) {
                j--;
            }
            while (arrays[i] < temp && i < j) {
                i++;
            }
            if (i < j) {
                swap(arrays, i, j);
            }
        }
        qiuckSort(arrays, start, i - 1);
        qiuckSort(arrays, i + 1,  end);

    }

    public static void swap(int[] arrays, int posFirst, int posSecond) {
        int temp = arrays[posFirst];
        arrays[posFirst] = arrays[posSecond];
        arrays[posSecond] = temp;
    }

    public static void heapSort(int[] arrays) {
        int len = arrays.length;
        //构建最大堆
        for (int i = (len /2 - 1); i >= 0; i--) {
            adjustHeap(arrays, i, arrays.length -1);
        }
        while (len > 0) {
            swap(arrays, 0, --len);
            adjustHeap(arrays, 0, len - 1);
        }
    }

    public static void adjustHeap(int[] arrays, int i, int len) {
        int maxIndex = i;
        if ((2 * i + 1) <= len && arrays[2 * i + 1] > arrays[maxIndex]) {
            maxIndex = 2 * i +1;
        }
        if ((2 * i + 2) <= len && arrays[2 * i + 2] > arrays[maxIndex]) {
            maxIndex = 2 * i + 2;
        }
        if (maxIndex != i) {
            swap(arrays, i, maxIndex);
            adjustHeap(arrays, maxIndex, len);
        }

    }

    public static void countSort(int[] arrays) {
        int max = arrays[0];
        int min = arrays[0];
        for (int i = 0; i < arrays.length; i++) {
            if (max < arrays[i]) max = arrays[i];
            if (min > arrays[i]) min = arrays[i];
        }
        int[] bucket = new int[max - min + 1];
        int base = 0 - min;
        Arrays.fill(bucket, 0);
        for (int i = 0; i < arrays.length; i++) {
            bucket[arrays[i] + base]++;
        }
        int index = 0, i = 0;
        while (index < arrays.length) {
            if (bucket[i] != 0) {
                arrays[index] = i - base;
                index++;
                bucket[i]--;
            } else {
                i++;
            }
        }
    }

    public static ArrayList<Integer> bucketSort(ArrayList<Integer> arrayList, int bucketSize) {
        if (arrayList == null || arrayList.size() < 2) return arrayList;
        int max = arrayList.get(0), min = arrayList.get(0);
        for (Integer i : arrayList) {
            if (i < min) {
                min = i;
            }
            if (i > max) {
                max = i;
            }
        }
        int bucketCount = (max - min) / bucketSize + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>();
        ArrayList<Integer> resultArr = new ArrayList<>();
        for (int i = 0; i < bucketCount; i++) {
            bucketArr.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < arrayList.size(); i++) {
            bucketArr.get((arrayList.get(i) - min) / bucketSize).add(arrayList.get(i));
        }
        for (int i = 0; i < bucketCount; i++) {
            if (bucketSize == 1) {
                for (int j = 0; j < bucketArr.get(i).size(); j++) {
                    resultArr.add(bucketArr.get(i).get(j));
                }
            } else {
                if (bucketCount == 1) bucketSize--;
                ArrayList<Integer> temp = bucketSort(bucketArr.get(i), bucketSize);
                for (int j = 0; j < temp.size(); j++) {
                    resultArr.add(temp.get(j));
                }
            }
        }
        return resultArr;
    }

    /**
     * 桶排序
     *
     * @param array
     * @param bucketSize
     * @return
     */
    public static ArrayList<Integer> BucketSort(ArrayList<Integer> array, int bucketSize) {
        if (array == null || array.size() < 2)
            return array;
        int max = array.get(0), min = array.get(0);
        // 找到最大值最小值
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) > max)
                max = array.get(i);
            if (array.get(i) < min)
                min = array.get(i);
        }
        int bucketCount = (max - min) / bucketSize + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketCount);
        ArrayList<Integer> resultArr = new ArrayList<>();
        for (int i = 0; i < bucketCount; i++) {
            bucketArr.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < array.size(); i++) {
            bucketArr.get((array.get(i) - min) / bucketSize).add(array.get(i));
        }
        for (int i = 0; i < bucketCount; i++) {
            if (bucketSize == 1) { // 如果带排序数组中有重复数字时
                for (int j = 0; j < bucketArr.get(i).size(); j++)
                    resultArr.add(bucketArr.get(i).get(j));
            } else {
                if (bucketCount == 1)
                    bucketSize--;
                ArrayList<Integer> temp = BucketSort(bucketArr.get(i), bucketSize);
                for (int j = 0; j < temp.size(); j++)
                    resultArr.add(temp.get(j));
            }
        }
        return resultArr;
    }

    public static void radixSort(int[] arrays) {
        int max = arrays[0];
        for (int i = 0; i < arrays.length; i++) {
            if (max < arrays[i]) {
                max = arrays[i];
            }
        }
        int digit = 0;
        while (max != 0) {
            max = max / 10;
            digit++;
        }
        List<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new ArrayList<Integer>());
        }
        int mod = 10, div = 1;
        for (int i = 0; i < digit; i++, mod *= 10, div *= 10) {
            for (int j = 0; j < arrays.length; j++) {
                list.get((arrays[j] % mod) / div).add(arrays[j]);
            }
            int index = 0;
            for (int j = 0; j < list.size(); j++) {
                for (int k = 0; k < list.get(j).size(); k++) {
                    arrays[index] = list.get(j).get(k);
                    index++;
                }
                list.get(j).clear();
            }
        }
    }

    public static void sout(int[] arrays) {
        for (int i: arrays) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
