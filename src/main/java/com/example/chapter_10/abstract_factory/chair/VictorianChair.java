package com.example.chapter_10.abstract_factory.chair;

public class VictorianChair implements Chair {
    @Override
    public void hasLegs() {
        System.out.println("This victorian chair has 5 legs");
    }

    @Override
    public void sitOn() {
        System.out.println("We sit on this victorian chair");
    }
}
