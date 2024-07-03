package com.example.chapter_08.abstract_classes;

public class Square extends Shape {

    public Square(String color) {
        super(color);
    }

    @Override
    public String draw() {
        return "drawing a square";
    }
}
