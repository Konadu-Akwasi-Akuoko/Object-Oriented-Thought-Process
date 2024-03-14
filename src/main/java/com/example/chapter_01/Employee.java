package com.example.chapter_01;

public class Employee {

    private String name = "John Doe";
    private String socialSecurityNumber;
    private String dateOfBirth;
    private String phoneNumber;

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public String getName() {
        return name;
    }

}
