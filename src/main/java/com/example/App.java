package com.example;

/**
 * Hello world!
 *
 */
public class App 
{
    static String localVariable = "localVariable";
    public static void main( String[] args )
    {
        System.out.println( localVariable );
        localVariable = "localVariable2";
        System.out.println( localVariable );
    }
}
