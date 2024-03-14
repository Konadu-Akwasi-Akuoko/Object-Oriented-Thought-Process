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
