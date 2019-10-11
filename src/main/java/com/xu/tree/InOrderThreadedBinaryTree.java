package com.xu.tree;

/**
 * 中序线索化二叉树
 *     线性化二叉树，提高遍历效率
 */
public class InOrderThreadedBinaryTree<T> {
    private Node<T> pre;

    private Node<T> root = new Node<>();


    class Node<T> {
        /**
         * ltag = 0 , left指向左孩子
         * ltag = 1 , left指向前驱
         * <p>
         * rtag = 0 , right指向右孩子
         * ltag = 1 , right指向后继
         */
        public int ltag;
        public int rtag;
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


    public void threaded(Node<T> node) {
        if (node == null) {
            return;
        }

        threaded(node.left);

        if (node.left == null) {
            node.left = pre;
            node.ltag = 1;
        }

        if(pre!=null&&pre.right == null) {
            pre.right = node;
            pre.rtag = 1;
        }

        pre = node;

        threaded(node.right);
    }

    /**
     * 中序遍历
     */
    public void inOrder(){

        Node<T> node = root;
        while (node != null) {
            while (node.ltag == 0) {
                node = node.left;
            }
            System.out.println(node);
            while (node.rtag == 1) {
                node = node.right;
                System.out.println(node);
            }

            node = node.right;
        }


    }


    public static void main(String[] args) {
        InOrderThreadedBinaryTree<String> tree = new InOrderThreadedBinaryTree<>();
        tree.root = tree.new Node<String>("0");
        InOrderThreadedBinaryTree<String>.Node<String> node1 = tree.new Node<String>("1");
        InOrderThreadedBinaryTree<String>.Node<String> node2 = tree.new Node<String>("2");
        InOrderThreadedBinaryTree<String>.Node<String> node3 = tree.new Node<String>("3");
        InOrderThreadedBinaryTree<String>.Node<String> node4 = tree.new Node<String>("4");

        tree.root.left = node1;
        tree.root.right = node2;

        node2.right = node3;
        node2.left = node4;

        tree.threaded(tree.root);

        System.out.println(node4.left);

        System.out.println("----");

        tree.inOrder();

    }
}
