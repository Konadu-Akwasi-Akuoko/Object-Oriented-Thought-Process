package com.example.chapter_05;

public class Main {

    public static void main(String[] args) {
        DrawOnGeneralDevices draw = new DrawOnGeneralDevices(new DrawOnSpecificDevices());

        draw.draw();
        draw.drawOnSpecificDevice();

        DrawWithEffects drawWithEffects = new DrawWithEffects(new DrawOnSpecificDevices());

        drawWithEffects.draw();
        drawWithEffects.drawOnSpecificDevice();
    }

}
