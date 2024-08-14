# Design Patterns

Throughout history, humans have used patterns in many aspects of life, including engineering. These patterns go hand-in-hand with the holy grail of software development: software reuse. Patterns lend themselves perfectly to the concept of reusable software development. Because object-oriented development is all about reuse, patterns and object-oriented development go hand-in-hand.

## Why Design Patterns?

In the book A Pattern Language: Towns, Buildings, Construction, they define design patterns as: “Each pattern describes a problem which occurs over and over again in our environment, and then describes the core of the solution to that problem, in such a way that you can use the solution a million times over, without ever doing it the same way twice.”

### The Four Elements of a Pattern

The GoF (Gang of Four) describe a pattern as having four essential elements:

1. **Pattern Name**
    - A handle we use to describe a design problem, its solutions, and consequences in a word or two.
    - Naming a pattern increases our design vocabulary, allowing us to design at a higher level of abstraction.
    - It helps us communicate designs and their trade-offs with colleagues and in documentation.

2. **Problem**
    - Describes when to apply the pattern.
    - Explains the problem and its context.
    - Might describe specific design problems, like representing algorithms as objects.
    - Sometimes includes conditions that must be met before applying the pattern.

3. **Solution**
    - Describes the elements that make up the design, their relationships, responsibilities, and collaborations.
    - Provides an abstract description of a design problem and how a general arrangement of elements solves it.
    - Doesn't describe a specific concrete design or implementation.

4. **Consequences**
    - The results and trade-offs of applying the pattern.
    - Critical for evaluating design alternatives and understanding the costs and benefits.
    - Often concern space and time trade-offs, language, and implementation issues.
    - Include the impact on a system's flexibility, extensibility, or portability.
    - Listing consequences explicitly helps in understanding and evaluating them.

## Smalltalk's Model/View/Controller

Design Patterns defines the MVC components in the following manner: "The Model is the application object, the View is the screen presentation, and the Controller defines the way the user interface reacts to user input."

With the MVC paradigm, these three components have separate and distinct interfaces (somewhat). So if you want to change the user interface of an application, you only have to change the View. Look at Angular that pioneers this approach **somewhat**:

```typescript jsx
// user.model.ts (Model)
export class User {
  constructor(public name: string, public email: string) {}
}

// user.component.ts (Controller)
import { Component } from '@angular/core';
import { User } from './user.model';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html'
})
export class UserComponent {
  user: User = new User('John Doe', 'john.doe@example.com');
  
  // Specifically the controller
  updateUser() {
    this.user.name = 'Jane Doe';
  }
}

// user.component.html (View)
<div>
  <p>Name: {{ user.name }}</p>
  <p>Email: {{ user.email }}</p>
  <button (click)="updateUser()">Update User</button>
</div>
```

### Benefits of Following the MVC Concept

If you follow the MVC (Model-View-Controller) concept and separate the user interface, business logic, and data, your system will be much more flexible and robust.

#### Example Scenario

- **User Interface (UI)**: On a client machine.
- **Business Logic**: On an application server.
- **Data**: Located on a data server.

#### Advantages

1. **Changing the UI**:
    - You can change the way the GUI (Graphical User Interface) looks without affecting the business logic or the data.

2. **Updating Business Logic**:
    - If your business logic changes (e.g., calculating a specific field differently), you can update the business logic without changing the GUI.

3. **Swapping Databases**:
    - If you want to store your data differently or use a different database, you can change the data storage on the data server without affecting the GUI or the business logic.

This approach assumes that the interfaces between the UI, business logic, and data do not change (very important).

## Types Of Design Patterns

Design patterns are grouped into 3 types:

1. **Creational Patterns**
    - Create objects for you, rather than having you instantiate objects directly.
    - Provides more flexibility in deciding which objects need to be created for a given case.

2. **Structural Patterns**
    - Help you compose groups of objects into larger structures.
    - Examples include complex user interfaces or accounting data.

3. **Behavioral Patterns**
    - Define the communication between objects in your system.
    - Control the flow in a complex program.