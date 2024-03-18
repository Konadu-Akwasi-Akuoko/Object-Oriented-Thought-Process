package com.example.chapter_04;

/*
 * This class defines a cabbie and assigns a cab
 */
public class Cabbie {

    // ! Attributes
    private static String companyName = "Blue Cab Company";

    // Name of the cabbie/taxi driver
    private String name;

    // Car assigned to cabbie/taxi driver
    private Cab myCab;

    // ! Constructors - multiple constructors
    // Default constructor for the cabbie
    public Cabbie() {
        name = null;
        myCab = null;
    }

    // Name initializing constructor for the cabbie
    public Cabbie(String iName, String serialNumber) {
        name = iName;
        myCab = new Cab(serialNumber);
    }

    // ! Accessor methods (public interfaces)
    // Set the name of the cabbie
    public void setName(String iName) {
        name = iName;
    }

    // Get the name of the cabbie
    public String getName() {
        return name;
    }

    // Get the name of the company
    public static String getCompanyName() {
        return companyName;
    }

    // ! Public interface
    public void giveDestination() {

    }

    // ! Private implementations
    private void turnRight() {

    }

    private void turnLeft() {

    }
}
