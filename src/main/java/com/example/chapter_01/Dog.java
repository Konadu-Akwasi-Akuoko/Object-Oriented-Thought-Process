package com.example.chapter_01;

public class Dog extends Mammal {
    private int barkFrequency = 3;

    public void bark() {
        // Implementation of bark method
        for (int i = 0; i < barkFrequency; i++) {
            System.err.println("Woof");
        }
    }

    public String speak() {
        return "I am a dog";
    }
}
