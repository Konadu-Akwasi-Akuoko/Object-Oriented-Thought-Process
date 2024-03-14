package com.example.chapter_03;

public class DatabaseReader {

    String dbName;
    int startPosition;

    // initialize just the name
    public DatabaseReader(String name) {
        dbName = name;
        startPosition = 0;
    }

    public DatabaseReader(String name, int pos) {
        dbName = name;
        startPosition = pos;
    }

}
