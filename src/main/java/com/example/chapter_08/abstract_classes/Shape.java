package com.example.chapter_08.abstract_classes;

public abstract class Shape {
    public String color;

    public Shape(String color) {
        this.color = color;
    }

    public abstract String draw();

    public void showColor() {
        System.err.println("The color of the shape is: " + color);
    }

}
