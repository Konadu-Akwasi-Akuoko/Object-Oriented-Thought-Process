package com.example.chapter_01;

public class Cat extends Mammal {
    private int meowFrequency = 3;

    public void meow() {
        // Implementation of meow method
        for (int i = 0; i < meowFrequency; i++) {
            System.err.println("Meow");
        }
    }
}
