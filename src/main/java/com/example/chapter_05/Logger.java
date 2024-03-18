package com.example.chapter_05;

import java.io.IOException;
import java.io.Writer;

public class Logger {

    private final Writer writer;

    public Logger(Writer writer) {
        this.writer = writer;
    }

    public void log(String message) throws IOException {
        writer.write(message + "\n");
    }
}
