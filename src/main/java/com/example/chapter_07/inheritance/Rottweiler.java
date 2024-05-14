package com.example.chapter_07.inheritance;

public class Rottweiler extends Dog {
    public int guardEffieciency;

    public Rottweiler() {
        super();
        guardEffieciency = 0;
    }

    public void guards() {
        System.out.println("Guarding!");
    }

}
