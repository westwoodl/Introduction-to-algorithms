package com.xu.data_structures.linklist;

import org.junit.Test;

import java.util.Stack;

public class LinkListDemo {

    /**
     * 链表反转
     */
    public static LinkedList reverse(LinkedList list) {
        LinkedList.Node first = list.first;
        LinkedList.Node reverseFirst = new LinkedList().new Node();

        LinkedList.Node cur = first.next;
        while (cur != null) {


            LinkedList.Node next = cur.next; // cur在头插法之后的next必然会丢失，使用变量保存

            cur.next = reverseFirst.next;
            reverseFirst.next = cur;

            cur = next;
        }

        /**
         * ***************************重要***************************
         * 为啥不是first = reverseFirst
         * 因为first指向了list.first，使用如上是修改first的指向地址
         * 而下面的方式是修改first指向的地址的值next（就修改了list.first）
         */
        first.next = reverseFirst.next;
        //first = reverseFirst;
        return list;
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);

        System.out.println(linkedList.size());
        System.out.println(linkedList.get(1));
        System.out.println(linkedList);
        linkedList.insert(4, 5);
        System.out.println(linkedList);
        /**
         * 链表反转
         */
        LinkedList list2 = new LinkedList<>(linkedList, linkedList.size());
        System.out.println(list2);

        reverse(list2);
        System.out.println(list2);


        Stack stack = list2.reverseString();
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }

    }

    @Test
    public void test() {
        LinkedList.Node n1 = new LinkedList().new Node(3);
        LinkedList.Node n2 = new LinkedList().new Node(-1);
        n2.next = new LinkedList().new Node(0);

        n1.next = new LinkedList().new Node(1);
        n1.next.next = new LinkedList().new Node(2);


        n2 = n1;
        System.out.println(n2);

    }

    @Test
    public void testDouble(){

        DoubleLinkedList<Integer> dll = new DoubleLinkedList<>();
        dll.add(1);
        dll.add(2);
        dll.add(3);
        System.out.println(dll);
        System.out.println(dll.delete(2));
        System.out.println(dll);
        dll.add(4);
        dll.add(5);
        dll.add(6);
        System.out.println(dll);
    }
}

/**
 * 单链表
 *
 * @param <T>
 */
class LinkedList<T> {
    protected Node first;

    private int size;


    /**
     * 单链表的反转
     * 使用头插法实现链表的反转
     */
    public void reverse() {

    }


    class Node<T> {
        protected T data;
        protected Node next;

        public Node() {

        }

        public Node(T data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return data == null ? "null" : data.toString();
        }
    }

    public LinkedList() {
        first = new Node();
    }

    /**
     * 头插法
     */
    public LinkedList(LinkedList<T> list, int n) {
        first = new Node();


        Node<T> cur = list.first.next;

        for (int i = 0; i < n && cur != null; i++) {
            Node<T> key = first.next;
            first.next = new Node(cur.data);
            first.next.next = key;

            cur = cur.next;
        }

    }


    public void addHead(T t) {
        Node<T> key = first.next;
        first.next = new Node(t);
        first.next.next = key;
        size++;
    }

    public void add(T t) {
        Node<T> key = first;
        while (key.next != null) {
            key = key.next;
        }
        key.next = new Node(t);
        size++;
    }

    public void addLast(T t) {
        add(t);
    }

    public T get(int index) {
        Node<T> result = first;

        for (int i = 0; i <= index; i++) {
            if (result.next == null) {
                throw new IndexOutOfBoundsException("LinkedList: index > " + i + "  index :" + index);
            }
            result = result.next;

        }
        return result.data;
    }

    public Node getFirst() {
        return first;
    }

    public int size() {
        return size;
    }

    public void insert(int index, T t) {
        if (index > size) {
            throw new IndexOutOfBoundsException("LinkedList: index > " + size + "  index :" + index);
        }
        Node<T> s = first;
        for (int i = 0; i < index; i++) {
            s = s.next;

        }
        Node<T> key = s.next;
        s.next = new Node(t);
        s.next.next = key;
        size++;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> s = first.next;
        while (s != null) {
            sb.append(s.data + " ");
            s = s.next;
        }
        return sb.toString();
    }


    public Stack<T> reverseString() {
        Stack<T> stack = new Stack<>();
        Node<T> node = first.next;
        while (node != null) {
            stack.push(node.data);
            node = node.next;
        }
        return stack;
    }
}

/**
 * 双向链表
 */
class DoubleLinkedList<T> {
    protected Node first;

    private int size;

    class Node<T> {
        protected T data;
        protected Node next;
        protected Node pre;

        public Node() {

        }

        public Node(T data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return data == null ? "null" : data.toString();
        }
    }

    public DoubleLinkedList() {
        first = new Node();
    }

    public void add(T t) {
        Node<T> n = first;
        while (true) {
            if (n.next == null) {
                n.next = new Node(t);
                n.next.pre = n;
                break;
            } else {
                n = n.next;
            }
        }
    }

    public boolean delete(T t) {
        Node<T> node = first.next;
        while (node != null) {
            if (t.equals(node.data)) {
                if(node.next !=null) {
                    node.next.pre = node.pre;
                }
                node.pre.next = node.next;
                return true;
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> node = first.next;
        while (node != null) {
            sb.append(node.data == null ? "null " : node.data + " ");
            node = node.next;
        }
        sb.append("]");
        return sb.toString();
    }
}

/**
 * 循环单链表
 */
class CircleDoubleLinkedList<T> {

    protected Node first;

    private int size;

    class Node<T> {
        protected T data;protected Node next;protected Node pre;
        public Node() {}public Node(T data) { this.data = data; }
        public String toString() { return data == null ? "null" : data.toString(); }
    }

    public CircleDoubleLinkedList(){
        first = new Node();
        first.next = first;
        first.pre = first;
    }

    public void add(T t){
        Node<T> cur = first;

        while(true) {

            if(cur.next == first){

                Node<T> node = new Node<>(t);
                cur.next = node;
                node.next = first;
                node.pre = cur;

                first.pre = node;
                break;
            } else {
                cur = cur.next;
            }



        }
    }

    public void addHead(T t){
        Node<T> node = new Node<>(t);
        first.next.next.pre = node;
        node.next = first.next.next;
        first.next = node;
        node.pre = first;
    }
}