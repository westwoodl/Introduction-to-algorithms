package com.xu.data_structures.stack_queue;
import com.xu.compare_sort.Sort;
import com.xu.util.Arr;
import org.junit.Test;

import java.util.Arrays;

public class 堆排序 extends Sort {
    public static void main(String[] args) {
        int []array = new int[]{3,4,6,1,2,9,0};
        heapSort(array);
        System.out.println(Arrays.toString(array));
    }


    public static void heapSort(int []array){
        for (int i = (array.length/2)-1; i >=0 ; i--) {
            adjustHeap(array,i,array.length-1);
        }
        int temp;
        for (int i = array.length-1; i >0; i--) {
            temp = array[i];
            array[i] = array[0];
            array[0]=temp;
            adjustHeap(array,0,i-1);
        }
    }

    public static void adjustHeap(int []array,int low ,int high){
        int temp = array[low];
        int i = low,j=2*i+1;
        while (j<=high){
            if(j<high&&array[j]<array[j+1]) ++j;
            if(temp<array[j]){
                array[i]=array[j];
                i=j;
                j=i*2+1;
            }
            else
                break;
        }
        array[i]=temp;
    }
}
