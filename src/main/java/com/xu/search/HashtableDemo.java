package com.xu.search;

import org.junit.Test;

public class HashtableDemo {

    @Test
    public void test() {

        Hashtable<Integer, String> table = new Hashtable<>(16);

        table.add(1, "fuck");
        table.add(1, "you");
        table.add(2, "asdad");
        table.add(3, "zvz");
        table.add(4, "ruy");
        System.out.println(table);

        Hashtable.LinkedList linkedList = new Hashtable(16).new LinkedList();

        linkedList.add(1, "2");
        linkedList.add(2, "2");

        System.out.println(linkedList);

    }

    public static void main(String[] args) {
        new HashtableDemo().new InnerClass();

    }

    class InnerClass {
    }

}
