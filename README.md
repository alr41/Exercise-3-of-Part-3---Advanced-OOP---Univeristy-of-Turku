# Exercise-3-of-Part-3---Advanced-OOP---Univeristy-of-Turku

## 1. Student ID
Student ID: 2406530

## 2. Exercise 3 implementation solution - description
The main goal of the solution is to transform the original script into an object-oriented format, in order to achieve maintainability and extensibility. As such, the focus of the chosen approach is to leverage the concepts of inheritance and polymorphism learned throughout part 3 of the course.

**I.** The first step was creating and abstarct Shape class to serve as a foundation for the other objects. This class is responsible for declaring the abstract methods of **getArea()** and **getBoundaries**, and it is possible to declare more calculations methods easily as well.

The origal code script, intead of using a more dynamic method, used a rigid switch statement that relied on String comparisons to execute the correct logic. This means that, in order to add more shapes, the switch statement itself would need to be modified:

**Original script:**
```java
        return switch ((String) ps[0]) {
            case "triangle" -> (x1 - x2) * (y1 - y2) / 2;
            case "quadrilateral" -> (x1 - x2) * (y1 - y2);
            case "circle" -> Math.PI * ((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
            default -> throw new Exception("Unfamiliar pattern!");
        }
```

**Modified script:** each class inherits Shape and provides its own override of the getArea() method. This approach ensures each subclass is responsible for its own behaviour, without relying in a central part of the code making all the choices. For example, the Circle class:
```java
    @Override
    public double getArea() {
        Boundaries boundaries = getBoundaries();
        int dx = boundaries.max().x() - boundaries.min().x();
        int dy = boundaries.max().y() - boundaries.min().y();
        return Math.PI * (dx * dx + dy * dy);
      }
```

**II.** Subsequently, each shape was implemented as a class that extends the abstract Shape class. As a consequence, if more shapes need to be added, or if the existing ones need to be altered, this can be done without having to disrupt the rest of the code.

**III.** Due to the inheritance established, it is possible to use polymorphism to process collections of shapes in a flexible manner, using List<Shape>. This allows the main application to handle any number of different shapes without needing to know their specific types.

**IV.** Finally, the solution makes much better use of the Java type system to enforce correctness. The original code used a generic Object[] to store shape data, which can lead to errors. However, the new design replaces this with specific classes, such as Circle, and records, such as Point. This means that the compilers now verifies the code at compile time.  For example, a Circle object cannot be created without providing the data its constructor requires, making the code less prone to bugs.
