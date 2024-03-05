package com.example.chapter_one;

public class ClassToObject {

    public static class Employee {

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

    public static void main(String[] args) {

        Employee employee = new Employee();

        System.err.println(employee.getName());

    }

}
