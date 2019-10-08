package com.xu.data_structures.stack_queue;

import java.util.Scanner;

public class LinkedStatckDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedStatck<String> statck = new LinkedStatck<>();
        while (true) {
            String str = scanner.nextLine();

            if ("pop".equals(str)) {
                try {
                    statck.pop();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else if (str.contains("push")) {
                try {
                    statck.push(str.split(" ")[1]);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            System.out.println(statck);
        }
    }
}

/**
 * 链栈
 * @param <T>
 */

class LinkedStatck<T> {

    class Node<T> {
        protected T data;
        protected Node<T> next;

        public Node() {
        }

        public Node(T data) {
            this.data = data;
        }

        public String toString() {
            return data == null ? "null" : data.toString();
        }
    }

    private Node<T> top;

    private int size;

    public LinkedStatck() {
        top = new Node<>();
        size = 0;
    }


    public void push(T t) {
        Node<T> node = new Node<>(t);
        node.next = top.next;
        top.next = node;
        size++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Statck is empty");
        }
        T t = top.next.data;
        top.next = top.next.next;
        size--;
        return t;
    }

    public boolean isEmpty() {
        return top.next == null;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node cur = top.next;
        sb.append("[");
        while (cur != null) {
            sb.append(cur.data + ", ");
            cur = cur.next;
        }
        if (sb.length() > 3)
            sb.delete(sb.length() - 2, sb.length());
        sb.append("]");

        return sb.toString();
    }
}
