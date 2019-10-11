package com.xu.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 赫夫曼树
 */
public class HuffmanTreeDemo {
    public static void main(String[] args) {
        int[] s = {1,2,3,4,5};
        createHuffmanTree(new int[]{13, 7, 8, 3, 29, 6, 1});
    }

    public static Node createHuffmanTree(int[] arr) {

        List<Node> nodes = new ArrayList<>();

        for (int i : arr)
            nodes.add(new Node(i));

        while (nodes.size() > 1) {

            Collections.shuffle(nodes);

        }


        Node root = null;




        return root;
    }


}

class Node implements Comparable {
    public Node left;
    public Node right;

    public int data;

    public Node() {
    }

    /**
     * 内部类里面一定要写this    草
     * data
     */
    public Node(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }


    @Override
    public int compareTo(Object o) {
        return this.data - ((Node) o).data;
    }
}

/*
wpl
 路径长度为分支
 */