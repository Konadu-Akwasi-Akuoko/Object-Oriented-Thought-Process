# Class Design Guidelines

## Modeling real wold systems

One of the primary goals of object-oriented (OO) programming is to model real-world systems in ways similar to the ways in which people actually think. Designing classes is the object oriented way to create these models. Rather than using a structured, or top-down, approach, where data and behavior are logically separate entities, the OO approach encapsulates the data and behavior into objects that interact with each other. We no longer think of a problem as a sequence of events or routines operating on separate data files. The elegance of this mindset is that classes literally model real-world objects and how these objects interact with other real world objects.

These interactions occur in a way similar to the interactions between real-world objects, such as people. Thus, when creating classes, you should design them in a way that represents the true behavior of the object. Let’s use the cabbie example from previous chapters. The `Cab` class and the `Cabbie` class model a real-world entity. The `Cab` and the `Cabbie` objects encapsulate their data and behavior, and they interact through each other’s public interfaces.

This is only partially true now. Currently, much development is done with anemic domain models, a.k.a. data transfer objects (DTOs) and view models that have just enough data to populate a view or just the right amount of data that is needed by a consumer. Much more focus has been placed on behaviors and operating on the data, and that is handled via interfaces. Encapsulating the behaviors into single-responsibility interfaces and coding to the interfaces keeps code flexible and modular and far easier to maintain.

## Identifying the public interface

It should be clear by now that perhaps the most important issue when designing a class is to keep the public interface to a minimum. The entire purpose of building a class is to provide something useful and concise. In their book Object-Oriented Design in Java, Gilbert and McCarty state that “the interface of a well-designed object describes the services that the client wants accomplished.” If a class does not provide a useful service to a user, it should not have been built in the first place.

### The minimum public interface

Providing the minimum public interface makes the class as concise as possible. The goal is to provide the user with the exact interface to do the job right. If the public interface is incomplete (that is, there is missing behavior), the user will not be able to do the complete job. If the public interface is not properly restricted (that is, the user has access to behavior that is unnecessary or even dangerous), problems can result in the need for debugging, and even trouble with system integrity and security can surface.

> **Extending the Interface:** Even if the public interface of a class is insufficient for a certain application, object technology easily allows the capability to extend and adapt this interface. In short, if properly designed, a new class can utilize an existing class and create a new class with an extended interface.

To illustrate, consider the cabbie example again. If other objects in the system need to get the name of a cabbie, the `Cabbie` class must provide a public interface to return its name; this is the `getName()` method. Thus, if a `Supervisor` object needs a name from a `Cabbie` object, it must invoke the `getName()` method from the `Cabbie` object. In effect, the supervisor is asking the cabbie for its name.

Users of your code need to know nothing about its internal workings. All they need to know is how to instantiate and use the object. In short, provide users a way to get there but hide the details.

### Hiding the implementation


