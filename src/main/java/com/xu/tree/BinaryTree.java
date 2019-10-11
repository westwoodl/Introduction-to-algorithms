package com.xu.tree;

import org.junit.Test;

public class BinaryTree<T> {

    public Node<T> root;

    public BinaryTree(T t){root = new Node<>(t);}

    class Node<T> {
        public Node<T> left;
        public Node<T> right;

        public T data;

        public Node() {
        }

        /**
         * 内部类里面一定要写this    草
         * data
         */
        public Node(T data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return data == null ? "null" : data.toString();
        }
    }


    public void preOrder(Node<T> node) {
        if (node == null) return;
        System.out.println(node);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void infixOrder(Node<T> node) {
        if (node == null) return;

        infixOrder(node.left);
        System.out.println(node);
        infixOrder(node.right);
    }

    public void postOrder(Node<T> node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node);
    }

    public void add(T t) {
        if (root == null) {
            root = new Node<>(t);
        }
    }

    public void addRight(T t) {
        root.right = new Node<>(t);
    }

    public void addLeft(T t) {
        root.left = new Node<>(t);
    }


}
