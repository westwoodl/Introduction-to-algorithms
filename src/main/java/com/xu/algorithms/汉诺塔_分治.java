package com.xu.algorithms;

import org.junit.Test;

public class 汉诺塔_分治 {

    @Test
    public void test(){
        hannuota("a", "b", "c", 64);
    }

    public void hannuota(String a, String b, String c, int num){
        if(num == 1) {
            System.out.println(a + "->" + c);
        } else {
            hannuota(a, c, b, num - 1);
            System.out.println(a + "->" + c);
            hannuota(b, a, c, num-1);
        }

    }
}
