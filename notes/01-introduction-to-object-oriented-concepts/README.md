# Introduction To Object Oriented Concepts

## The fundamental concepts

Object-oriented languages are defined by the following: encapsulation, inheritance, and polymorphism, and composition. Thus, if a language does not implement all of these, it is generally not considered completely object-oriented.

## Procedural vs Object Oriented Programming

> What exactly is an object in OOP? Basically an object is defined by two components: attributes and behaviors.

A person has attributes, such as eye color, age, height, and so on. A person also has behaviors, such as walking, talking, breathing, and so on. **In its basic definition, an object is an entity that contains both attribute and behavior.**

> **In its basic definition, an object is an entity that contains both attribute(data) and behavior(methods).**

So we can basically say that the **attribute** is also known more programmatically as the **data**, and the **behavior** is known more programmatically as the **methods** of an object.

In procedural programming, for example, code is placed into totally distinct functions or procedures, and these functions can also mutate the global scope. Data is also placed into separate structures and is manipulated by these functions or procedures. These procedures(functions) then become “black boxes,” where inputs go in and outputs come out.

> **Difference Between OO and Procedural** -  In OO design, the attributes and behaviors are contained within a single object, whereas in procedural, or structured, design the attributes and behaviors are normally separated.

In structured or procedural programming the data is often separated from the procedures, and often the data is global, so it is easy to modify data that is outside the scope of your code. This means that access to data is uncontrolled and unpredictable (that is, multiple functions may have access to the global data). Second, because you have no control over who has access to the data, testing and debugging are much more difficult. Objects address these problems by combining data and behavior into a nice, complete package.

> **Proper Design** - We can state that when properly designed, there is no such thing as global data in an OO model. This fact provides a high amount of data integrity in OO systems.

Objects are much more than data structures and primitive data types, such as integers
and strings. Although objects do contain entities such as integers and strings, which are used to represent attributes, they also contain methods, which represent behaviors.

In an object, methods are used to perform operations on the data as well as other actions. Perhaps more important, you can control access to members of an object (both attributes and methods). This means that some members, both attributes and methods, can be hidden from other objects. For instance, an object called Math might contain two integers, called myInt1and myInt2. Most likely, the Math object also contains the necessary methods to set and retrieve the values of myInt1 and myInt2. It might also contain a method called sum() to add the two integers together. Check out the example below. ([Typescript version](/typescript/chapter_one/Maths.ts))

```java
public class Math {

    // Here, myInt1 and myInt2 are attributes of the Math object. They are private, meaning they are hidden from other objects.
    private int myInt1 = 1;
    private int myInt2 = 2;

    // This is a method called sum(). It performs an operation on the data (myInt1 and myInt2) by adding them together.
    int sum() {
        return myInt1 + myInt2;
    }

    // These are methods used to set the values of myInt1 and myInt2. They control access to these attributes.
    public void setInt1(int myIntOne) {
        myInt1 = myIntOne;
    }

    public void setInt2(int myIntTwo) {
        myInt2 = myIntTwo;
    }

    // These are methods used to retrieve the values of myInt1 and myInt2. They also control access to these attributes.
    public int getInt1() {
        return myInt1;
    }

    public int getInt2() {
        return myInt2;
    }

}
```

So basically if we did not add the getters and setters methods the `myInt1` and `myInt2` will never or cannot be accessed from any place in our code, except inside the class in which it was declared.

> **Data Hiding** -  In OO terminology, data are referred to as attributes, and behaviors are referred to as methods. Restricting access to certain attributes and/or methods is called data hiding.

### Encapsulation

By combining the attributes and methods in the same entity, which in OO parlance is
called **encapsulation**, we can control access to the data in the Math object. By defining these integers as off-limits, another logically unconnected function cannot manipulate the integers `myInt1` and `myInt2` — only the Math object can do that.

> **Encapsulation** is the principle that binds together the data and functions that manipulate the data, and that keeps both safe from outside interference and misuse. The data of an object is known as its attributes, and the functions/methods that can be performed on that data are known as methods.

- **Sound Class Design Guidelines** - Keep in mind that it is possible to create poorly designed OO classes that do not restrict access to class attributes. The bottom line is that you can design bad code just as efficiently with OO design as with any other programming methodology. Simply take care to adhere to sound class design guidelines.

In general, objects should not manipulate the internal data of other objects (that is, `myObject` which is an instance of the `Math` object should not directly change the value of `myInt1` and `myInt2` ). And it is normally better to build small objects with specific tasks rather than build large objects that perform many.

## What exactly is an object?

Objects are the building blocks of an OO program. A program that uses OO technology is basically a collection of objects. To illustrate, let’s consider that a corporate system contains objects that represent employees of that company. Each of these objects is made up of the data and behavior described in the following sections.

### Object data

The data stored within an object represents the state of the object. In OO programming terminology, this data is called **attributes**.

So basically we can create an employee and give it **attributes** such as Social Security numbers, date of birth, gender, phone number, and so on. The below example shows an object with the mentioned data or attributes.

```java
public class Employee {

    private String name;
    private String socialSecurityNumber;
    private String dateOfBirth;
    private String phoneNumber;

}
```

### Object Behaviors

The behavior of an object represents what the object can do. In procedural languages the behavior is defined by procedures, functions, and subroutines. In OO programming terminology, these behaviors are contained in methods, and you invoke a method by sending a message to it. In our employee example, consider that one of the  behaviors required of an employee object is to set and return the values of the various attributes. Thus, each attribute would have corresponding methods, such as setGender() and getGender(). In this case, when another object needs this information, it can send a message to an employee object and ask it what its gender is. The below example shows how these methods work.

```java
package com.example.chapter_one;

public class Employee {

    ...

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

}
```

> **Getters and Setters** - The concept of getters and setters supports the concept of data hiding. Because other objects should not directly manipulate data within another object, the getters and setters provide controlled access to an object's data. Getters and setters are sometimes called accessor methods and mutator methods, respectively.

The following information is all the user needs to know to effectively use the methods:

- The name of the method
- The parameters passed to the method
- The return type of the method

So let's say we have a `Payroll` object which contains a method called CalculatePay()that calculates the pay for a specific employee. Among other information, the Payroll object must obtain the Social Security number of this employee. To get this information, the payroll object must send a message to the Employee object (in this case, the getSocialSecurityNumber()method). Basically, this means that the Payroll object calls the getSocialSecurityNumber() method of the Employee object. The employee object recognizes the message and returns the requested information.

The below diagram is a class diagram representing the Employee/Payroll system we have been talking about.

![A UML diagram of the class representing Employee and Payroll classes](/uml/chapter_one/employee-payroll.png)
