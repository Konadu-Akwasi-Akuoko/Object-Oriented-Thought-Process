package com.example.chapter_06;

public class SomeMath {
    public int add(int a, int b) {
        return a + b;
    }

    public static int fib(int n) {
        System.out.println(n);
        if (n < 2) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }
}
