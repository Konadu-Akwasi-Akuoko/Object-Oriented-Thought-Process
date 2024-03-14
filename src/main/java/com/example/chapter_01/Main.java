package com.example.chapter_01;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Circle circle = new Circle(5);
        Rectangle rectangle = new Rectangle(4, 5);

        System.out.println("Area of circle: " + circle.getArea());
        System.out.println("Area of rectangle: " + rectangle.getArea());
    }

}
