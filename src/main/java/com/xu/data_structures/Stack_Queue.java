package com.xu.data_structures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 参见
 * @see java.util.Stack
 * @see Queue<>
 */
public class Stack_Queue {
    java.util.Stack<Integer> stack;
    Queue<Integer> queue;
    LinkedList<Integer> linkedList;
    ArrayList<Integer> arrayList;

    private int top;
    private int[] s;
    public Stack_Queue(int[] s){
        top = 0;
        this.s = s;
    }

    public boolean stack_empty(Stack_Queue s){
        return s.top == 0;
    }

    public boolean stack_empty(){
        return this.top == 0;
    }

    void push(int x){
        this.top++;
        this.s[this.top] = x;
    }
}
