# UML

The diagrams here are in UML format which helps explain some of the concepts. These UMLs are specifically in the `plantuml` format, you can generate these uml diagrams with `plantuml`, check out their [get starting guide](https://plantuml.com/starting)

I also included the [jar file](/plantuml-1.2024.3.jar) you can use on your own to generate these UML diagrams. To generate a UML diagram, say [`employee-payroll.puml`](/uml/chapter_one/employee-payroll.puml).

1. First make sure you have java installed on your system by typing `java -version` in your terminal, if you get a response and it is above Java 8, you are good to go.

    If not installed, download and install it from the official Java website or through package managers like apt for Ubuntu, brew for macOS, etc.

2. Then make sure you are at the root of this project, and run this command:

    ```bash
    java -jar plantuml-1.2024.3.jar uml/chapter_one/employee-payroll.puml
    ```

**NB:** If you want to generate a different diagram change `uml/chapter_one/employee-payroll.puml` to the valid file path and name.
