package com.xu.sort.compare_sort.insertionsort;


import com.xu.sort.compare_sort.Sort;
import org.junit.Test;

/**
 * 希尔排序(插入排序)
 * 最佳情况：T(n) = O(nlog2 n)  最坏情况：T(n) = O(nlog2 n)  平均情况：T(n) =O(nlog2n)
 */
public class ShellSort extends Sort {

    @Test
    public void test() {
        shellSort(arr);
        print();
    }


    /**
     * 有步长的插入排序
     * @param arr
     * @return
     */
    public int[] shellSort(int[] arr) {

        int temp;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                temp = arr[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && arr[preIndex] > temp) {
                    arr[preIndex + gap] = arr[preIndex];
                    preIndex -= gap;
                }
                arr[preIndex + gap] = temp;

            }
        }

        return arr;

    }
}
