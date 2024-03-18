package com.example.chapter_05;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriteFile {

    public static void main(String[] args) throws IOException {
        Writer writeFile = new FileWriter("log.txt");
        Logger logger = new Logger(writeFile);
        logger.log("Hello World!");
        writeFile.close();
    }

}
