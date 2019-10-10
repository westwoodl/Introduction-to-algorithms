package com.xu.sort.compare_sort.mergesort;

import com.xu.sort.compare_sort.Sort;
import org.junit.Test;

public class MergeSort2 extends Sort {

    @Test
    public void test() {
        arr = new int[]{6, 5, 4, 3, 2, 1};
        temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1);
        print();
    }

    public void mergeSort(int[] a, int start, int end) {
        if (start >= end) return;
        int mid = (start + end) / 2;
        mergeSort(a, start, mid);
        mergeSort(a, mid + 1, end);
        merge(a, start, mid, end);

    }

    int[] temp;

    /**
     * 合并两个有序数组
     * 1 5 9   2 4 6
     *
     * @param p
     * @param q
     * @param r
     */
    public void merge(int[] a, int p, int q, int r) {
        System.out.println("---");
//        int[] temp = new int[r - p + 1];
        int i = p, j = q + 1, k = 0;
        while (i <= q && j <= r) {
            if (a[i] > a[j])
                temp[k++] = a[j++];
            else
                temp[k++] = a[i++];
        }
        /**
         * 最后一个元素
         */
        while (i <= q)
            temp[k++] = a[i++];
        while (j <= r)
            temp[k++] = a[j++];
        for (k = 0; k < r - p + 1; k++) {
            a[k + p] = temp[k];
        }
    }
}
