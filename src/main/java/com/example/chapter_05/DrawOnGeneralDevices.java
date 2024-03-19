package com.example.chapter_05;

public class DrawOnGeneralDevices implements IDrawOnSpecificDevice {

    private final DrawOnSpecificDevices drawOnSpecificDevice;

    public DrawOnGeneralDevices(DrawOnSpecificDevices drawOnSpecificDevice) {

        this.drawOnSpecificDevice = drawOnSpecificDevice;

    }

    public void draw() {
        System.out.println("Drawing on general devices...");
    }

    public void drawOnSpecificDevice() {
        drawOnSpecificDevice.drawOnSpecificDevice();
    }

}
