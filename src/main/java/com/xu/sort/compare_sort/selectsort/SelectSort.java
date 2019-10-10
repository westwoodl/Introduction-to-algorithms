package com.xu.sort.compare_sort.selectsort;

import com.xu.sort.compare_sort.Sort;
import com.xu.util.Arr;
import org.junit.Test;

import java.util.Date;

/**
 * 选择排序
 */
public class SelectSort extends Sort {

    @Test
    public void test() {
        arr = Arr.random(5000);
        Date date = new Date();
        selectSort(arr);
        //Arrays.sort(Arr.random(5000));
        System.out.println(new Date().getTime() - date.getTime());


        print();
    }

    public int[] selectSort(int[] arr) {

        int minIndex = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            if (i != minIndex)
                exchange(i, minIndex);

        }
        return arr;
    }
}
