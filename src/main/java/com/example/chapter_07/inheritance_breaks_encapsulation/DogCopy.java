package com.example.chapter_07.inheritance_breaks_encapsulation;

public class DogCopy {

    public void bark() {
        System.out.println("bark");
    }

    public void barkMany(int numberOfTimes) {
        for (int i = 0; i < numberOfTimes; i += 1) {
            bark();
        }
    }
}