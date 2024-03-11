package com.example.chapter_one;

public class Circle extends Shape {

    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        area = 3.14 * (radius * radius);
        return (area);
    }

}
