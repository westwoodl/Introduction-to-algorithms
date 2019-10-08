package com.xu.data_structures.linklist;


import java.util.Arrays;
import java.util.Scanner;

public class CircleArrayQueueDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayQueue<String> arrayQueue = new ArrayQueue<>(4);

        while (true) {
            System.out.println("add(value");
            System.out.println("get");

            String str = scanner.nextLine();
            if (str.contains("add(") ) {
                String s =  str.split("\\(")[1];
                if(arrayQueue.add(s)){
                    System.out.println("添加成功");
                } else {
                    System.out.println("添加失败");
                }
            } else if (str.equals("get")){
                try {
                    System.out.println("get:" + arrayQueue.get());
                }catch (Exception e){
                    e.printStackTrace();
                }
            } else if (str.equals("e")){
                scanner.close();
                break;
            }
            arrayQueue.show();
            System.out.println(arrayQueue.toString() + "\r\n---------------");

        }


    }

}

/**
 * 循环队列
 * 抓住front和rear的指向
 * 此类做出如下约定：
 *     front指向对头前一个元素，rear指向队尾元素
 * @param <T>
 */
class ArrayQueue<T> {
    private Object[] a;
    /**
     * 队头元素的前一个元素
     */
    private int front;
    /**
     * 指向对队尾元素
     */
    private int rear;
    /**
     * 最大长度
     */
    private int maxSize;

    public ArrayQueue(int size) {
        a = new Object[size];
        maxSize = size;
        front = 0;
        rear = 0;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean add(T t) {
        if (isFull()) {
            return false;
        }
        rear = (rear + 1) % maxSize;
        a[rear] = t;
        return true;
    }

    public T get() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("ArrayQueue is empty");
        }
        front = (front + 1) % maxSize;
        T value = (T) a[front];
        return value;
    }

    @Override
    public String toString() {
        return Arrays.toString(a);
    }

    public void show() {
        System.out.print("front:" + front + " rear:" + rear + ";");
        for (int i = front + 1; i != (rear + 1)%maxSize; i = (i + 1)%maxSize) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
