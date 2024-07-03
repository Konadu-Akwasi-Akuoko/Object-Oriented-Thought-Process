package com.example.chapter_07.inheritance;

public class Dog {

    public int barkFrequency;
    public int pantRate;

    public Dog() {
        barkFrequency = 0;
        pantRate = 0;
    }

    public void bark() {
        System.out.println("Bark!");
    }

    public void pant() {
        System.out.println("Pant!");
    }

    private void swim() {
        System.out.println("swim");
    }

}
