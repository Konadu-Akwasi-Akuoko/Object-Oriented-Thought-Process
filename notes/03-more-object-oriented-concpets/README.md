# More Object Oriented Concepts

## Constructors

In some OO languages, such as Java and C#, constructors are methods that share the same name as the class. Visual Basic .NET uses the designation New and Swift uses the init keyword. Typescript also uses the keyword constructor inside a class to denote a constructor. Let’s take a look at some Java code that implements a constructor.

```java
public class Cabbie {
    public Cabbie() {
        System.err.println("Hello, world!");
    }
}
```

The compiler will recognize that the method name is identical to the class name and consider the method a constructor.

> **Caution:** Note that in this Java code (as with C# and C++), a constructor does not have a return value. If you provide a return value, the compiler will not treat the method as a constructor. Whiles typescript let's you return a value in it's constructor, it is something [that should be avoided](https://stackoverflow.com/questions/70926908/make-constructor-return-subclass#:~:text=TypeScript%20does%20let%20you%20return,it%2C%20yes%20this%20is%20possible.&text=So%20that%20works%20exactly%20was%20you%20want.).

For example, if you include the following code in the class, the compiler will not consider this a constructor because it has a return value—in this case an integer.

```java
public class Cabbie {
    public int Cabbie() {
        System.err.println("Hello, world!");
        return 12;
    }
}
```

This syntax requirement can cause problems because this code will compile but will not behave as expected.

### When is a constructor called?

When a new object is created, one of the first things that happens is that the constructor is called. Check out the following code:

```java
public class Main {

    public static void main(String[] args) {
        Cabbie cabbie = new Cabbie();
    }

}
```

The `new` keyword creates a new instance of the `Cabbie` class, thus allocating the required memory. Then the constructor itself is called, passing the arguments in the parameter list if any. The constructor provides the developer the opportunity to attend to the appropriate initialization. Thus, the code `new Cabbie()` will instantiate a Cabbie object and call the Cabbie method, which is the constructor.

### What's inside a constructor?

Perhaps the most important function of a constructor is to initialize the memory allocated when the new keyword is encountered. In short, code included inside a constructor should set the newly created object to its initial, stable, safe state.

For example, if you have a counter object with an attribute called `count`, you need to set `count` to zero in the constructor: `count = 0;`

> **Initializing Attributes:** In structured programming, a routine named housekeeping (or initialization) is often used for initialization purposes. Initializing attributes is a common function performed within a constructor. Regardless, don't rely on the system defaults.

### The default constructor

If you write a class and do not include a constructor, the class will still compile, and you can still use it. If the class provides no explicit constructor, a default constructor will be provided. It is important to understand that at least one constructor always exists, regardless of whether you write a constructor yourself. If you do not provide a constructor, the system will provide a default constructor for you.

Besides the creation of the object itself, the only action that a default constructor takes is to call the constructor of its superclass. In many cases, the superclass will be part of the language framework, like the Object class in Java. For example, if a constructor is not provided for the Cabbie class, the following default constructor is inserted:

```java
    public Cabbie() {
        super();
    }
```

If you were to decompile the bytecode produced by the compiler, you would see this code. The compiler actually inserts it.

In this case, if `Cabbie` does not explicitly inherit from another class, the `Object` class will be the parent class. Perhaps the default constructor might be sufficient in some cases; however, in most cases some sort of memory initialization should be performed. Regardless of the situation, it is good programming practice to always include at least one constructor in a class. If there are attributes in the class, it is always good practice to initialize them. Moreover, initializing variables is always a good practice when writing code, object-oriented or not, just to avoid null and undefined errors in your code later on.

> **Providing a Constructor:** The general rule is that you should always provide a constructor, even if you do not plan to do anything inside it. You can provide a constructor with nothing in it and then add to it later. Although there is technically nothing wrong with using the default constructor provided by the compiler, for documentation and maintenance purposes, it is always nice to know exactly what your code looks like.

It is not surprising that maintenance becomes an issue here. If you depend on the default constructor and then subsequent maintenance adds another constructor, the default constructor is no longer created. This may actually break code that was assuming the presence of a default constructor.

Always remember that the default constructor is added only if you don’t include any constructors. As soon as you include just one, the default constructor is not provided.

### Using multiple constructors

In many cases, an object can be constructed in more than one way. To accommodate this situation, you need to provide more than one constructor. For example, let’s consider the `Count` class presented here:

```java
public class Count {
    int count;

    public Count() {
        count = 0;
    }

}
```

On the one hand, we want to initialize the attribute `count` to zero: We can easily accomplish this by having a constructor initialize count to zero as follows:

```java
    public Count() {
        count = 0;
    }
```

On the other hand, we might want to pass an initialization parameter that allows count to be set to various numbers:

```java
    public Count(int number) {
        count = number;
    }
```

This is called overloading a method or method overloading (overloading pertains to all methods, not just constructors). Most OO languages provide functionality for overloading a method.

> In typescript method overloading works a different way, check [this stackoverflow post about method overloading](https://stackoverflow.com/questions/12688275/how-to-do-method-overloading-in-typescript/12689054#12689054). And also constructor overloading works different in typescript, check [this stackoverflow answer about constructor overloading](https://stackoverflow.com/questions/12702548/constructor-overload-in-typescript) for more information.

### Overloading methods

Overloading allows a programmer to use the same method name over and over, as long as the signature of the method is different each time. The signature consists of the method name and a parameter list

The signature of a method consists of the name of the method and the description (i.e., type, number, and position) of its *parameters*.

Thus, the following methods all have different signatures:

```java
public class GetCab {

    public void GetCab() {
    }

    // different parameter list
    public void GetCab(String cabbieName) {
    }

    // different parameter list
    public void GetCab(int numberOfPassengers) {
    }

}
```

> **Signatures:** Depending on the language, the signature may or may not include the return type. In Java and C#, the return type is not part of the signature. For example, the following methods would conflict even though the return types are different:

```java
public void getCab (String cabbieName);
public int getCab (String cabbieName);
```

By using different signatures, you can construct objects differently depending on the constructor used. This functionality is very helpful when you don’t always know ahead of time how much information you have available. For example, when creating a shopping cart, customers may already be logged in to their account (and you will have all of their information). On the other hand, a totally new customer may be placing items in the cart with no account information available at all. In each case the constructor would initialize differently.

### Using UML to model classes

Consider that we have two ways we can construct a database reader:

- Pass the name of the database and position the cursor at the beginning of the database.
- Pass the name of the database and the position within the database where we want the cursor to position itself.

![A database reader class UML diagram](/uml/chapter_03/DatabaseReader.png)

> **No Return Type:** Notice that in this class diagram the constructors do not have a return type. All other methods besides constructors must have return types.

Here is a code segment of the class that shows its constructors and the attributes that the constructors initialize:

```java
public class DatabaseReader {

    String dbName;
    int startPosition;

    // initialize just the name
    public DatabaseReader(String name) {
        dbName = name;
        startPosition = 0;
    }

    public DatabaseReader(String name, int pos) {
        dbName = name;
        startPosition = pos;
    }

}
```

Note how `startPosition` is initialized in both cases. If the constructor is not passed the information via the parameter list, it is initialized to a default value, such as `0`.

### How the superclass is constructed

When using inheritance, you must know how the parent class is constructed. Remember that when you use inheritance, you are inheriting everything about the parent. Thus, you must become intimately aware of all the parent’s data and behavior. The inheritance of an attribute is fairly obvious; however, how a constructor is inherited is not as obvious. After the `new` keyword is encountered and the object is allocated, the following steps occur:

1. Inside the constructor of the base class, the constructor of the class’s superclass is called. If there is no explicit call to the superclass constructor, the default is called automatically; however, you can see the code in the bytecodes.
2. Each class attribute of the object is initialized. These are the attributes that are part of the class definition (instance variables), not the attributes inside the constructor or any other method (local variables). In the DataBaseReader code presented earlier, the integer `startPosition` is an instance variable of the class.
3. The rest of the code in the constructor executes.

> **Note:**  If a constructor doesn't have an explicit call to `super(...)`, there's always an implicit call to `super()` (with no args).

### The design of constructors

As we have already seen, when designing a class, it is good practice to initialize all the attributes. In some languages, the compiler provides some sort of initialization. As always, don’t count on the compiler to initialize attributes! In Java, you cannot use an attribute until it is initialized. If the attribute is first set in the code, make sure that you initialize the attribute to some valid condition—for example, set an integer to zero.

Constructors are used to ensure that the application is in a stable state (I like to call it a “safe” state). For example, initializing an attribute to zero, when it is intended for use as a denominator in a division operation, might lead to an unstable application. You must take into consideration that a division by zero is an illegal operation. Initializing to zero is not always the best policy.

During the design, it is good practice to identify a stable state for all attributes and then initialize them to this stable state in the constructor.

## Error handling

It is extremely rare for a class to be written perfectly the first time. In most, if not all, situations, things will go wrong. Any developer who does not plan for problems is inviting disaster.

Assuming that your code has the capability to detect and trap an error condition, you can handle the error in several ways: In Chapter 11 of their book Java Primer Plus, Tyma, Torok, and Downing state that there are three basic solutions to handling problems that are detected in a program: fix it, ignore the problem by squelching it, or exit the runtime in some graceful manner.

In Chapter 4 of their book Object-Oriented Design in Java, Gilbert and McCarty expand on this theme by adding the choice of throwing an exception:

- Ignore the problem—not a good idea!
- Check for potential problems and abort the program when you find a problem.
- Check for potential problems, catch the mistake, and attempt to fix the problem.
- Throw an exception. (Often this is the preferred way to handle the situation.)

### Ignoring the problem

Simply ignoring a potential problem is a recipe for disaster. And if you are going to ignore the problem, why bother detecting it in the first place? It is obvious that you should not ignore any known problem. The primary directive for all applications is that the application should never crash. If you do not handle your errors, the application will eventually terminate ungracefully or continue in a mode that can be considered an unstable state—possibly with corrupted data. In the latter case, you might not even know you are getting incorrect results, and that can be much worse than a program crash, because it can even lead to death.

### Checking for problems and aborting the application

If you choose to check for potential problems and abort the application when a problem is detected, the application can display a message indicating that a problem exists. In this case the application gracefully exits, and the user is left staring at the computer screen, shaking her head and wondering what just happened. Although this is a far superior option to ignoring the problem, it is by no means optimal. However, this does allow the system to clean up things and put itself in a more stable state, such as closing files and forcing a system restart.

### Checking for problems and attempting to recover

Checking for potential problems, catching the mistake, and attempting to recover is a far superior solution than simply checking for problems and aborting. In this case, the problem is detected by the code, and the application attempts to fix itself. This works well in certain situations. For example, consider the following code:

```java
import java.util.Scanner;

public class ErrorHandling {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Type a number we can use to divide 100:");
        String denominator = scanner.nextLine();

        while (Double.parseDouble(denominator) == 0 || Double.parseDouble(denominator) > 100) {
            System.out.println("We want a number we can use to divide 100 and it must not be 0 or higher than 100:");
            denominator = scanner.nextLine();
        }

        double result = 100 / Double.parseDouble(denominator);

        System.out.println("The result of 100 divided by " + denominator + " is: " + result);

        scanner.close();
    }

}
```

It is obvious that if the `while` conditional statement is not included in the code, and a zero makes its way to the divide statement, you will get a system exception because you cannot divide by zero. By catching the exception and setting the variable `denominator` to 1, at least the system will not crash, but that is not what we are doing.

However, setting the `denominator` to 1 might not be a proper solution because the result would be incorrect. The better solution would be to prompt the user to reenter the proper input value, as we are doing.

> **A Mix of Error-Handling Techniques:** Despite the fact that this type of error handling is not necessarily object-oriented in nature, I believe that it has a valid place in OO design. Throwing an exception (discussed in the next section) can be expensive in terms of overhead. Thus, although exceptions may be a valid design choice, you will still want to consider other error-handling techniques (even tried-and-true structured techniques), depending on your design and performance needs.

Although the error checking techniques mentioned previously are preferable to doing nothing, they still have a few problems. It is not always easy to determine where a problem first appears. And it might take a while for the problem to be detected. However, it is important to design error handling into the class right from the start, and often the operating system itself can alert you to problems that it detects.

### Throwing exceptions

Most OO languages provide a feature called exceptions. In the most basic sense, exceptions are unexpected events that occur within a system. Exceptions provide a way to detect problems and then handle them. In Java, C#, C++, Swift, Typescript, and Visual Basic, exceptions are handled by the keywords `catch` and `throw`. This might sound like a baseball game, but the key concept here is that a specific block of code is written to handle a specific exception. This solves the problem of trying to figure out where the problem started and unwinding the code to the proper point. Here is the structure for a Java try/catch block:

```java
try {

} catch (Exception e) {
    // handle exception here
}
```

If an exception is thrown within the `try` block, the `catch` block will handle it. When an exception is thrown while the block is executing, the following occurs:

1. The execution of the try block is terminated.
2. The `catch` clauses are checked to determine whether an appropriate catch block for the offending exception was included. (There might be more than `one` catch clause
per `try` block. This is in java, it does not work that way in Typescript or Javascript)
3. If none of the catch clauses handles the offending exception, it is passed to the next higher-level try block. (If the exception is not caught in the code, the system ultimately catches it, and the results are unpredictable—that is, an application crash.)
4. If a catch clause is matched (the first match encountered), the statements in the `catch` clause are executed.
5. Execution then resumes with the statement following the try/catch block.

Suffice it to say that exceptions are an important advantage for OO programming languages. Here is an example of how an exception is caught in Java:

```java
import java.util.Scanner;

public class ErrorHandling {

    double count = 0;

    public static void main(String[] args) {
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
```

> **Exception Granularity:** You can catch exceptions at various levels of granularity. You can catch all exceptions or check for specific exceptions, such as arithmetic exceptions. If your code does not catch an exception, the Java runtime will—and it won't be happy about it!

In this example, the division by zero within the try block will cause an arithmetic exception. If the exception was generated (thrown) outside a try block, the program would most likely have been terminated (crashed). However, because the exception was thrown within a try block, the catch block is checked to see whether the specific exception (in this case, an arithmetic exception, we could have handled it with a general exception with `catch (Exception e)`, which will catch all exceptions) was planned for. Because the catch block contains a check for the arithmetic exception, the code within the catch block is executed, thus setting count to 1. After the catch block executes, the try/catch block is exited, and the message The exception is handled. appears on the Java console.

If you had not put `ArithmeticException` in the catch block, the program would likely have crashed. You can catch all exceptions by using `Exception`, check the following code:

```java
try {

} catch (Exception e) {
    // handle exception here
}
```

> **Bulletproof Code:** It's a good idea to use a combination of the methods described here to make your program as bulletproof to your user as possible.

## The importance of scope

Multiple objects can be instantiated from a single class. Each of these objects has a unique identity and state. This is an important point. Each object is constructed separately and is allocated its own separate memory. However, some attributes and methods may, if properly declared, be shared by all the objects instantiated from the same class, thus sharing the memory allocated for these class attributes and methods.

> A **Shared Method:** A constructor is a good example of a method that is shared by all instances of a class.


