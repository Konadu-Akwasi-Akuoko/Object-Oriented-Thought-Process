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

The need for hiding the implementation has already been covered in great detail. Whereas identifying the public interface is a design issue that revolves around the users of the class, the implementation should not involve the users at all. The implementation must provide the services that the user needs, but how these services are actually performed should not be made apparent to the user. A class is most useful if the implementation can change without affecting the users. Basically, a change to the implementation should not necessitate a change in the user’s application code. Again, the best way to enable change of behaviors is via the use of interfaces and composition.

In the cabbie example, the Cabbie class might contain behavior pertaining to how, or where, he eats lunch. However, the cabbie’s supervisor does not need to know what the cabbie has for lunch. Thus, this behavior is part of the implementation of the Cabbie object and should not be available to other objects in this system. Gilbert and McCarty state that the prime directive of encapsulation is that “all fields shall be private.” In this way, none of the fields in a class are accessible from other objects. The only way to access the fields is through the public interface of the class.

## Designing robust constructors (and perhaps destructors)

When designing a class, one of the most important design issues involves how the class will be constructed.

First and foremost, a constructor should put an object into an initial, safe state. This includes issues such as attribute initialization and memory management. You also need to make sure the object is constructed properly in the default condition. It is normally a good idea to provide a constructor to handle this default situation.

In languages that include destructors, it is of vital importance that the destructors include proper clean-up functions. In most cases, this clean-up pertains to releasing system memory that the object acquired at some point. Java and .NET reclaim memory automatically via a garbage collection mechanism. In languages such as C++, the developer must include code in the destructor to properly free up the memory that the object acquired during its existence. If this function is ignored, a memory leak will result.

### Constructor injection

Constructor injection is a dependency injection (DI) technique where an object's dependencies are provided to it at the time of its creation through its constructor arguments. Here service classes are injected on object creation (via a constructor) instead of within the class (using the new keyword). For example, the cabbie can get his license object, his radio information object (frequency, call sign, etc.), and the key that starts his cab passes into the object via a constructor. Here is an example of dependency injection using constructor injection:

```java
public class Logger {

  private final Writer writer;

  public Logger(Writer writer) {
    this.writer = writer;
  }

  public void log(String message) throws IOException {
    writer.write(message + "\n");
  }
}

public class MyApp {

  public static void main(String[] args) throws IOException {
    Writer fileWriter = new FileWriter("log.txt");
    Logger logger = new Logger(fileWriter);
    logger.log("Hello, world!");
    fileWriter.close();
  }
}
```

And here is an example in Angular:

```typescript
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MessageService {
  constructor() { }

  public getMessage(): string {
    return "Hello from MessageService!";
  }
}

@Component({
  selector: 'app-my-component',
  templateUrl: './my-component.component.html',
  styleUrls: ['./my-component.component.css']
})
export class MyComponent {

  message: string;

  constructor(private messageService: MessageService) {
    this.message = this.messageService.getMessage();
  }
}
```

### Memory leaks

When an object fails to properly release the memory that it acquired during an object's life cycle, the memory is lost to the entire operating system as long as the application that created the object is executing. For example, suppose multiple objects of the same class are created and then destroyed, perhaps in some sort of loop. If these objects fail to release their memory when they go out of scope, this memory leak slowly depletes the available pool of system memory. At some point, it is possible that enough memory will be consumed that the system will have no available memory left to allocate. This means that any application executing in the system would be unable to acquire any memory. This could put the application in an unsafe state and even lock up the system.

## Designing error handling into a class

As with the design of constructors, designing how a class handles errors is of vital importance.

It is virtually certain that every system will encounter unforeseen problems. Thus, it is not a good idea to ignore potential errors. The developer of a good class (or any code, for that matter) anticipates potential errors and includes code to handle these conditions when they are encountered. The general rule is that the application should never crash. When an error is encountered, the system should either fix itself and continue, or at minimum, exit gracefully without losing any data that’s important to the user.

### Documenting the class and using comments

want to take the time to do it. However, a good design is practically impossible without good documentation practices. At the class level, the scope might be small enough that a developer can get away with shoddy documentation. However, when the class gets passed to someone else to extend and/or maintain, or it becomes part of a larger system (which is what should happen), a lack of proper documentation and comments can undermine the entire system.

Many people have said all this before. One of the most crucial aspects of a good design, whether it’s a design for a class or something else, is to carefully document the process. Implementations such as Java, TypeScript and .NET provide special comment syntax to facilitate the documentation process.

> **Too Much Documentation:** Be aware that over-commenting can be a problem as well. Too much documentation and/or commenting can become background noise and may actually defeat the purpose of the documentation. Just like in good class design, make the documentation and comments straightforward and to the point. Well written code is, in itself, the best documentation.

### Building objects with intent to cooperate

We can safely say that almost no class lives in isolation. In most cases, there is little reason to build a class if it is not going to interact with other classes, unless the class will be used only once. This is a fact in the life of a class. A class will service other classes; it will request the services of other classes, or both.

In the cabbie example, the cabbie and the supervisor are not standalone entities; they interact with each other at various levels. When designing a class, make sure you are aware of how other objects will interact with it.

## Designing with reuse in mind

Objects can be reused in different systems, and code should be written with reuse in mind. For example, when a Cabbie class is developed and tested, it can be used anywhere you need a cabbie. To make a class usable in various systems, the class must be designed with reuse in mind. This is where much of the thought is required in the design process. Attempting to predict all the possible scenarios in which a Cabbie object must operate is not a trivial task—in fact, it is virtually impossible.
