package com.xu.util;

import java.util.Arrays;

public class Arr{

    public static int[] random(int n){
        int[] arr = new int[n];
        for(int i = 0;i < arr.length; i++){
            arr[i] = (int)(Math.random()*100 - Math.random()*100);
        }
        System.out.println("生成的随机数组:"+Arrays.toString(arr));
        return arr;
    }

    public static int[] random(){
        return random((int)(Math.random() * 10 + 5 ));
    }

    public static void print(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void exchange(int[] arr, int i, int j) {
        int k = arr[i];
        arr[i] = arr[j];
        arr[j] = k;
    }
}
