package com.example.chapter_07.inheritance;

public class GoldenRetriever extends Dog {
    public int retrievalSpeed;

    public GoldenRetriever() {
        super();
        retrievalSpeed = 0;
    }

    public void retrieve() {
        System.out.println("Retrieving!");
        bark();
    }
}
