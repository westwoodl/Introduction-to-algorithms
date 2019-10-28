package com.xu.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * 图的节点的遍历策略：
 * 深度优先遍历 DFS: Depth First Search 一直访问下一个节点
 * <p>
 * 广度优先遍历 BFS: Broad First Search 将当前节点的所有邻接节点访问一遍
 */
public class Graph {
    private ArrayList<String> vertexList;
    private int[][] edge;
    private int edgeNum;
    private boolean[] isVisited;

    public Graph(int n) {
        this.vertexList = new ArrayList<>(n);
        this.edge = new int[n][n];
        this.edgeNum = 0;
        this.isVisited = new boolean[5];
    }

    /**
     * 返回第一个邻接结点的下标
     *
     * @param index
     * @return
     */
    public int getFirstNeighbor(int index) {
        for (int j = 0; j < vertexList.size(); j++) {
            if (edge[index][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    /**
     * 下一个邻接点的下标
     *
     * @param v1
     * @param v2
     * @return
     */
    public int getNextNeighbor(int v1, int v2) {
        for (int j = v2 + 1; j < vertexList.size(); j++) {
            if (edge[v1][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    private void dfs(int i) {
        System.out.print(getValueByIndex(i) + "->");
        isVisited[i] = true;
        int w = getFirstNeighbor(i);
        while (w != -1) {
            if (!isVisited[w]) {
                dfs(w);
            }
            w = getNextNeighbor(i, w);
        }
    }

    private void bfs(int i) {
        int u;
        int w;
        //节点访问顺序
        LinkedList queue = new LinkedList<>();
        System.out.print(getValueByIndex(i) + "->");
        isVisited[i] = true;
        queue.addLast(i);
        while (!queue.isEmpty()) {
            u = (int) queue.removeFirst();
            w = getFirstNeighbor(u);
            while (w != -1){
                if(!isVisited[w]) {
                    System.out.print(getValueByIndex(w) + "->");
                    isVisited[w] = true;
                    queue.addLast(w);
                }
                w = getNextNeighbor(u, w);
            }
        }
    }


    public static void main(String[] args) {
        Graph graph = new Graph(5);
        for (String s : new String[]{"A", "B", "C", "D", "E"})
            graph.insertVertex(s);

        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);

        graph.show();

        graph.bfs(0);
    }

    public String getValueByIndex(int n) {
        return vertexList.get(n);
    }


    /**
     * 添加节点
     *
     * @param vertex
     */
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    /**
     * 添加边
     */
    public void insertEdge(int v1, int v2, int weight) {
        edge[v1][v2] = weight;
        edge[v2][v1] = weight;
        edgeNum++;
    }


    public void show() {
        for (int[] link : edge) {
            System.out.println(Arrays.toString(link));
        }
    }

}
