package com.xu.compare_sort;

import com.xu.util.Arr;

public class Sort {

    protected int[] arr = Arr.random(8);

    public void print(){
        Arr.print(arr);
    }

    public void print(int[] arr){
        Arr.print(arr);
    }

    public void exchange(int i, int j){
        int k = arr[i];
        arr[i] = arr[j];
        arr[j] = k;
    }

    public void swap(int[] arr, int i, int j) {
        int k = arr[i];
        arr[i] = arr[j];
        arr[j] = k;
    }
}
