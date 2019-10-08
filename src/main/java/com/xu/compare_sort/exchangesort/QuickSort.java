package com.xu.compare_sort.exchangesort;


import com.xu.compare_sort.Sort;
import com.xu.util.Arr;
import com.xu.util.SortUtil;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;

/**
 * 快速排序法
 *  1.分治：
 *      选取主元（这里我们选取序列中最后一位数），
 *      （分解出来的子数组都是原址排序，所以不需要合并）
 *  2.原址
 *  3.实用
 * 随机化快速排序：
 *  随机选取选取主元RandomizedQuickSort
 * 最坏时间复杂度为：Θ(n^2) 期望时间复杂度为：Θ(nlg n)
 * 虽然最坏很差，但是快排是实际应用中最好的选择，而且Θ(nlg n)隐含的常数因子也很小。
 * 快速排序法平均运行时间更接近于最好情况。
 */
public class QuickSort extends Sort {

    @Test public void exe(){
        SortUtil.show(quickSort(new int[]{2,8,7,1,3,5,6,4}, 0, 7));
    }

    int[] quickSort(int[] A, int p, int r){
        if(r>p){
            int q = partition(A, p, r, true);
            quickSort(A, p, q-1);//不能是q，而是q-1，应为A[q]的位置已经不需要再变了
            quickSort(A, q+1, r);
        }
        return A;
    }

    /**
     * 划分：对子数组的原址重排，返回主元下标
     *     思想：
     *      1.选择主元
     *      2.遍历数组，将小于主元的数都放在主元左边
     * @param A 数组
     * @param p 需要排序的启始下标
     * @param r ......... 末尾下标
     * @param is_random  true 随机化快速排序法
     * @return
     */
    public int partition(int[] A, int p, int r, boolean is_random){
        int key;
        if(is_random){//这么点东西搞了半天
            int random = (int)(Math.random()*(r-p+1))+p;
            key = A[r];
            A[r] = A[random];
            A[random] = key;
        }
        int i = p;
        int x = A[r];//主元，即最后面的元素为主元
        for(int j=p;j<r;j++){
            if(A[j]<=x){
                //swap A[i] A[j]
                if(i != j) {
                    key = A[j];
                    A[j] = A[i];
                    A[i] = key;
                }
                i++;
            }
        }
        //将主元放在中间
        key = A[r];
        A[r] = A[i];
        A[i] = key;//i即对应主元
//
//        System.out.print("i:"+i+"Array:");SortUtil.show(A);
        return i;
    }

    /**
     * 基本同上，但是随机选取主元
     * @return
     */

    @Test
    public void test(){
        arr = Arr.random(80000);
        int[] arr2 = Arrays.copyOf(arr, arr.length);
        int[] arr3 = Arrays.copyOf(arr, arr.length);
        /**
         * 数据结构
         */
        Date d1 = new Date();
        quickSort2(arr, 0, arr.length-1);
        System.out.println(new Date().getTime() - d1.getTime());
        print();
        /**
         * 算法
         */
        Date d2 = new Date();
        quickSort(arr2, 0, arr.length-1);
        System.out.println(new Date().getTime() - d2.getTime());
        print(arr2);
        /**
         * java
         */
        Date d3 = new Date();
        Arrays.sort(arr3, 0, arr.length-1);
        System.out.println(new Date().getTime() - d3.getTime());
        Arr.print(arr3);
    }

    public int[] quickSort2(int[] a, int p, int r){
        if(p < r) {
            int q = partition2(a, p, r);
            quickSort2(a, p, q-1);
            quickSort2(a, q + 1, r);
        }
        return a;
    }

    /**
     * 4 1 3 2 1 5 8 9
     *           p r
     * @param p 头
     * @param r 尾
     * @return  主元位置
     */
    public int partition2(int[] a, int p, int r) {

        while (p<r) {
            while (p<r&&a[p]<=a[r])
                r--;
            if(p < r) {
                swap(a, p, r);
                p++;
            }
            while (p<r&&a[p]<=a[r])
                p++;
            if(p <r ){
                swap(a, p, r);
            }
            r--;

        }
        return p;
    }
}
//缺省只能在包中调用，protect也只能在包内调用，但是可以被别的包的子类调用