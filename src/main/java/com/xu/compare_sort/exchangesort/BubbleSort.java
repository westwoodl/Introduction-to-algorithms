package com.xu.compare_sort.exchangesort;

import com.xu.util.Arr;
import org.junit.Test;

/**
 * 冒泡排序
 */
public class BubbleSort {

    @Test
    public void test(){
        Arr.print(Arr.random(10));
        Arr.print(bubble(new int[]{4, 1, -1, 4, 9, 10, -9}));
        Arr.print(bubble(Arr.random(10)));

    }

    public int[] bubble(int[] arr){
        int key;

        for(int i = 0;i < arr.length - 1; i++) {
            boolean flag  = true;
            for(int j = 0; j < arr.length - 1 - i; j ++) { // 最大的已经在最后了
                if (arr[j + 1] < arr[j]) {
                    flag = false;
                    key = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = key;
                }

            }
            if(flag) {
                return arr;
            }
        }
        return arr;
    }
}
