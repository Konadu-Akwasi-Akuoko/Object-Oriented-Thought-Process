package com.example.chapter_05;

public class DrawWithEffects extends DrawOnGeneralDevices {

    private final DrawOnSpecificDevices drawOnSpecificDevice;

    public DrawWithEffects(DrawOnSpecificDevices drawOnSpecificDevice) {
        super(drawOnSpecificDevice);
        this.drawOnSpecificDevice = drawOnSpecificDevice;
    }

    public void drawWithShadow() {
        System.out.println("Drawing with shadow effect...");
        draw(); // Call the inherited draw() for general drawing
    }

    @Override
    public void drawOnSpecificDevice() {
        System.out.println("Drawing with shadow effect on specific device...");
        drawOnSpecificDevice.drawOnSpecificDevice(); // Call the inherited drawOnSpecificDevice() for specific drawing
    }
}
