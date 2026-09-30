# Course Management System (Java)

A console app for tracking degree progress. It lets a student manage their
course list, plan next semester's registration, review grades, and see which
courses each course unlocks. Every data structure is implemented **from
scratch**, with no `java.util` collections.

## Features

| Feature | Data structure |
|---------|----------------|
| Manage course list (add, drop, finish, view upcoming/completed/current) | Linked List |
| Next-semester registration queue (register or skip in priority order) | Queue (built on the Linked List) |
| Search completed courses by grade (highest, lowest, exact) | Binary Search Tree |
| What does this course unlock? | Graph (adjacency matrix, BFS) |

## Project structure

```
src/final_project/
├── Main.java          # Menu and program flow
├── Course.java        # Course model (ID, title, credits, grade, status)
├── ILinkedList.java / LinkedList.java
├── IQueue.java      / Queue.java
├── IBST.java        / BST.java
└── IGraph.java      / Graph.java
```

Each data structure has an interface (the abstract view) and a class (the
concrete implementation), so an implementation can be swapped without
touching `Main`.

## How it works

- **Linked List** stores the course catalog and the student's current courses.
- **Queue** is a FIFO wrapper around the linked list for registration planning.
- **BST** orders completed courses by grade. Min and max are found by walking
  left or right.
- **Graph** stores prerequisites as directed edges in an adjacency matrix.
  BFS from a course prints everything it unlocks.

## Run it

Requires JDK 8 or later.

```bash
cd src
javac final_project/*.java
java final_project.Main
```

## Sample catalog

Intro to Programming → Data Structures → OOP → Database Systems → Operating Systems

## Known limitations

- Input validation is minimal (non-numeric input will throw).
- Data isn't saved between runs.
- The graph size is fixed at 6 in `Main`.
- There is no undo feature yet. A stack-based undo for list changes would be a
  natural next step.
