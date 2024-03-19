package com.example.chapter_05;

public class Math {

    public int swap(int a, int b) {
        int temp = 0;

        temp = a;
        a = b;
        b = temp;

        return temp;
    }

}
