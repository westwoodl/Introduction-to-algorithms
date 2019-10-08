package com.xu.data_structures.recurse;

import org.junit.Test;

import java.util.Arrays;

public class Queen8 {
    private int defence = 0;
    private int answer = 0;

    @Test
    public void test(){
        queue(new int[8], 0);
        System.out.print( defence + " :" + answer);
    }


    public void queue(int arr[], int row){
        if(row == 8) {
            System.out.println(Arrays.toString(arr));
            return;
        }
        for(int i = 0;i<arr.length;i++){
            arr[row] = i;
            if(!isDefence(arr, row)){
                queue(arr, row + 1);
            }
        }
    }

/*

0 1 0 0 0 0 0 0
0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0  1
0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0

 */

    public boolean isDefence(int[] arr, int rownum){
        defence ++;
        for(int i=0;i<rownum;i++){
            if(arr[i] == arr[rownum] || Math.abs(rownum - i) == Math.abs(arr[rownum] - arr[i]))
                return true;
        }
        return false;
    }

}
