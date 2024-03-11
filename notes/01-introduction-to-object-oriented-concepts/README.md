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

Each class diagram is defined by three separate sections: the name itself, the data (attributes), and the behaviors (methods). For example the Employee class diagram’s attribute section contains `SocialSecurityNumber`, `Gender`, and `dateOfBirth`, whereas the method section contains the methods that operate on these attributes.

From this we can basically say that classes are templates from which objects are made.

When an object is created, we say that the objects are instantiated. Thus, if we create three employees, we are actually creating three totally distinct instances of an Employee class. Each object contains its own copy of the attributes and methods.

> **An Implementation Issue** - Be aware that there is not necessarily a physical copy of each method for each object. Rather, each object points to the same implementation. However, this is an issue left up to the compiler/operating platform. From a conceptual level, you can think of objects as being wholly independent and having their own attributes and methods.

## What exactly is a class?

A class is a blueprint for an object. When you instantiate an object, you use a class as the basis for how the object is built. It is difficult to describe a class without using the term object and vice versa. For example, a specific individual bike is an object. However, someone had to have created the blueprints (that is, the class) to build the bike. In OO concepts the class comes first, then the objects use the class as a blueprint.

The following sections describe some of the fundamental concepts of classes and how they interact.

### Creating objects

Classes can be thought of as the templates for objects. A class is used to create an object.

When you create objects, each object has its own attributes (data) and behaviors (functions or routines). A class defines the attributes and behaviors that all objects created with this class will possess. Classes are pieces of code. Objects instantiated(created) from classes can be distributed individually or as part of a library. Because objects are created from classes, it follows that classes must define the basic building blocks of objects (attributes, behavior, and messages). In short, you must design a class before you can create an object.

```java
// Here we define a class called ClassToObject. This is the main entry point of our java file, which contains our main method.
public class ClassToObject {

    // Here we define a static inner class called Employee. This class is also a template for creating objects.
    public static class Employee {

        // These are the attributes of the Employee class. Each object created from this class will have these attributes.
        private String name = "John Doe";
        private String socialSecurityNumber;
        private String dateOfBirth;
        private String phoneNumber;

        // This is a behavior of the Employee class. It allows us to set the value of the socialSecurityNumber attribute.
        public void setSocialSecurityNumber(String socialSecurityNumber) {
            this.socialSecurityNumber = socialSecurityNumber;
        }

        // This is another behavior of the Employee class. It allows us to get the value of the socialSecurityNumber attribute.
        public String getSocialSecurityNumber() {
            return socialSecurityNumber;
        }

        // This is another behavior of the Employee class. It allows us to get the value of the name attribute.
        public String getName() {
            return name;
        }

    }

    // This is the main method where the program starts. Here we create an object of the Employee class.
    public static void main(String[] args) {

        // Here we create an object of the Employee class. This object has its own attributes and behaviors as defined by the Employee class.
        Employee employee = new Employee();

        // Here we use the getName behavior of the employee object to get the value of the name attribute and print it.
        System.err.println(employee.getName());

    }

}
```

The following is also an example of a `Person` class, that will be a blueprint for a `Person` object.:

```java
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

}
```

### Attributes

The data of a class is represented by `attributes`. Each class must define the attributes that will store the state of each object instantiated from that class. In the `Person` class example, the `Person` class defines attributes for `name` and `address`.

> **Access Designations** - When a data type or method is defined as *public*, other objects can directly access it. When a data type or method is defined as *private*, only that specific object can access it. Another access modifier, *protected*, allows access by related objects.

### Methods

Methods implement the required behavior of a class. Every object instantiated from this class includes methods as defined by the class. Methods may implement behaviors that are called from other objects (messages) or provide the fundamental, internal behavior of the class. **Internal behaviors are private methods** that are not accessible by other objects. Here is an example of a private method:

```java
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("John Doe");
        person.printName();
    }
```

In the Person class, the behaviors are `getName()`, `setName()`, `getAddress()`, and `setAddress()`. These methods allow other objects to inspect and change the values of the object’s attributes. This is a common technique in OO systems. In all cases, access to attributes within an object should be controlled by the object itself—no other object should directly change an attribute of another.

### Messages

Messages are the communication mechanism between objects. For example, when Object A invokes a method of Object B, Object A is sending a message to Object B. Object B’s response is defined by its return value. Only the public methods, not the private methods, of an object can be invoked by another object. The below code demonstrates this concept.

```java
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
```

In this example (assuming that a `Payroll` object is instantiated), the Payroll object is sending a message to a `Person` object, with the purpose of setting the name via `setName` and also retrieving the name via the `getName()` method.

## Encapsulation and data hiding

One of the primary advantages of using objects is that the object need not reveal all its attributes and behaviors. In good OO design, an object should reveal only the interfaces that other objects must have to interact with it. Details not pertinent to the use of the object should be hidden from all other objects—basically a “need to know” basis.

In the context of Object-Oriented (OO) design, an interface typically refers to the methods or functions that an object exposes to other objects for interaction. These methods define the ways in which other objects can interact with the given object. The attributes (or properties) of an object are usually kept private and are accessed or modified through these methods. This is a part of the encapsulation principle in OO design, which is all about hiding the internal details of how an object works and only exposing a public interface.

Encapsulation is defined by the fact that objects contain both the attributes and behaviors. Data hiding is a major part of encapsulation.

For example, an object that calculates the square of a number must provide an interface to obtain the result. However, the internal attributes and algorithms used to calculate the square need not be made available to the requesting object. Robust classes are designed with encapsulation in mind. Check out the example below:

```java
public class SquareOfNumber {

    private int number;
    

    SquareOfNumber(int number) {
        this.number = number;
    }

    public int calculateSquare() {
        int result;
        result = number * number;
        return result;
    }

}

// Inside a Main.java file where this will be called
    public static void main(String[] args) {
        SquareOfNumber squareOfNumber = new SquareOfNumber(7);
        System.err.println("The square of 7 is " + squareOfNumber.calculateSquare());
    }
```

### Interfaces

Interface defines the fundamental means of communication between objects. How does interfaces work?

1. **Each class design specifies the interfaces for the proper instantiation and operation of objects.** This means that when you design a class, you define the methods (interfaces) that can be used to create (instantiate) and manipulate (operate) objects of that class.
2. **Any behavior that the object provides must be invoked by a message sent using one of the provided interfaces.** This means that any action that an object can perform is done through one of its methods. In OOP, we often say that we "send a message" to an object when we call one of its methods.
3. **The interface should completely describe how users of the class interact with the class.** This means that the methods of a class should provide all the necessary functionality for someone using the class. If the class is well-designed, a user should be able to do everything they need to do just by calling the class's methods.
4. **In most OO languages, the methods that are part of the interface are designated as public.** This Fmeans that the methods which are intended for users of the class to call are usually marked as `public`. In Java and many other OOP languages, `public` methods are accessible from outside the class, while `private` methods are only accessible from within the class.

> **Private Data:** For data hiding to work properly, all attributes should be declared as private. Thus, attributes are never part of the interface. Only the public methods are part of the class interface. Declaring an attribute as public breaks the concept of data hiding.

Thus if a user or object needs access to an attribute, a method is created to return the value of the attribute (a getter). If a user then wants to obtain the value of an attribute, a method is called on the instantiated object to return its value. In this way, the object that contains the attribute controls access to it. This is of vital importance, especially in security, testing, and maintenance.If you control the access to the attribute, when a problem arises, you do not have to worry about tracking down every piece of code that might have changed the attribute—it can be changed in only one place (the setter).

> **The keyword `interface` vs interface of a class:** In languages like Java, an `interface` is a type that contains no implementation, but only declarations of methods (and possibly constants). Classes can implement these interfaces, which means they provide the implementation for all the methods declared in the interface. But in this context  the “interface” of a class refers to the methods that the class exposes to the outside world, i.e., how other classes and objects interact with it. This includes all the public methods and properties. This is sometimes also referred to as the class’s “public interface”.

### Implementations

Only the public attributes and methods are considered the interface. The user should not see any part of the internal implementation, interacting with an object solely through class interfaces. Thus, anything defined as private is inaccessible to the user and considered part of the class’s internal implementation.

For example the `Employee` class below, shows that only the attributes are hidden. In many cases, there will be methods that also should be hidden and thus not part of the interface.

```Java
public class Employee {

    private String name;
    private String socialSecurityNumber;
    private String dateOfBirth;
    private String phoneNumber;

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

}
```

Continuing the example of the square root from the previous section, the user does not care how the square root is calculated—as long as it is the correct answer. Thus, the implementation can change, and it will not affect the user’s code. For example, the company that produces the calculator can change the algorithm (perhaps because it is more efficient) without affecting the result.

Let's use a real-world example to explain the concept of Implementations and Interfaces:

> Imagine you’re at a restaurant. The menu you’re given is like an interface. It lists all the dishes (methods) that the restaurant (class) can prepare for you. You don’t need to know how each dish is prepared (implementation), you just need to know what dishes (methods) you can order. Now, let’s say you order a pasta dish. The waiter takes your order and brings it to the kitchen. The chef (implementation) prepares the pasta according to the recipe (method logic). The waiter then brings the prepared dish (method result) back to you. In this scenario, you (the user of the class) don’t need to know how the kitchen works or how the chef (implementation) prepares the dish (method). You just need to know what you can order (methods in the interface) from the menu (interface). The restaurant can change chefs (implementations), and as long as they still follow the recipes (methods), you’ll get the dish you expect. This is the power of interfaces: they allow you to use a class without needing to understand its internal workings, and they allow the class to change its internal workings without affecting its users.

Now let's see how we can implement this in the real world using the `Square` class

```Java
public class SquareOfNumber {
    // private attribute
    private int squareValue;

    // public interface
    public int getSquare(int value) {
        squareValue = calculateSquare(value);
        return squareValue;
    }

    // private implementation
    private int calculateSquare(int value) {
        return value * value;
    }
}
```

Note that the only part of the class that the user has access to is the public method `getSquare`, which is the interface. The implementation of the square algorithm is in the method `calculateSquare`, which is private. Also notice that the attribute `SquareValue` is private because users do not need to know that this attribute exists. Therefore, we have hidden the part of the implementation: The object reveals only the interfaces the user needs to interact with it, and details that are not pertinent to the use of the object are hidden from other objects. If the implementation were to change—suppose you wanted to use the language’s built-in square function—you would not need to change the interface, just the implementation.

Here the code uses the Java library method Math.pow, which performs the same function, but note that the interface is still `calculateSquare`.

```java
    // private implementation changed without affecting users of the object
    private int calculateSquare(int value) {
        return (int) Math.pow(value, 2);
    }
```

The user would get the same functionality using the same interface, but the implementation would have changed.

## Inheritance

Inheritance enables a class to inherit the attributes and methods of another class. This provides the ability to create new classes by abstracting out or getting common attributes and behaviors(methods) from another class.

One of the major design issues in OO programming is to factor out commonality of the various classes. For example, suppose you have a Dog class and a Cat class, and each will have an attribute for eye color. In a procedural model, the code for Dog and Cat would each contain this attribute. In an OO design, the color attribute could be moved up to a class called Mammal—along with any other common attributes and methods. In this case, both Dog and Cat inherit from the Mammal class, as shown in the below figure.

![Dog and cat inheriting from the mammal class](/uml/chapter_one/cat-and-dog-inheriting-mammal.png)

The Dog and Cat classes both inherit from Mammal. This means that a Dog class has the following attributes:

- `eyeColor // inherited from Mammal`
- `barkFrequency // defined only for Dogs`

In the same vein, the Dog object has the following methods:

- `getEyeColor // inherited from Mammal`
- `bark // defined only for Dogs`

When the Dog or the Cat object is instantiated, it contains everything in its own class, as well as everything from the parent class. Thus, Dog has all the properties of its class definition, as well as the properties inherited from the Mammal class.

So in code, this is how it will be:

First create your Mammal class. thus the parent class.

```java
public class Mammal {

    private int eyeColor;

    public int getEyeColor() {
        return eyeColor;
    }

}
```

Secondly crete your Dog and Cat class which will inherit the attributes and behaviors(methods) from the Mammal class using the `extend` keyword.

```Java
public class Dog extends Mammal {
    private int barkFrequency = 3;

    public void bark() {
        // Implementation of bark method
        for (int i = 0; i < barkFrequency; i++) {
            System.err.println("Woof");
        }
    }
}
```

Thirdly create your Cat class that inherit from the Mammal class:

```Java
public class Cat extends Mammal {
    private int meowFrequency = 3;

    public void meow() {
        // Implementation of meow method
        for (int i = 0; i < meowFrequency; i++) {
            System.err.println("Meow");
        }
    }
}
```

### Superclasses and subclasses

The superclass, or parent class (sometimes called base class), contains all the attributes and behaviors that are common to classes that inherit from it. For example, in the case of the Mammal class, all mammals have similar attributes, such as `eyeColor` and `hairColor`, as well as behaviors, such as `generateInternalHeat` and `growHair`. All mammals have these attributes and behaviors, so it is not necessary to duplicate them down the inheritance tree for each type of mammal. Duplication requires a lot more work, and perhaps more worrisome, it can introduce errors and inconsistencies.

The subclass, or child class (sometimes called derived class) is an extension of the superclass. Thus, the Dog and Cat classes inherit all those common attributes and behaviors from the Mammal class. The Mammal class is considered the superclass of the Dog and the Cat subclasses, or child classes.

Inheritance provides a rich set of design advantages. When you’re designing a Cat class,
the Mammal class provides much of the functionality needed. By inheriting from
the Mammal object, Cat already has all the attributes and behaviors that make it a true mammal. To make it more specifically a cat type of mammal, the Cat class must include any attributes or behaviors that pertain solely to a cat.

A superclass doesn’t have any inherent knowledge that it’s being used as a superclass. It’s just a class that happens to be extended by another class. The subclass is the one that knows about the superclass because it uses the extends keyword to inherit the properties and methods of the superclass.

## Abstraction
