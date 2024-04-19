# Library System
An implementation of a library system to be tested using JUnit4 with a simple textual user interface.

This project is a Maven project, i.e. it uses the standard Maven project structure that your IDE hopefully understands when you `git clone` it. The provided Maven POM includes the JUnit4 dependency. The POM sets the Java version to 17: you may need to downgrade it if you use an older JDK.

Both the implementation and the tests are in Java package `is.hi.hbv202g.assignment8`,
but in the usual separate Maven `src` directories:

- `src/main/java`:
    - `Author.java`: A class to implement the authors.
    - `Book.java`: A class to implement the books.
    - `Omnibus.java`: A class to implement book collections using the omnibus design pattern.
    - `Lending.java`: A class to implement lendings.
    - `User.java`: A class to implement the users. This class can be extended to `Student` or `FacultyMember`.
    - `Student.java`: A class to implement a student user. An extension to the `User` class.
    - `FacultyMember.java`: A class to implement a faculty member user. An extension to the `User` class.
    - `LibrarySystem.java`: A class to create the library system.
    - `Main.java`: A class with a main method demonstrating some sample usage of the library system.

- `src/test/java`:
    - `LibrarySystemTest.java`: A class containing JUnit4 sample test cases for the `LibrarySystem` class.

Maven:

- `mvn compile` compiles all implementation classes.
- `mvn test` runs all test cases (i.e. all classes with a name that either starts with `Test` or ends with `Test`, `Tests`, or `TestCase`).
- `mvn javadoc:javadoc` generates HTML from Javadoc comments.

Jar File:
- `build.sh`
- `run.sh`