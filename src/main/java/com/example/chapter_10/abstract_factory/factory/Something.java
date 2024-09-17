package com.example.chapter_10.abstract_factory.factory;

import com.example.chapter_10.abstract_factory.chair.Chair;
import com.example.chapter_10.abstract_factory.chair.VictorianChair;


public class Something {
     static Chair chair () {
        return new VictorianChair();
    }


    public static void main(String[] args) {
        Chair vic = chair();

        chair().hasLegs();
    }
}
