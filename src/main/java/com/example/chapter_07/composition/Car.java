package com.example.chapter_07.composition;

public class Car {
    private SteeringWheel steeringWheel;
    private Stereo stereo;

    public void steer() {
        steeringWheel.steer();
    }

    public void playMusic() {
        stereo.playMusic();
    }

}
