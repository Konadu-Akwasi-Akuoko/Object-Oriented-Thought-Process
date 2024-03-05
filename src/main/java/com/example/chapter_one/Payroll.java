package com.example.chapter_one;

public class Payroll {

    public Payroll() {
        String name;
        // Instantiate a new Person object
        Person person = new Person();
        // Call the public method setName() on the person object
        person.setName("John Doe");
        name = person.getName();

        System.out.println(name);
    }
}
