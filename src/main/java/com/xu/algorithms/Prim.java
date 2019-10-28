package com.xu.algorithms;

import org.junit.Test;

import java.util.Arrays;

/**
 * Prim算法
 * 最小生成树（Minimum Cost Spanning Tree） MST
 * <p>
 * 蔓延时，对比访问过的的相接的边的长度，取最小。如此往复
 */
public class Prim {

    @Test
    public void test() {

        char[] date = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int verxs = date.length;
        int[][] weight = {
                {0, 5, 7, 0, 0, 0, 2},
                {5, 0, 0, 9, 0, 0, 3},
                {7, 0, 0, 0, 8, 0, 0},
                {0, 9, 0, 0, 0, 4, 0},
                {0, 0, 8, 0, 0, 5, 4},
                {0, 0, 0, 4, 5, 0, 6},
                {2, 3, 0, 0, 4, 6, 0}
        };

        MGraph mGraph = new MGraph(verxs);
        MinTree minTree = new MinTree();
        minTree.createGraph(mGraph, verxs, date, weight);
        minTree.show(mGraph);
        minTree.prim(mGraph, 0);
        minTree.show(mGraph);
    }


    class MGraph {
        int verxs;
        char[] data;
        int[][] weight;

        public MGraph(int verxs) {
            this.verxs = verxs;
            this.data = new char[verxs];
            this.weight = new int[verxs][verxs];
        }
    }

    class MinTree {
        public void createGraph(MGraph graph, int verxs, char data[], int[][] weight) {

            for (int i = 0; i < verxs; i++) {
                graph.data[i] = data[i];
                for (int j = 0; j < verxs; j++) {
                    if(weight[i][j] == 0)
                        weight[i][j] = 10000;
                    graph.weight[i][j] = weight[i][j];
                }
            }
        }

        public void show(MGraph mGraph) {
            for (int[] i : mGraph.weight) {
                System.out.println(Arrays.toString(i));
            }
        }

        /**
         * @param graph
         * @param v     表示从图的第几个顶点开始生成
         */
        public void prim(MGraph graph, int v) {
            int[] visited = new int[graph.verxs];

            visited[v] = 1;

            int h1 = -1;
            int h2 = -1;
            int minWeight = 1000;

            for (int k = 1; k < graph.verxs; k++) {


                for (int i = 0; i < graph.verxs; i++) {
                    for (int j = 0; j < graph.verxs; j++) {
                        if (visited[i] == 1 && visited[j] == 0 && graph.weight[i][j] < minWeight) {
                            /**
                             * 寻找访问过的节点和未访问过的节点间权值最小的边
                             */
                            minWeight = graph.weight[i][j];
                            h1 = i;
                            h2 = j;
                        }
                    }
                }
                /**
                 * 找到一条最小边
                 */
                System.out.println("边" + graph.data[h1] + "-" + graph.data[h2] + "权：" + minWeight);
                minWeight = 1000;
                visited[h2] = 1;
            }

        }
    }

}
