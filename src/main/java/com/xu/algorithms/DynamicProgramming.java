package com.xu.algorithms;

import org.junit.Test;

import java.util.Arrays;

public class DynamicProgramming {

    @Test
    public void test(){
        dp();
        for (int[] x : dp) {
            System.out.println(Arrays.toString(x));
        }

        System.out.println();
        for (int[] x : path) {
            System.out.println(Arrays.toString(x));
        }
    }


    int w[] = {1, 4, 3};//物品的重量
    int v[] = {1500, 3000, 2000};//物品的价值
    int m = 4;//背包的容量
    int n = v.length;//物品的个数

    //dp[i][j] 表示在前i个物品中能够装入容量为j的背包中的最大价值
    /**
     *  0  1     2     3      4     表示背包的容量
     * [0, 0,    0,    0,    0   ]
     * [0, 1500, 1500, 1500, 1500]
     * [0, 1500, 1500, 1500, 3000]
     * [0, 1500, 1500, 2000, 3500]
     */
    int[][] dp = new int[4][5];
    int[][] path = new int[4][5];


    public void dp() {
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (w[i - 1] > j) {
                    /**
                     * 当准备加入的商品的容量大于当前背包的容量
                     * 就使用上一个单元格的装入策略
                     */
                    dp[i][j] = dp[i - 1][j];
                } else {
                    /**
                     * 当准备加入的新增的商品的容量小于等于当前背包的容量
                     * dp[i - 1][j]：上一个单元格的装入的最大值
                     * v[i - 1] + dp[i - 1][j - w[i - 1]]：
                     */
                    //dp[i][j] = Math.max(dp[i - 1][j], v[i - 1] + dp[i - 1][j - w[i - 1]]);
                    if (dp[i - 1][j] < v[i - 1] + dp[i - 1][j - w[i - 1]]) {
                        /**
                         *
                         */
                        dp[i][j] = v[i - 1] + dp[i - 1][j - w[i - 1]];
                        path[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }
    }

}
