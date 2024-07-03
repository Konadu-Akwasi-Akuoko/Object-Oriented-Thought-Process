package com.example.chapter_08.abstract_classes;

public class Main {

    public static void main(String[] args) {
        Circle circleOne = new Circle("Blue");
        Square squareOne = new Square("Yellow");

        System.out.println(circleOne.draw());
        System.out.println(squareOne.draw());

        circleOne.showColor();
        squareOne.showColor();

    }

}
