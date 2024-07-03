package com.example.chapter_07.inheritance_breaks_encapsulation;

public class Dog {

    public void bark() {
        barkMany(1);
        // System.out.println("bark");
    }

    public void barkMany(int numberOfTimes) {
        for (int i = 0; i < numberOfTimes; i += 1) {
            System.out.println("bark");
        }
    }
}