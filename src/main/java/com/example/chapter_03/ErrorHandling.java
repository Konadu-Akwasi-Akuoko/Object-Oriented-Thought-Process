package com.example.chapter_03;

import java.util.Scanner;

public class ErrorHandling {

    double count = 0;

    public static void main(String[] args) {

        // Scanner scanner = new Scanner(System.in);

        // System.out.println("Type a number we can use to divide 100:");
        // String denominator = scanner.nextLine();

        // while (Double.parseDouble(denominator) == 0 ||
        // Double.parseDouble(denominator) > 100) {
        // System.out.println("We want a number we can use to divide 100 and it must not
        // be 0 or higher than 100:");
        // denominator = scanner.nextLine();
        // }

        // double result = 100 / Double.parseDouble(denominator);

        // System.out.println("The result of 100 divided by " + denominator + " is: " +
        // result);

        // scanner.close();
        ErrorHandling errorHandling = new ErrorHandling();
        errorHandling.tryCatchBlock();
    }

    void tryCatchBlock() {
        try {
            // possible nasty code
            count = 5 / 0;
            System.out.println(count); // This won't run because the line above will trow an error
        } catch (ArithmeticException e) {
            // code to handle the exception
            System.out.println("Error happened");
            System.out.println(e.getMessage());
            count = 1;
        }
        System.out.println("The exception is handled. And now count is: " + count); // count =1
    }

}
