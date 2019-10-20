package com.xu.tree;

import java.util.*;

/**
 * 赫夫曼树（最优二叉树，带权路径最短）
 * 带权路径长度：叶子节点的值 × 路径长度
 * <p>
 * 赫夫曼厉害之处：
 * 1. 解压
 * 2. 得出的都是前缀编码
 */
public class HuffmanTreeDemo {

    public static void main(String[] args) {
        zip("i like you like me");
        System.out.println(huffmanCode);
    }


    /**
     * 将数组转化为最优二叉树
     *
     * @param arr
     * @return
     */
    public static Node createHuffmanTree(int[] arr, char[] carr) {
        if (arr.length == 0) {
            throw new IllegalArgumentException("Array length must be greater than zero");
        }
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            nodes.add(new Node(arr[i], carr[i]));

        Node cur1 = null;
        Node cur2 = null;
        while (nodes.size() >= 2) {
            Collections.sort(nodes);
            cur1 = nodes.get(0);
            cur2 = nodes.get(1);

            cur1.parent = new Node(cur1.data + cur2.data);
            cur1.parent.left = cur1;
            cur1.parent.right = cur2;
            cur2.parent = cur1.parent;

            nodes.remove(0);
            nodes.remove(0);
            if (nodes.size() == 0) {
                break;
            }
            /**
             * 得出的父节点加入数组中比较
             */
            nodes.add(cur1.parent);
        }
        return cur1 == null ? null : cur1.parent;
    }


    public static void preOrder(Node node) {
        if (node == null) return;
        System.out.println(node);
        preOrder(node.left);
        preOrder(node.right);
    }


    public static HashMap<Character, ArrayList<Byte>> zip(String str) {

        char[] chars = str.toCharArray();

        HashMap<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            charMap.put(chars[i], charMap.get(chars[i]) == null ? 1 : charMap.get(chars[i]) + 1);
        }

        int[] arr = new int[charMap.size()];
        char[] carr = new char[charMap.size()];
        int i = 0;
        for (Map.Entry<Character, Integer> c : charMap.entrySet()) {
            arr[i] = c.getValue();
            carr[i++] = c.getKey();
        }
        Node root = createHuffmanTree(arr, carr);
        /**
         * 由huffman树生成huffman编码
         */
        getRode(root, new ArrayList<Byte>());
        return huffmanCode;
    }

    public static HashMap<Character, ArrayList<Byte>> huffmanCode = new HashMap<>();
    ArrayList<Byte> bytes = new ArrayList<>();

    /**
     * 由huffman树生成huffman编码
     */

    public static void getRode(Node node, ArrayList<Byte> temp2) {
        ArrayList<Byte> temp = (ArrayList<Byte>) temp2.clone();

        if (node.left == null && node.right == null) {
            huffmanCode.put(node.c, temp);
            return;
        }

        if (node.left != null) {
            temp.add((byte) 0);
            getRode(node.left, temp);
            temp.remove(temp.size() - 1);
        }

        if (node.right != null) {
            temp.add((byte) 1);
            getRode(node.right, temp);
        }
    }



}

class Node implements Comparable {
    public Node left;
    public Node right;
    public Node parent;
    public char c;
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

    public Node(int data, char c) {
        this.data = data;
        this.c = c;
    }

    @Override
    public String toString() {
        return "(" + data + ":" + c + ")";
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