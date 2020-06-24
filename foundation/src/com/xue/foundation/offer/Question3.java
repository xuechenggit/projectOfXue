package com.xue.foundation.offer;

/**
 * 替换空格
 * 将一个字符串中的空格替换成 "%20"。
 * Input:
 * "A B"
 *
 * Output:
 * "A%20B"
 *
 * 算法思想：遍历一遍字符串，每找到一个空格在字符串末尾增加两个位置，
 * 然后两个指针l1, l2分别指向原字符串和现字符串的末尾，开始向前移动
 * 当l1位置的字符为空格时，从l2位置依次设置0,2，%，如果不为空格则将l2位置设置为l1的值
 */
public class Question3 {
    public static void main(String[] args) {
       StringBuffer stringBuffer = new StringBuffer("a jn k");
        System.out.println(replaceString(stringBuffer));
    }

    public static String replaceString(StringBuffer stringBuffer) {
        int len = stringBuffer.length() - 1;
        for (int i = len; i >= 0 ; i--) {
            if (stringBuffer.charAt(i) == ' ') {
                stringBuffer.append("  ");
            }
        }
        int len2 = stringBuffer.length() - 1;
        while (len >= 0 && len2 >= 0) {
            char c1 = stringBuffer.charAt(len);
            if (c1 == ' ') {
                len--;
                stringBuffer.setCharAt(len2--, '0');
                stringBuffer.setCharAt(len2--, '2');
                stringBuffer.setCharAt(len2--, '%');
            } else {
                stringBuffer.setCharAt(len2--, stringBuffer.charAt(len--));
            }
        }
        return stringBuffer.toString();
    }

}
