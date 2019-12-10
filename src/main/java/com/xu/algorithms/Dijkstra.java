package com.xu.algorithms;

import java.util.Arrays;

/**
 * 图的最短路径
 */
public class Dijkstra {
    final static int N = 65535;

    public static void main(String[] args) {
        Dijkstra dijkstra = new Dijkstra();
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};

        int[][] matrix = {
                {N, 5, 7, N, N, N, 2},
                {5, N, N, 9, N, N, 3},
                {7, N, N, N, 8, N, N},
                {N, 9, N, N, N, 4, N},
                {N, N, 8, N, N, 5, 4},
                {N, N, N, 4, 5, N, 6},
                {2, 3, N, N, 4, 6, N}
        };
        MGraph graph = dijkstra.new MGraph(vertex, matrix);

        graph.show();
    }

    class MGraph {
        char[] vertex;
        int[][] matrix;
        int vertexNum;

        public MGraph(char[] verxs, int[][] matrix) {
            this.vertex = verxs;
            this.matrix = matrix;
            vertexNum = verxs.length;
        }

        void show() {
            for (int[] link : matrix) {
                System.out.println(Arrays.toString(link));
            }
        }
    }


    int[] dist;//两顶点的路径长度
    String[] path;//两顶点的路径
    int[] s;

    void dijkstra(MGraph g, int v) {
        for (int i = 0; i < g.vertexNum; i++) {
            dist[i] = g.matrix[v][i];
            if (dist[i] != N)
                path[i] = g.vertex[v] + g.vertex[i] + "";
            else
                path[i] = "";
        }
        s[0] = v;
        dist[v] = 0;
        int num = 1;

        while (num < g.vertexNum) {
            int k;
            for (int i = 0; i < g.vertexNum; i++) {
                if ((dist[i] != 0) && (dist[i] < dist[k]))
                    k = i;
            }
            System.out.println(dist[k] + " " + path[k]);
            s[num++] = k;
            for (int i = 0;i<g.vertexNum;i++){
                if(dist[i]>dist[k] + g.matrix[k][i]) {
                    dist[i] = dist[k] + g.matrix[k][i];
                    path[i] = path[k] + g.vertex[i];
                }
            }
            dist[k] = 0;
        }

    }
}
