package com.xue.foundation;

import java.util.*;

public class Solution {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return null;
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            if (nums[i] > 0 ) break;
            if(i > 0 && nums[i] == nums[i-1]) continue;
            while (left < right) {
                int t = nums[i] + nums[left] + nums[right];
                if (t == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    res.add(list);
                    while (nums[right] == nums[right -1] && left < right){
                        right--;
                    }
                    right--;
                    while (nums[left] == nums[left + 1] && left < right){
                        left++;
                    }
                    left++;
                } else if (t > 0){

                        right --;

                } else {

                        left++;

                }
            }
        }
        return res;
    }

    public static List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        //排序
        Arrays.sort(nums);
        //双指针
        int len = nums.length;
        for(int i = 0;i < len;++i) {
            if(nums[i] > 0) return lists;

            if(i > 0 && nums[i] == nums[i-1]) continue;

            int curr = nums[i];
            int L = i+1, R = len-1;
            while (L < R) {
                int tmp = curr + nums[L] + nums[R];
                if(tmp == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(curr);
                    list.add(nums[L]);
                    list.add(nums[R]);
                    lists.add(list);
                    while(L < R && nums[L+1] == nums[L]) ++L;
                    while (L < R && nums[R-1] == nums[R]) --R;
                    ++L;
                    --R;
                } else if(tmp < 0) {
                    ++L;
                } else {
                    --R;
                }
            }
        }
        return lists;
    }

    public static int near(int[] nums, int target) {
        int init = Math.abs(nums[0] + nums[1] + nums[nums.length -1] - target);
        int sum = nums[0] + nums[1] + nums[nums.length -1];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length -1;
            while (left < right) {
                int c = nums[i] + nums[left] + nums[right];
               if (c > target) {
                    right--;
                } else {
                    left++;
                }
                int t = Math.abs(c - target);
                if (t < init) {
                    init = t;
                    sum = c;
                }
            }
        }

        return sum;
    }

    public ListNode get(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2;
        ListNode cu = new ListNode(0);
        int car = 0;
        ListNode cur = cu.next;
        while (p1 != null || p2 != null) {
            int x = p1 != null ? p1.val : 0;
            int y = p2 != null ? p2.val : 0;
            int sum = car + x + y;
            car = sum / 10;
            int mod = sum % 10;
            cur = new ListNode(mod);
            cur = cur.next;
            if (p1.next != null) p1 = p1.next;
            if (p2.next != null) p2 = p2.next;

        }
        return cu.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public static String addString(String num1, String num2) {
        int len1 = num1.length()-1;
        int len2 = num2.length()-1;
        int car = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (len1 >=0 || len2 >= 0) {
            int x = len1 < 0 ? 0 : Integer.parseInt(String.valueOf(num1.charAt(len1)));
            int y = len2 < 0 ? 0 : Integer.parseInt(String.valueOf(num2.charAt(len2)));
            int v = car + x + y;
            car = v / 10;
            stringBuilder.append(v % 10);
            if (len1 >= 0) len1--;
            if (len2 >= 0) len2--;
        }
        if (car > 0) {
            stringBuilder.append(car);
        }
        return stringBuilder.reverse().toString();
    }

    public static String mulString(String num1, String num2) {
        int[] arr = new int[num1.length() + num2.length()];
        for (int i = num1.length() -1; i >=0 ; i--) {
            int v1 = num1.charAt(i) - '0';
            int car = 0;
            for (int j = num2.length() -1; j >= 0 ; j--) {
                int v2 = num2.charAt(j) - '0';
                int v3 = v1 * v2 + arr[i + j + 1];
                arr[i + j] = v3 / 10 + arr[i + j];
                arr[i + j + 1] = v3 % 10;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (i == 0 && arr[i] == 0) continue;
            stringBuilder.append(arr[i]);
        }
        return stringBuilder.toString();

    }





    public static void main(String[] args) {
        String s = mulString("12", "12");
        System.out.println(s);
    }
}

class ListNode {
     int val;
      ListNode next;
      ListNode(int x) { val = x; }}
