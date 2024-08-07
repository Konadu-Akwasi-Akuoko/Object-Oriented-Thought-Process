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

For example, if you include the following code ****in the class, the compiler will not consider this a constructor because it has a return value—in this case an integer.

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

Methods represent the behaviors of an object; the state of the object is represented by attributes. There are three types of attributes:

- Local attributes
- Object attributes
- Class attributes

### Local attributes

Local attributes are owned by a specific method. Consider the following code:

```java
public class Number {

    public void method1() {
        int count;
    }

    public void method2() {

    }

}
```

The method `method1` contains a local variable called `count`. This integer is accessible only inside `method1`. The method `method2` has no idea that the integer `count` even exists. At this point, we introduce a very important concept: scope. Attributes (and methods) exist within a particular scope.

In this case, the integer count exists within the scope of `method1`. In Java, C#, C++, Typescript, and Swift, scope is delineated by curly braces ({}). In the Number class, there are several possible scopes—just start matching the curly braces.

The class itself has its own scope. Each instance of the class (that is, each object) has its own scope. Both `method1` and `method2` have their own scopes as well. Because count lives within `method1`’s curly braces, when `method1` is invoked, a copy of count is created. When `method1` terminates, the copy of count is removed.

For some more fun, look at this code:

```java
public class Number {

    public void method1() {
        int count;
    }

    public void method2() {
        int count;
    }

}
```

This example has two copies of an integer count in this class. Remember that `method1` and `method2` each has its own scope. Thus, the compiler can tell which copy of count to access simply by recognizing which method it is in. You can think of it in these terms:

```plaintext
<!-- Note this is what the compiler sees, and this won't work inside your code if you do this -->
method1.count;
method2.count;
```

As far as the compiler is concerned, the two attributes are easily differentiated, even though they have the same name. It is almost like two people having the same last name, but based on the context of their first names, you know that they are two separate individuals.

### Object attributes

In many design situations, an attribute must be shared by several methods within the same object. For example, three objects have been constructed from a single class. Consider the following code:

```java
public class Number {

    int count;

    public void method1() {
        count = 1;
    }

    public void method2() {
        count = 2;
    }

}
```

And creating the objects:

```java
public class Main {
    public static void main(String[] args) {
        Number number1 = new Number();
        Number number2 = new Number();
        Number number3 = new Number();
    }
}
```

Note here that the class attribute count is declared outside the scope of both `method1` and `method2`. However, it is within the scope of the class. Thus, count is available to both `method1` and `method2`. (Basically, all methods in the class have access to this attribute.) Notice that the code for both methods is setting count to a specific value. There is only one copy of count for the entire object, so both assignments operate on the same copy in memory. However, this copy of count is not shared between different objects. To illustrate this, we created three copies of the Number class:

```java
Number number1 = new Number();
Number number2 = new Number();
Number number3 = new Number();
```

Each of these objects—`number1`, `number2`, and `number3`—is constructed separately and is allocated its own resources. There are three separate instances of the integer count. When `number1` changes its attribute count, this in no way affects the copy of count in object `number2` or object `number3`. In this case, integer count is an object attribute.

You can play some interesting games with scope. Consider the following code:

```java
public class Number {

    int count;

    public void method1() {
        int count;
    }

    public void method2() {
        int count;
    }

}
```

In this case, three totally separate memory locations have the name of `count` for each object. The object owns one copy, and `method1()` and `method2()` each have their own copy. To access the object variable from within one of the methods, say `method1()`, you can use a pointer called this in the C-based languages:

```java
public void method1() {
    int count;
    this.count = 1;
}
```

The use of the `this` keyword directs the compiler to access the object variable `count` and not the local variables within the method bodies.

> **Note:** The keyword `this` is a reference to the current object.

### Class attributes

It is possible for two or more objects of the same class to share attributes, thus all objects will just use one attribute. In Java, C#, C++, Typescript, and Swift, you do this by making the attribute static:

```java
public class Number {

    static int count;

    public void method1() {
        int count;
        this.count = 1;
    }

    public void method2() {
        int count;
    }

}
```

By declaring `count` as `static`, this attribute is allocated a single piece of memory for all objects instantiated from the class. Thus, all objects of the class use the same memory location for `count`. Essentially, each class has a single copy, which is shared by all objects of that class. This is about as close to global data as we get in OO design. Also you can use the `static` keyword for creating a method and sharing it across all instantiated objects of a class:

```java
public class Number {

    static int count;

    public void method1() {
        int count;
        this.count = 1;
    }

    public static void method2() {
        int count;
    }

}
```

There are many valid uses for class attributes; however, you must be aware of potential synchronization problems. Let’s instantiate two `Count` objects:

```java
Count Count1 = new Count();
Count Count2 = new Count();
```

For the sake of argument, let’s say that the object `Count1` is going merrily about its way and is using count as a means of keeping track of the pixels on a computer screen. This is not a problem until the object `Count2` decides to use attribute `count` to keep track of sheep. The instant that `Count2` records its first sheep, the data that `Count1.count` was saving is lost. In practice, there might not be a lot of uses for static methods. Make sure you are confident in their use before incorporating them in designs.

> **Difference between static and abstract keywords:** Static is initialized once, for example our attribute or method can be initialized only once when we use the static keyword. But an abstract class is a class which can have one or more than one abstract methods. Abstract methods are those which don't have implementation/body rather only has its declaration, so it is left to the class that extends it to provide implementation.

## Operator overloading

Some OO languages enable you to overload an operator. C++ is an example of one such language. Operator overloading enables you to change the meaning of an operator. For example, when most people see a plus sign, they assume it represents addition. If you see the equation `X = 5 + 6;` you expect that X would contain the value 11. And in this case, you would be correct.

However, at times a plus sign could represent something else. For example, in the following code:

```java
String firstName = "Joe";
String secondName = "Smith";

String Name = firstName + " " + secondName;
```

> **Overloading:** in this context explains that operator overloading refers to giving an operator a new meaning besides its usual meaning, in the context of object-oriented programming languages.

You would expect that Name would contain `Joe Smith`. The plus sign here has been overloaded to perform string concatenation.

> **String Concatenation:** String concatenation occurs when two separate strings are combined to create a new, single string.

In the context of strings, the plus sign does not mean addition of integers or floats but concatenation of strings.

What about matrix addition? You could have code like this:

```java
Matrix a, b, c;
c = a + b;
```

Thus, the plus sign now performs matrix addition, not addition of integers or floats. Overloading is a powerful mechanism. However, it can be downright confusing for people who read and maintain code. In fact, developers can confuse themselves. To take this to an extreme, it would be possible to change the operation of addition to perform subtraction. Why not? Operator overloading allows you to change the meaning of an operator. Thus, if the plus sign were changed to perform subtraction, the following code would result in an X value of —1: `x = 5 + 6;`.

OO languages such as Java and .NET do not allow operator overloading.

Although these languages do not allow the option of overloading operators, the languages themselves do overload the plus sign for string concatenation, but that’s about it. The designers of Java must have decided that operator overloading was more of a problem than it was worth. If you must use operator overloading in C++, take care by documenting and commenting properly so the people who will use the class are not confused.

## Multiple inheritance

As the name implies, multiple inheritance allows a class to inherit from more than one class. In practice, this seems like a great idea. Objects are supposed to model the real world, are they not? And many real-world examples of multiple inheritance exist. Parents are a good example of multiple inheritance. Each child has two parents—that’s just the way it is. So it makes sense that you can design classes by using multiple inheritance. In some OO languages, such as C++, you can.

However, this situation falls into a category similar to operator overloading. Multiple inheritance is a very powerful technique, and in fact, some problems are quite difficult to solve without it. Multiple inheritance can even solve some problems quite elegantly. However, multiple inheritance can significantly increase the complexity of a system, both for the programmer and the compiler writers.

The designers of Java, .NET, Typescript, and Swift decided that the increased complexity of allowing multiple inheritance far outweighed its advantages, so they simply did not implement it. In some ways, Java, .NET, Typescript, and Swift compensate for this; however, the bottom line is that Java, .NET, Typescript, and Swift do not allow conventional multiple inheritance.

The modern concept of inheritance is that you can only inherit attributes from a single parent (single inheritance). Even though you can use multiple interfaces or protocols, this is not truly multiple inheritance.

> **Behavioral and Implementation Inheritance:** Interfaces are a mechanism for behavioral inheritance, whereas abstract classes are used for implementation inheritance. Note you `extend` abstract classes(implementation), and you `inherit` from interfaces(behavioral). So basically in behavioral inheritance you implement the behavior in the class that inherits the interface, and in implementation inheritance the implementation is handled by the superclass, that base class extends from. The bottom line is that interface language constructs provide behavioral interfaces but no implementation, whereas abstract classes may provide both interfaces and implementation.

## Objects operation

Some of the most basic operations in programming become more complicated when you’re dealing with complex data structures and objects. For example, when you want to copy or compare primitive data types, the process is quite straightforward. However, copying and comparing objects is not quite as simple. In his book Effective C++, Scott Meyers devotes an entire section to copying and assigning objects.

> **Classes and References:** The problem with complex data structures and objects is that they might contain references. Simply making a copy of the reference does not copy the data structures or the object that it references. In the same vein, when comparing objects, simply comparing a pointer to another pointer only compares the references—not what they point to.

The problems arise when comparisons and copies are performed on objects. Specifically, the question boils down to whether you follow the pointers. Regardless, there should be a way to copy an object. Again, this is not as simple as it might seem. Because objects can contain references, these reference trees must be followed to do a valid copy (if you truly want to do a deep copy).

> **Deep Versus Shallow Copies:** A deep copy occurs when all the references are followed and new copies are created for all referenced objects. Many levels might be involved in a deep copy. For objects with references to many objects, which in turn might have references to even more objects, the copy itself can create significant overhead. A shallow copy would simply copy the reference and not follow the levels. Gilbert and McCarty have a good discussion about what shallow and deep hierarchies are in Object-Oriented Design in Java in a section called “Prefer a Tree to a Forest.”

If you do a simple copy of the object (called a bitwise copy), only the references are copied—not any of the actual objects. Thus, both objects (the original and the copy) will reference (point to) the same objects. To perform a complete copy, in which all reference objects are copied, you must write code to create all the sub-objects.

This problem also manifests itself when comparing objects. As with the copy function, this is not as simple as it might seem. Because objects contain references, these reference trees must be followed to do a valid comparison of objects. In most cases, languages provide a default mechanism to compare objects. As is usually the case, do not count on the default mechanism. When designing a class, you should consider providing a comparison function in your class that you know will behave as you want it to.
