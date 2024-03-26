package com.example.chapter_06;

public class TestMath {
    public static void main(String[] args) {

        System.out.println("\007");

        int x = 0;

        SomeMath math = new SomeMath();
        x = math.add(1, 2);
        System.out.println("x = " + x);

        int y = 53;

        // y = math.fib(y);
        // System.out.println("y = " + y);
    }
}
