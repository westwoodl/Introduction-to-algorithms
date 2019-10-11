package com.xu.tree;

public class BinaryTreeDemo {

    public static void main(String[] srt) {
        BinaryTree<Integer> tree = new BinaryTree<>(1);

        tree.addLeft(2);
        tree.addRight(3);

        tree.preOrder(tree.root);
        System.out.println("---");
        tree.infixOrder(tree.root);
        System.out.println("---");
        tree.postOrder(tree.root);


    }

}
