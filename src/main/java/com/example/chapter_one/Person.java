package com.example.chapter_one;

public class Person {

    // Attributes
    private String name;
    private String address;

    // Methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String adr) {
        address = adr;
    }

    private void printName() {
        System.out.println(name);
    }

    public static void main(String[] args) {
        Person person = new Person();
        person.setName("John Doe");
        person.printName();
    }
}
