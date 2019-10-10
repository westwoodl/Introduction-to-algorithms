package com.xu.search;

import org.junit.Test;

/**
 * 插值查找算法
 *
 * int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
 * 主要是公式
 */
public class InsertValueSearch {


    @Test
    public void test() {

        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i;
        }

        System.out.println(insertValueSearch(arr, 0, arr.length - 1, 1));


    }


    public int insertValueSearch(int[] arr, int left, int right, int findVal) {

        System.out.println("find");
        if (left > right || findVal < arr[left] || findVal > arr[right]) {
            return -1;
        }

        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);

        if (findVal > arr[mid])
            return insertValueSearch(arr, mid + 1, right, findVal);
        else if (findVal < arr[mid])
            return insertValueSearch(arr, left, mid - 1, findVal);
        else
            return mid;
    }
}
