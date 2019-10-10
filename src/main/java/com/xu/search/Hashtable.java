package com.xu.search;

import org.junit.Test;

import java.util.Arrays;
import java.util.Objects;

/**
 * @see java.util.HashMap
 */
public class Hashtable<K, V> {

    public Hashtable(int size) {
        size = size;
        arr = new LinkedList[size];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = new LinkedList<>();
        }
    }

    private LinkedList<K, V>[] arr;
    private int size;

    public void add(K key, V value) {
        arr[hash(key)].add(key, value);
    }


    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    class LinkedList<K, V> {
        public Node<K, V> head;

        public LinkedList(){
            head = new Node();
        }

        /**
         * 我又犯了这个错误，怎么能让空对象的引用赋值呢
         * 赋值给空属性
         * @param key
         * @param value
         */
        public void add(K key, V value) {
            Node<K, V> cur = head;
            while (cur.next != null)
                cur = cur.next;
            cur.next = new Node<>(key, value);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            Node<K, V> cur = head;
            sb.append("[");
            while (cur.next != null) {
                sb.append(cur.next.toString());
                sb.append("->");
                cur = cur.next;
            }
            if (sb.length() > 4)
                sb.delete(sb.length() - 2, sb.length());
            sb.append("]");
            return sb.toString();
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }

    class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> next;

        public Node() {
        }

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + (key == null ? "null" : key) + ": " + (value == null ? "null" : value) + "}";
        }
    }
}


class Emp {
    private int id;
    private String name;
    public Emp next;

    public Emp(int id, String name) {
        id = id;
        name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}