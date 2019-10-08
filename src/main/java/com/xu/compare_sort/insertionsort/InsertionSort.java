package com.xu.compare_sort.insertionsort;

import com.xu.compare_sort.Sort;
import com.xu.util.Arr;
import org.junit.Test;

/**
 * 插入排序 Θ(n^2)
 */
public class InsertionSort extends Sort {

    @Test
    public void test() {
        arr = Arr.random(1000);
        insertionSort(arr);
        print();
    }

    int[] uptest(int[] array) {
        for (int j = 1; j < array.length; j++) {
            int i = j - 1;
            int key = array[i + 1];
            while (i >= 0 && array[i] < key) {
                array[i + 1] = array[i];
                i--;
            }
            array[i + 1] = key;
        }
        showArray(array);
        return array;
    }

    int[] downtest(int[] array) {

        for (int j = 1; j < array.length; j++) {
            int i = j - 1;
            int key = array[j];
            while (i >= 0 && array[i] > key) {
                array[i + 1] = array[i];
                i--;
            }
            array[i + 1] = key;
        }

        return array;
    }

    /**  j i
     * 234 1
     * @param arr
     * @return
     */
    public int[] insertionSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            int key = arr[i];
            while (j >= 0 && key < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        return arr;

    }

    void showArray(int[] array) {
        for (int a : array) {
            System.out.print(a);
        }
        System.out.println();
    }
}