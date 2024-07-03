package com.example.chapter_07.inheritance_breaks_encapsulation;

public class VerboseDog extends Dog {

    @Override
    public void barkMany(int numberOfTimes) {
        System.out.println("As a dog, I say: ");
        for (int i = 0; i < numberOfTimes; i += 1) {
            super.bark();
        }
    }

    public static void main(String[] args) {
        VerboseDog dog = new VerboseDog();
        dog.barkMany(3);
    }

}
