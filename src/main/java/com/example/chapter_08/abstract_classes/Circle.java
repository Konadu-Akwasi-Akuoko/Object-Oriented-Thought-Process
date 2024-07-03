package com.example.chapter_08.abstract_classes;

public class Circle extends Shape {

    public Circle(String color) {
        super(color);

    }

    @Override
    public String draw() {
        return "Drawing a circle";
    }

}
