package com.xu.algorithms;

import java.util.Arrays;

/**
 * 图的最小生成树
 * 克鲁斯卡尔：
 * 每次选择不能构成回路的最小的边
 * <p>
 * <p>
 *     1.排序
 *     2.判断是否为回路
 * 如何判断是否为回路
 */
public class Kurskal {
    private int edgeNum; //边的个数
    private char[] vertexs;
    private int[][] matrix;
    private static final int INF = Integer.MAX_VALUE;


    public Kurskal(char[] vertexs, int[][] matrix) {
        int vlen = vertexs.length;
        this.vertexs = new char[vlen];
        for (int i = 0; i < vertexs.length; i++) {
            this.vertexs[i] = vertexs[i];
        }
        this.matrix = new int[vlen][vlen];

        for (int i = 0; i < vlen; i++) {
            for (int j = 0; j < vlen; j++) {
                this.matrix[i][j] = matrix[i][j];
            }
        }

        for (int i = 0; i < vlen; i++) {
            for (int j = i+1; j < vlen; j++) {
                if (matrix[i][j] != INF) {
                    edgeNum++;
                }
            }
        }
    }

    public static void main(String[] args) {
        char[] vertexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};

        int[][] matrix = {
                {0, 12, INF, INF, INF, 16, 14},
                {12, 0, 10, INF, INF, 7, INF},
                {INF, 10, 0, 3, 5, 6, INF},
                {INF, INF, 3, 0, 4, INF, INF},
                {INF, INF, 5, 4, 0, 2, 8},
                {16, 7, 6, INF, 2, 0, 9},
                {14, INF, INF, INF, 8, 9, 0}
        };

        Kurskal kurskal = new Kurskal(vertexs, matrix);
        kurskal.print();

        kurskal.kurskal();

    }

    /**
     * 克鲁斯卡尔算法
     */
    public void kurskal(){
        int index = 0;
        int[] ends = new int[edgeNum];//顶点的终点
        //最小生成树
        EData[] result = new EData[edgeNum];
        //所有的边
        EData[] edges = getEdges();
        System.out.println(Arrays.toString(edges) + "共" + edges.length);

        sortEdge(edges);

        for(int i = 0;i<edgeNum;i++){
            /**
             * 获取两个顶点
             */
            int p1 = getPosition(edges[i].start);
            int p2 = getPosition(edges[i].end);
            /**
             * 获取两个顶点的终点
             */
            int m = getEnd(ends, p1);
            int n = getEnd(ends, p2);
            /**
             * 不能构成回路
             */
            if(m != n) {
                ends[m] = n;
                result[index++] = edges[i];//该边符合最小生成树
            }
        }

        System.out.println(Arrays.toString(result));

    }

    /**
     * d对边排序
     * @param edges
     */
    private void sortEdge(EData[] edges) {

        for (int i = 0; i < edges.length - 1; i++) {
            for (int j = 0; j < edges.length - 1 - i; j++) {
                if(edges[j].weight > edges[j+1].weight){
                    EData tmp = edges[j];
                    edges[j] = edges[j+1];
                    edges[j+1] = tmp;
                }
            }
        }
    }

    private int getPosition(char ch){
        for(int i = 0;i<vertexs.length;i++){
            if(ch==vertexs[i]) {
                return i;
            }
        }
        return -1;
    }

    private EData[] getEdges(){
        int index = 0;
        EData[] edges = new EData[edgeNum];
        for (int i =0;i<vertexs.length;i++){
            for(int j = i+1;j<vertexs.length;j++){
                if(matrix[i][j] != INF){
                    edges[index++] = new EData(vertexs[i], vertexs[j], matrix[i][j]);
                }
            }
        }
        return edges;
    }

    /**
     * 获取一个顶点的终点
     */
    private int getEnd(int[] ends, int i){

        while (ends[i] !=0) {
            i = ends[i];
        }
        return i;
    }

    public void print() {
        for (int[] x : matrix) {
            System.out.println(Arrays.toString(x));
        }
    }
}

class EData {
    char start; //边的起点
    char end; //边的终点
    int weight;

    public EData(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "<" + start +
                "," + end +
                ">=" + weight;
    }
}
