package com.example;

public class ShiftedArray {

    /**
     * 给定一个长度为 n 的字符串，将其向右循环移动 k 位，求循环移动之后的字符串。
     * 
     * @param s 输入字符串
     * @param k 移动位数
     * @return 移动后的字符串
     */
    public String rotate(String s, int k) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        int n = s.length();
        k = k % n;
        if (k < 0) {
            k = k + n;
        }
        if (k == 0) {
            return s;
        }
        return s.substring(n - k) + s.substring(0, n - k);
    }
}
