# Library System
An implementation of a library system to be tested using JUnit4 with a simple textual user interface.

This project is a Maven project, i.e. it uses the standard Maven project structure that your IDE hopefully understands when you `git clone` it. The provided Maven POM includes the JUnit4 dependency. The POM sets the Java version to 17: you may need to downgrade it if you use an older JDK.

Both the implementation and the tests are in Java package `is.hi.hbv202g.ass5`,
but in the usual separate Maven `src` directories:

- `src/main/java`:
    - `IntStack.java`: Implementation of a simple stack.
    - `IntStackMain.java`: A class with a main method demonstrating some sample usage of the stack.

- `src/test/java`:
    - `IntStackTest.java`: A class containing JUnit4 sample test cases for the `IntStack` class.

Maven:

- `mvn compile` compiles all implementation classes.
- `mvn test` runs all test cases (i.e. all classes with a name that either starts with `Test` or ends with `Test`, `Tests`, or `TestCase`).

