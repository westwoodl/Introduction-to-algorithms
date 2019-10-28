package com.xu.algorithms;

import org.junit.Test;

import java.util.Arrays;

/**
 * 核心：部分匹配表
 * 部分匹配值就是前缀和后缀的最长的共有元素的长度：
 * 如：
 * ABCDA:前缀 [A,AB,ABC,ABCD] 后缀[BCDA,CDA,DA,A] 共有元素A长度为1，所以他的部分匹配值为1
 */
public class KMP {

    @Test
    public void test(){
        String s = "ABCDABD";
        int[] next = partialMatchValue(s);
        System.out.println(Arrays.toString(next));

        System.out.println(kmpMatch("BBC ABCDAB ABCDABCDABDE", s, next));


    }

    public static int kmpMatch(String s1, String s2, int[] next){

        for(int i = 0,j=0;i<s1.length();i++){
            while (j>0&&s1.charAt(i)!=s2.charAt(j)){
                j = next[j-1];
            }

            if(s1.charAt(i) == s2.charAt(j)) {
                j++;
            }

            if(j==s2.length()) {
                return i-j+1;
            }
        }
        return -1;
    }


    public int[] partialMatchValue(String str) {
        int[] next = new int[str.length()];
        next[0] = 0;
        for (int i = 1, j = 0; i < str.length(); i++) {
            while (j > 0 && str.charAt(i) != str.charAt(j)) {
                j = next[j - 1];
            }
            if (str.charAt(i) == str.charAt(j)) {
                j++;
            }
            next[i] =j;
        }

        return next;
    }
}
