package com.xu.sort_tree;

import com.xu.util.Arr;
import org.junit.Test;

public class AVLTreeDemo {
    @Test
    public void test() {

        int[] x = {35, 20, 40, 15, 30, 25};
        AVLTree tree = new AVLTree(x);

        System.out.println(tree);
        System.out.println(tree.leftHeight());
        System.out.println(tree.rightHeight());

        System.out.println(tree.root);

        tree.add(9899);
        System.out.println(tree.root);

        System.out.println(tree);

        tree.print(tree.root);
    }
}

/**
 * 平衡二叉树 balance binary tree
 * 二叉排序树容易退化成链表，而平衡二叉树的两个子树的高度差不超过1
 * avl tree 有 红黑树
 */
class AVLTree extends BinarySortTree {

    public final static int BALANCE_FACTOR = 1;

    public AVLTree() {
    }

    public AVLTree(int... arr) {
        for (int a : arr) {
            add(a);
        }
    }

    @Override
    public boolean add(int x) {

        boolean res = super.add(x);
        if (res) {
            avl();
            return true;
        } else return false;
    }

    /**
     * 最小失衡子树节点
     *
     * @return
     */
    public Node unnBalanceNode(Node node) {
        if (isavl(node)) {
            return null;
        } else {
            if (node.leftHeight() > node.rightHeight() + 1) {
                if (unnBalanceNode(node.left) == null) {
                    return node;
                } else {
                    return unnBalanceNode(node.left);
                }
            } else {
                if (unnBalanceNode(node.right) == null) {
                    return node;
                } else {
                    return unnBalanceNode(node.right);
                }
            }

        }
    }

    /**
     * 返回右子树高度
     */
    public int rightHeight() {
        if (root == null) throw new IllegalStateException("avl have not initlization");
        return root.right == null ? 0 : root.right.height();
    }

    /**
     * 返回左子树高度
     */
    public int leftHeight() {
        if (root == null) throw new IllegalStateException("avl have not initlization");
        return root.left == null ? 0 : root.left.height();
    }

    protected boolean isavl(Node node) {
        return Math.abs(node.rightHeight() - node.leftHeight()) <= 1;
    }

    /**
     * 右子树的高度高于左子树 + 1，开始左旋
     * 左子树的高度高于右子树 + 1，开始右旋
     */
    protected void avl() {
        int r = rightHeight();
        int l = leftHeight();

        if (Math.abs(r - l) > 1) {
            /**
             * 找到最小失衡子树
             */
            Node node = unnBalanceNode(root);

            if (r > l + 1) {
                leftRotate(node);
                return;
            }
            if (l > r + 1) {
                rightRotate(node);
            }
        }
    }

    /**
     * 左旋
     * 右子树的高度高于左子树，开始左旋
     */
    protected void leftRotate(Node node) {
        if (node.right != null && node.right.leftHeight() > node.right.rightHeight()) {
            Node temp = node.right;
            node.right = temp.left;
            temp.left = node.right.right;
            node.right.right = temp;
            leftRotate(node);
        } else {
            Node temp = node.right;
            node.right = temp.left;
            temp.left = node;
            this.root = temp;
        }
    }

    protected void rightRotate(Node node) {
        if (node.left != null && node.left.rightHeight() > node.left.leftHeight()) {
            Node temp = node.left;
            node.left = temp.right;
            temp.right = node.left.left;
            node.left.left = temp;
            rightRotate(node);
        } else {
            Node temp = node.left;
            node.left = temp.right;
            temp.right = node;
            this.root = temp;
        }
    }


    public void print(Node node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        print(node.left);
        print(node.right);
    }

}
