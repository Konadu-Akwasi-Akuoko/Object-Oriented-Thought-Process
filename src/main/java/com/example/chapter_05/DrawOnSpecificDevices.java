package com.example.chapter_05;

public class DrawOnSpecificDevices implements IDrawOnSpecificDevice {

    public void drawOnSpecificDevice() {
        if (System.getProperty("os.name").equals("Windows")) {
            System.out.println("Drawing on Windows devices...");
        } else if (System.getProperty("os.name").equals("Linux")) {
            System.out.println("Drawing on Linux devices...");
        } else if (System.getProperty("os.name").equals("Mac OS X")) {
            System.out.println("Drawing on Mac OS X devices...");
        }
    }

}
