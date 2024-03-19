package com.example.chapter_05;

public class DatabaseReader {

    private String[] db = { "Record1", "Record2", "Record3", "Record4", "Record5" };
    private boolean DBOpen = false;
    private int pos;

    public void open(String name) {
        DBOpen = true;
    }

    public void close() {
        DBOpen = false;
    }

    public void goToFirst() {
        pos = 0;
    }

    public void goToLast() {
        pos = 4;
    }

    public int howManyRecords() {
        int numOfRecords = 5;
        return numOfRecords;
    }

    public String getRecord(int key) {
        /* DB Specific Implementation */
        return db[key];
    }

    public String getNextRecord() {
        /* DB Specific Implementation */
        return db[pos++];
    }
}