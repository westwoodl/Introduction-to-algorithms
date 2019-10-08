package com.xu.data_structures.stack_queue;

/**
 * 后缀表达式计算器
 */
public class JiSuanQi {
    /**
     * 数
     */
    private LinkedStatck<Double> num;

    /**
     * 运算符
     */
    private LinkedStatck<Character> operator;

    public final static int ADD = 1;
    public final static int SUB = 1;
    public final static int MUL = 2;
    public final static int DIV = 2;
    public final static int LEFT = 3;
    public final static int RIGHT = 3;


}
