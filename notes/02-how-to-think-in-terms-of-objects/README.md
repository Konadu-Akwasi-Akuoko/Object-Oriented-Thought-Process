# How To Think In Terms Of Objects

When moving to an OO language, you must first go through the investment of learning OO concepts and the corresponding thought process. If this paradigm shift does not take place, one of two things will happen: Either the project will not truly be OO in nature (for example, it will use C++ without using OO constructs) or the project will be a complete object-disoriented mess.

## Knowing the difference between the interface and the implementation

One of the keys to building a strong OO design is to understand the difference between the interface and the implementation. Thus, when designing a class, what the user needs to know and, perhaps of more importance, what the user does not need to know are of vital importance. The data hiding mechanism inherent with encapsulation is the means by which nonessential data is hidden from the user.

Consider a toaster, which is a common household appliance. This toaster needs to be plugged into an electrical outlet to function. This electrical outlet serves as an interface, a point of interaction or communication. All appliances, not just the toaster, gain access to the electricity they need to operate by connecting to this interface, the electrical outlet.

The toaster, in this scenario, doesn't need to understand the details of how the electricity it uses is produced. The production of electricity, whether it's from a coal plant or a nuclear plant, is irrelevant to the toaster. The toaster's primary concern is that the interface, the electrical outlet, provides the electricity it needs to function correctly and safely. The toaster is indifferent to the source of the electricity as long as the interface, the electrical outlet, works as specified.

This example is a metaphor for how interfaces work in computing. In software development, an interface is a common boundary or point of interaction between different software components. Just like the toaster doesn’t care about how electricity is produced, a software component doesn’t need to know the details of how an interface’s implementation works. All it needs to know is how to communicate with the interface. As long as the interface contract is adhered to, the software component can function correctly, regardless of how the interface’s functionality is achieved.

Properly constructed classes are designed in two parts—the interface and the implementation.

### The interface

The services presented to an end user constitute the interface. In the best case, only the services the end user needs are presented. Of course, which services the user needs might be a matter of opinion.

As a general rule, the interface to a class should contain only what the user needs to know. In the toaster example, the user needs to know only that the toaster must be plugged into the interface (which in this case is the electrical outlet) and how to operate the toaster itself.

> **Identifying the User:** Perhaps the most important consideration when designing a class is identifying the audience, or users, of the class.

### The implementation

The implementation details are hidden from the user. One goal regarding the implementation should be kept in mind: A change to the implementation should not require a change to the user’s code. This might seem a bit confusing, but this goal is at the heart of the design issue.

> **Good Interfaces:** If the interface is designed properly, a change to the implementation should not require a change to the user's code.

Remember that the interface includes the syntax to call a method and return a value. If this interface does not change, the user does not care whether the implementation is changed. As long as the programmer can use the same syntax and retrieve the same value, that’s all that matters.

We see this all the time when using a cell phone. To make a call, the interface is simple—we either dial a number or select an entry in the contact list. Yet, if the provider updates the software, it doesn’t change the way you make a call. The interface stays the same regardless of how the implementation changes.

Recall that in the toaster example, although the interface is always the electric outlet, the implementation could change from a coal power plant to a nuclear power plant without affecting the toaster. One very important caveat should be made here: The coal or nuclear plant must also conform to the interface specification. If the coal plant produces AC power but the nuclear plant produces DC power, a problem exists. The bottom line is that both the user and the implementation must conform to the interface specification.

#### Interface of a class vs an interface that a class implements

In the context of Object-Oriented Programming (OOP), the term "interface" can have two related but distinct meanings.

1. **Interface of a Class**: The interface of a class refers to the set of public methods and properties that the class exposes to other classes or objects in the system. This is the means by which other classes or objects interact with that class. In our example, the interface is likened to the electrical outlet for the toaster. The toaster, representing a user of the class, only needs to know about this outlet (the public methods and properties) to interact with the class. It doesn't need to know about the internal workings of the class, just like the toaster doesn't need to know how the electricity is produced.

2. **Interface that a Class Implements**: In many OOP languages like Java and C#, an "interface" is also a specific construct that defines a contract of methods (and sometimes properties) that a class must implement if it declares that it implements that interface. This is a way of ensuring that the class adheres to a certain standard or protocol, much like how both the coal and nuclear plant must conform to the interface specification of producing AC power in the analogy.

The key difference between these two is that the interface of a class is a broader concept that includes all the ways that other classes or objects can interact with the class, while an interface that a class implements is a specific contract that the class declares it will uphold. Both concepts are central to designing well-structured, modular code in OOP.

So basically, the interface of a class is the set of methods that the class presents publicly to the user. The interface that a class implements is a contract that the class agrees to fulfill. This contract is defined by the methods that the class must implement.

### An interface/implementation example
