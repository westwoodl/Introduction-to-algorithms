package com.xu.search;

import org.junit.Test;

public class FibonacciSearch {

    @Test
    public void test() {

        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i;
        }


        System.out.println(fibonacciz(20));
        System.out.println(fibonacci(20));
    }

    public int fibonacciSearch(int[] arr, int left, int right, int findVal) {

        System.out.println("find");
        if (left > right || findVal < arr[left] || findVal > arr[right]) {
            return -1;
        }

        int k = 0;
        while (arr[right] > fibonacci(k) - 1) {
            k++;
        }

        int mid = arr[left] + fibonacci(k - 1) - 1;

        if (findVal > arr[mid])
            return fibonacciSearch(arr, mid + 1, right, findVal);
        else if (findVal < arr[mid])
            return fibonacciSearch(arr, left, mid - 1, findVal);
        else
            return mid;
    }


    public int fibonacci(int n) {
        if (n < 1)
            throw new IllegalArgumentException("N must gather then zero");
        if (n == 1 || n == 2)
            return 1;
        else
            return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public int fibonacciz(int n) {

        if (n < 1)
            throw new IllegalArgumentException("N must gather then zero");
        if (n == 1 || n == 2)
            return 1;
        else {
            int n1 = 1, n2 = 1, temp;
            while (n-- > 2) {
                temp = n2;
                n2 = n1 + n2;
                n1 = temp;
            }
            return n2;


        }
    }
}
