package com.example.chapter_one;

public class MathUser {

    private int myInt1 = 1;
    private int myInt2 = 2;

    int sum() {
        return myInt1 + myInt2;
    }

    public void setInt1(int myIntOne) {
        myInt1 = myIntOne;
    }

    public void setInt2(int myIntTwo) {
        myInt2 = myIntTwo;
    }

    public int getInt1() {
        return myInt1;
    }

    public int getInt2() {
        return myInt2;
    }

}
