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

So basically, the interface of a class is the set of methods that the class presents publicly to the user. The interface that a class implements is a contract that the class agrees to fulfill. This contract is defined by the methods that the class must implement. **So in this chapter we are talking about the interface of a class.**

### An interface/implementation example

Let’s create a simple (if not very functional) database reader class. We’ll write some Java code that will retrieve records from the database. As we’ve discussed, knowing your end users is always the most important issue when doing any kind of design. You should do some analysis of the situation and conduct interviews with end users, and then list the requirements for the project. The following are some requirements we might want to use for the database reader:

- We must be able to open a connection to the database.
- We must be able to close the connection to the database.
- We must be able to position the cursor on the first record in the database.
- We must be able to position the cursor on the last record in the database.
- We must be able to find the number of records in the database.
- We must be able to determine whether there are more records in the database (that is, if we are at the end).
- We must be able to position the cursor at a specific record by supplying the key.
- We must be able to retrieve a record by supplying a key.
- We must be able to get the next record, based on the position of the cursor.

With these requirements in mind, we can make an initial attempt to design the database reader class by creating possible interfaces for these end users.

In this case, the database reader class is intended for programmers who require use of a
database. Thus, the interface is essentially the application-programming interface (API) that the programmer will use. These methods are, in effect, wrappers that enclose the functionality provided by the database system. Why would we do this? We explore this question in much greater detail later in the chapter; the short answer is that we might need to customize some database functionality. For example, we might need to process the objects so that we can write them to a relational database. Writing this middleware is not trivial as far as design and coding go, but it is a real-life example of wrapping functionality. More important, we may want to change the database engine itself without having to change the code.

![A UML diagram for the database reader](/uml/chapter_two/DatabaseReader.png)

Note that the methods in this class are all public (remember that there are plus signs next to the names of methods that are public interfaces). Also note that only the interface is represented; the implementation is not shown. Take a minute to determine whether this class diagram generally satisfies the requirements outlined earlier for the project. If you find out later that the diagram does not meet all the requirements, that’s okay; remember that OO design is an iterative process, so you do not have to get it exactly right the first time.

> As always do not confuse a class interface with the keyword interface which is a contract between a class and implements it in languages like Java, .Net, and TypeScript. Over here we are talking about the interface of a class, thus public methods and properties the class makes available for other objects to interact with it.

For each of the requirements we listed, we need a corresponding method that provides the functionality we want. Now you need to ask a few questions:

- To effectively use this class, do you, as a programmer, need to know anything else about it?
- Do you need to know how the internal database code opens the database?
- Do you need to know how the internal database code physically positions itself over a specific record?
- Do you need to know how the internal database code determines whether any more records are left?

On all counts the answer is a resounding no! You don’t need to know any of this information. All you care about is that you get the proper return values and that the operations are performed correctly. In fact, the application programmer will most likely be at least one more abstract level away from the implementation. The application will use your classes to open the database, which in turn will invoke the proper database API.

> **Minimal Interface:** Although perhaps extreme, one way to determine the minimalist interface is to initially provide the user no public interfaces. Of course, the class will be useless; however, this forces the user to come back to you and say, “Hey, I need this functionality.” Then you can negotiate. Thus, you add interfaces only when it is requested. Never assume that the user needs something. Thus the principle of `least privilege` as we will say in security.

Creating wrappers might seem like overkill, but there are many advantages to writing them. To illustrate, there are many middleware products on the market today. Consider the problem of mapping objects to a relational database. OO databases have never caught on; however, theoretically they may be perfect for OO applications. However, one small problem exists: Most companies have years of data in legacy relational database systems. How can a company embrace OO technologies and stay on the cutting edge while retaining its data in a relational database?

First, you can convert all your legacy, relational data to a brand-new OO database. However, anyone who has suffered the acute (and chronic) pain of any data conversion knows that this is to be avoided at all costs. Although these conversions can take large amounts of time and effort, all too often they never work properly.

Second, you can use a middleware product (drizzle orm) to seamlessly map the objects in your application code to a relational model. This is a much better solution since relational databases are so prevalent. Some might argue that OO databases are much more efficient for object persistence than relational databases. In fact, many development systems seamlessly provide this service.

> **Object Persistence:** Object persistence refers to the concept of saving the state of an object so that it can be restored and used at a later time. An object that does not persist basically dies when it goes out of scope. For example, the state of an object can be saved in a database.

However, in the current business environment, relational-to-object mapping is a great solution. Many companies have integrated these technologies. It is common for a company to have a website front-end interface with data on a mainframe.

If you create a totally OO system, an OO database might be a viable (and better performing) option; however, OO databases have not experienced anywhere near the growth that OO languages have.

Let’s return to the database example. The [UML diagram](/uml/chapter_two/DatabaseReader.png) shows the public interface to the class, and nothing else. When this class is complete, it will probably contain more methods, and it will certainly contain attributes. However, as a programmer using this class, you do not need to know anything about these private methods and attributes. You certainly don’t need to know what the code looks like within the public methods. You simply need to know how to interact with the interfaces.

What would the code for this public interface look like? Let’s look at the `open()` method:

```java
    public void open(String name) {
        // Some application-specific processing

        // call the Oracle API to open the database

        // Some more application-specific processing
    }
```

In this case, you, wearing your programmer’s hat, realize that the open method requires String as a parameter. Name, which represents a database file, is passed in, but it’s not important to explain how Name is mapped to a specific database for this example. That’s all we need to know. Now comes the fun stuff—what really makes interfaces so great!

Just to annoy our users, let’s change the database implementation. Last night we translated all the data from an Oracle database to an SQLAnywhere database (we endured the acute and chronic pain). It took us hours—but we did it.

```java
    public void open(String name) {
        // Some application-specific processing

        // call the SQLAnywhere API to open the database

        // Some more application-specific processing
    }
```

To our great chagrin, this morning not one user complained. This is because even though the implementation changed, the interface did not! As far as the user is concerned, the calls are still the same. The code change for the implementation might have required quite a bit of work (and the module with the one-line code change would have to be rebuilt), but not one line of application code that uses this DataBaseReader class needed to change.

By separating the user interface from the implementation, we can save a lot of headaches down the road. In the [UML diagram](/uml/chapter_two/DatabaseReader.png), the database implementations are transparent to the end users, who see only the interface.

## Using abstract thinking when designing interfaces

One of the main advantages of OO programming is that classes can be reused. In general, reusable classes tend to have interfaces that are more abstract than concrete. Concrete interfaces tend to be very specific, whereas abstract interfaces are more general. However, simply stating that a highly abstract interface is more useful than a highly concrete interface, although often true, is not always the case.

It is possible to write a very useful, concrete class that is not at all reusable. This happens all the time, and nothing is wrong with it in some situations. However, we are now in the design business and want to take advantage of what OO offers us. So our goal is to design abstract, highly reusable classes—and to do this we will design highly abstract user interfaces. To illustrate the difference between an abstract and a concrete interface, let’s create a taxi object. It is much more useful to have an interface such as “drive me to the airport” than to have separate interfaces such as “turn right,” “turn left,” “start,” “stop,” and so on, because all the user wants to do is get to the airport.

When you emerge from your hotel, throw your bags into the back seat of the taxi, and get in, the cabbie will turn to you and ask, “Where do you want to go?” You reply, “Please take me to the airport.” You might not even know how to get to the airport yourself, and even if you did, you wouldn’t want to have to tell the cabbie when to turn and which direction to turn. You just want to get to the airport. This is a highly abstract interface. The cabbie knows how to get to the airport, and you don’t need to know how to get there. You just need to know how to ask to get there.

The not-so abstract interface would be to tell the cabbie to turn right, turn left, and so on. This is not very useful, because it is not really reusable. You just want to get there to the airport.

Now, where does the connection between abstract and reuse come in? Ask yourself which of these two scenarios is more reusable, the abstract or the not-so-abstract? To put it more simply, which phrase is more reusable: “Take me to the airport,” or “Turn right, then right, then left, then left, then left”? Obviously, the first phrase is more reusable. You can use it in any city, whenever you get into a taxi and want to go to the airport. The second phrase will work only in a specific case. Thus, the abstract interface “Take me to the airport” is generally the way to go for a good, reusable OO design whose implementation would be different in Chicago, New York, or Cleveland.

## Providing the absolute minimal user interface possible

When designing a class, the general rule is to always provide the user with as little knowledge of the inner workings of the class as possible. To accomplish this, follow these simple rules:

- Give the users only what they absolutely need. In effect, this means the class has as few interfaces as possible. When you start designing a class, start with a minimal interface. The design of a class is iterative, so you will soon discover that the minimal set of interfaces might not suffice. This is fine.
- It is better to have to add interfaces because users really need it than to give the users more interfaces than they need. At times it is highly problematic for the user to have access to certain interfaces. For example, you don’t want an interface that provides salary information to all users—only the ones who need to know.
- For the moment, let’s use a hardware example to illustrate our software example. Imagine handing a user a PC box without a monitor or a keyboard. Obviously, the PC would be of little use. You have just provided the user with the minimal set of interfaces to the PC. However, this minimal set is insufficient, and it immediately becomes necessary to add interfaces.
- Public interfaces define what the users can access. If you initially hide the entire class from the user by making the interfaces private, when programmers start using the class, you will be forced to make certain methods/interfaces public—these methods thus become the public interface.
- It is vital to design classes from a user’s perspective and not from an information systems viewpoint. Too often designers of classes design the class to make it fit into a specific technological model. Even if the designer takes a user’s perspective, it is still probably a technician user’s perspective, and the class is designed with an eye on getting it to work from a technology standpoint and not from ease of use for the user.
- Make sure when you are designing a class that you go over the requirements and the design with the people who will actually use it—not just developers (this includes all levels of testing). The class will most likely evolve and need to be updated when a prototype of the system is built.

### Determining the users

Let’s look again at the taxi example. We have already decided that the users are the ones who will actually use the system. This said, the obvious question is, who are the users?

The first impulse is to say the customers. This is only about half right. Although the customers are certainly users, the taxi driver(cabbie) must be able to successfully provide the service to the customers. In other words, providing an interface that would, no doubt, please the customer, such as “Take me to the airport for free,” is not going to go over well with the taxi driver. Thus, in reality, to build a realistic and usable interface, both the customer and the taxi driver must be considered users. So basically the taxi driver and the customer will be objects that use the taxi object. And all objects are users of the taxi object.

### Object behavior

Identifying the users is only a part of the exercise. After the users are identified, you must determine the behaviors of the objects. From the viewpoint of all the users, begin identifying the purpose of each object and what it must do to perform properly. Note that many of the initial choices will not survive the final cut of the public interface. These choices are identified by gathering requirements using various methods such as UML Use Cases.

### Environmental constraints

In their book Object-Oriented Design in Java, Gilbert and McCarty point out that the environment often imposes limitations on what an object can do. In fact, environmental constraints are almost always a factor. Computer hardware might limit software functionality. For example, a system might not be connected to a network, or a company might use a specific type of printer. In the taxi example, the cab cannot drive on a road if a bridge is out, even if it provides a quicker way to the airport.

### Identifying the public interfaces

With all the information gathered about the users, the object behaviors, and the environment, you need to determine the public interfaces for each user object from the perspective of other objects. So think about how you would use the taxi object from the customer perspective:

- Get into the taxi.
- Tell the cabbie where you want to go.
- Pay the cabbie.
- Give the cabbie a tip.
- Get out of the taxi.

What do you need to do to use the taxi object as a customer(from the taxi object perspective)?

- Have a place to go.
- Hail a taxi.
- Pay the money.

Initially, you think about how the object is used and not how it is built. You might discover that the object needs more interfaces, such as “Put luggage in the trunk” or “Enter into a mindless conversation with the cabbie.”

![A UML diagram for the cabbie object](/uml/chapter_two/Taxi.png)

As is always the case, nailing down the final interface is an iterative process. For each interface, you must determine whether the interface contributes to the operation of the object. If it does not, perhaps it is not necessary. Many OO texts recommend that each interface model only one behavior. This returns us to the question of how abstract we want to get with the design. If we have an interface called `enterTaxi()`, we certainly do not want `enterTaxi()` to have logic in it to pay the cabbie. If we do this, not only is the design somewhat illogical, but there is virtually no way that a user of the class can tell what has to be done to pay the cabbie.

### Identifying the implementation

After the public interfaces are chosen, you need to identify the implementation. After the class is designed and all the methods required to operate the class properly are in place, the specifics of how to get the class to work are considered.

Technically, anything that is not a public interface can be considered the implementation. This means that the user will never see any of the methods that are considered part of the implementation, including the method’s signature (which includes the name of the method and the parameter list), as well as the actual code inside the method.

It is possible to have a private method that is used internally by the class. Any private method is considered part of the implementation given that the user will never see it and thus will not have access to it. For example, a class may have a `changePassword()` method; however, the same class may have a private method that encrypts the password. This method would be hidden from the user and called only from inside the `changePassword()` method.

The implementation is totally hidden from the user. The code within public methods is a part of the implementation because the user cannot see it. (The user should see only the calling structure of an interface—not the code inside it.)

This means that, theoretically, anything that is considered the implementation might change without affecting how the user interfaces with the class. This assumes, of course, that the implementation is providing the answers the user expects.

Whereas the interface represents how the user sees the object, the implementation is really the nuts and bolts of the object. The implementation contains the code that represents that state of an object.
