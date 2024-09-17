package com.example.chapter_10.abstract_factory.chair;

public class ArtDecoChair implements  Chair{
    @Override
    public void hasLegs() {
        System.out.println("Art deco chair has 3 legs");
    }

    @Override
    public void sitOn() {
        System.out.println("We sit on art deco chair");
    }
}
