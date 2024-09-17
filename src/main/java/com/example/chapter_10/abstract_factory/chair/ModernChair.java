package com.example.chapter_10.abstract_factory.chair;

public class ModernChair implements  Chair{

    @Override
    public void hasLegs() {
        System.out.println("Modern Chair has 7 legs");
    }

    @Override
    public void sitOn() {
        System.out.println("We Chair sit on modern chair");
    }
}
