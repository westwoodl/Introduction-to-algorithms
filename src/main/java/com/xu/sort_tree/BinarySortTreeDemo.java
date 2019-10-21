package com.xu.sort_tree;

/**
 * 二叉排序树
 */
public class BinarySortTreeDemo {

    public static void main(String[] args) {
        BinarySortTree bst = new BinarySortTree();
        bst.add(1);
        bst.add(3);
        bst.add(2);
        bst.add(-1);
        bst.add(4);
        System.out.println(bst);
        System.out.println(bst.searchNode(4));
        System.out.println(bst.searchNode(5));
        System.out.println(bst.searchParent(2));

        bst.delNode(1);
        System.out.println(bst);
    }
}

class BinarySortTree {
    protected Node root;

    public BinarySortTree() {

    }
    public BinarySortTree(int ...arr) {
        for (int x : arr){
            add(x);
        }
    }

    /**
     * 添加节点
     */
    public boolean add(int x) {
        if (root == null) {
            root = new Node(x);
            return true;
        }
        Node cur = root;
        while (true) {
            if (x < cur.data) {
                if (cur.left == null) {
                    cur.left = new Node(x);
                    return true;
                } else {
                    cur = cur.left;
                    continue;
                }
            }
            if (x > cur.data) {
                if (cur.right == null) {
                    cur.right = new Node(x);
                    return true;
                } else {
                    cur = cur.right;
                    continue;
                }
            }
            return false;
        }
    }

    /**
     * 删除节点
     * 三种情况
     */
    public boolean delNode(int x) {
        Node node = searchNode(x);
        if (node == null) {
            return false;
        }
        Node parent = searchParent(x);
        if (parent == null) {

        }
        if (node.right == null && node.left == null) {
            if (parent.left == node) parent.left = null;
            if (parent.right == node) parent.right = null;
        } else if (node.right != null && node.left != null) {
            /**
             * 结点有两个子树
             * 思路：将当前节点和右子树最小的点或左子树最大的点互换，然后删除
             */
            Node par = node;
            Node cur = node.right;
            while (cur.left != null) {
                par = cur;
                cur = cur.left;
            }

            node.data = cur.data;
            if (par == node) par.right = cur.right;
            else par.left = cur.right;


        } else {
            /**
             * 节点只有一个子树
             */
            if (node.left != null) {
                if (parent.left == node) {
                    parent.left = node.left;
                }
                if (parent.right == node) {
                    parent.right = node.left;
                }
            } else {
                if (parent.left == node) {
                    parent.left = node.right;
                }
                if (parent.right == node) {
                    parent.right = node.right;
                }
            }
        }
        return true;
    }

    protected Node searchParent(int x) {
        Node parent = null;
        if (root == null) return null;
        Node cur = root;
        while (cur != null) {
            if (x == cur.data) return parent;
            parent = cur;
            if (x > cur.data) {
                cur = cur.right;
                continue;
            }
            if (x < cur.data) cur = cur.left;
        }
        return null;
    }

    public Node searchNode(int x) {
        if (root == null) return null;
        Node cur = root;
        while (cur != null) {
            if (x == cur.data) return cur;
            if (x > cur.data) {
                cur = cur.right;
                continue;
            }
            if (x < cur.data) cur = cur.left;
        }
        return null;
    }

    private StringBuilder sb;

    @Override
    public String toString() {
        sb = new StringBuilder();

        ind(root);
        return sb.toString();
    }

    /**
     * 中序遍历
     * @param root
     */
    public void ind(Node root) {
        Node cur = root;
        if (cur == null) return;
        ind(cur.left);
        sb.append(cur + " ");
        ind(cur.right);
    }
}

/**
 *
 */
class Node {
    public Node left;
    public Node right;
    public Integer data;

    public Node() {
    }

    /**
     * 以当前节点为根节点的树的高度
     * @return
     */
    public int height(){
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    public int leftHeight(){
        return left == null ? 0 : left.height();
    }

    public int rightHeight(){
        return right == null ? 0 : right.height();
    }

    public Node(Integer data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "(" + data + ")";
    }
}