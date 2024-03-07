package com.example.chapter_one;

public class SquareOfNumber {
    // private attribute
    private int squareValue;

    // public interface
    public int getSquare(int value) {
        squareValue = calculateSquare(value);
        return squareValue;
    }

    // private implementation
    private int calculateSquare(int value) {
        return (int) Math.pow(value, 2);
    }
}