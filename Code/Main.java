package final_project;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        LinkedList studentList = new LinkedList();
        LinkedList coursesList = new LinkedList();

        IQueue upcomingCourses = new Queue();
        IBST courseGrade = new BST();
        
        
     
      Graph graph = new Graph(6);

     // Intro Programming unlocks Data Structures
     graph.addEdge(1, 2);

     // Data Structures unlocks OOP
     graph.addEdge(2, 3);

     // OOP unlocks Database
     graph.addEdge(3, 4);

     // Database unlocks Operating Systems
     graph.addEdge(4, 5);

        

        Course c1 = new Course(1, "Introduction to Programming", 3, 0, "Did not Finish");
        Course c2 = new Course(2, "Data Structures", 3, 0, "Did not Finish");
        Course c3 = new Course(3, "Object-Oriented Programming", 3, 0, "Did not Finish");
        Course c4 = new Course(4, "Database Systems", 3, 0, "Did not Finish");
        Course c5 = new Course(5, "Operating Systems", 4, 0, "Did not Finish");

        coursesList.insert(c1, 0);
        coursesList.insert(c2, 1);
        coursesList.insert(c3, 2);
        coursesList.insert(c4, 3);
        coursesList.insert(c5, 4);

       

        while (true) {

            System.out.println("====================================");
            System.out.println("Course Management System");
            System.out.println("====================================");

            System.out.println("1. Manage My Course List");
            System.out.println("2. Choose Courses For Next Semester");
            System.out.println("3. Search Completed Course By Grade");
            System.out.println("4. What does this course Unlock");
            System.out.println("5. Exit");

            System.out.println("====================================");

            System.out.print("Enter choice: ");
            int num = input.nextInt();

            // ================= OPTION 1 =================
            if (num == 1) {

                System.out.println("1. Upcoming Courses");
                System.out.println("2. Completed Courses");
                System.out.println("3. Current Courses");
                System.out.println("4. Add Course");
                System.out.println("5. Drop Course");
                System.out.println("6. Finish Course");

                System.out.print("Enter choice: ");
                num = input.nextInt();

                if (num == 1) {

                    coursesList.printUpcoming();

                } else if (num == 2) {

                    coursesList.printCompleted();

                } else if (num == 3) {

                    studentList.printAll();

                } else if (num == 4) {

                    System.out.println("Add Course (-1 to exit)");

                    while (true) {
                        System.out.print("Enter Course ID: ");
                        int id = input.nextInt();

                        if (id == -1) break;

                        Course c = coursesList.search(id);

                        if (c != null) {
                            c.Statues = "Currently Studying";
                            studentList.insert(c, studentList.size());
                            System.out.println("Course added.");
                        } else {
                            System.out.println("Invalid ID.");
                        }
                    }

                } else if (num == 5) {

                    System.out.println("Drop Course (-1 to exit)");

                    while (true) {
                        System.out.print("Enter Course ID: ");
                        int id = input.nextInt();

                        if (id == -1) break;

                        Course c = studentList.search(id);

                        if (c != null) {
                            c.Statues = "Did not Finish";
                            studentList.delete(id);
                            System.out.println("Course dropped.");
                        } else {
                            System.out.println("Not found.");
                        }
                    }

                } else if (num == 6) {

                    System.out.println("Finish Course (-1 to exit)");

                    while (true) {
                        System.out.print("Enter Course ID: ");
                        int id = input.nextInt();

                        if (id == -1) break;

                        Course c = studentList.search(id);

                        if (c != null) {

                            System.out.print("Enter grade: ");
                            int g = input.nextInt();

                            c.Grade = g;
                            c.Statues = "Completed";

                            courseGrade.insert(c);
                            studentList.delete(id);

                            System.out.println("Course finished.");
                        } else {
                            System.out.println("Not found.");
                        }
                    }
                }
            }

            // ================= OPTION 2 =================
            else if (num == 2) {

                System.out.println("1. Plan Courses");
                System.out.println("2. Process Registration");

                num = input.nextInt();

                if (num == 1) {

                    System.out.println("Plan Courses (-1 to exit)");

                    while (true) {
                        System.out.print("Enter Course ID: ");
                        int id = input.nextInt();

                        if (id == -1) break;

                        Course c = coursesList.search(id);

                        if (c != null) {
                            upcomingCourses.enqueue(c);
                            System.out.println("Added to queue.");
                        } else {
                            System.out.println("Invalid ID.");
                        }
                    }

                } else if (num == 2) {

                    while (!upcomingCourses.isEmpty()) {

                        Course c = upcomingCourses.peek();

                        System.out.println("Next Course: " + c.Title);
                        System.out.println("1. Register");
                        System.out.println("2. Skip");

                        int choice = input.nextInt();

                        if (choice == 1) {
                            c.Statues = "Currently Studying";
                            studentList.insert(c, studentList.size());
                            System.out.println("Registered.");
                        }

                        upcomingCourses.dequeue();
                    }
                }
            }

            // ================= OPTION 3 =================
            else if (num == 3) {

                System.out.println("1. Highest Grade");
                System.out.println("2. Lowest Grade");
                System.out.println("3. Find by Grade");

                num = input.nextInt();

                if (num == 1) {
                    Course c = courseGrade.getMax();
                    if (c != null)
                        System.out.println(c.Title + " | " + c.Grade);

                } else if (num == 2) {
                    Course c = courseGrade.getMin();
                    if (c != null)
                        System.out.println(c.Title + " | " + c.Grade);

                } else if (num == 3) {
                    System.out.print("Enter grade: ");
                    int g = input.nextInt();
                    courseGrade.find(g);
                }
            }

            // ================= OPTION 4  =================
            else if (num == 4) {

                System.out.print("Enter Course ID: ");
                int id = input.nextInt();

                graph.printByBFS(id, coursesList);
            }

            // ================= EXIT =================
            else if (num == 5) {

                System.out.println("Goodbye!");
                break;
            }

            else {
                System.out.println("Invalid option");
            }

            System.out.println();
        }

        input.close();
    }
}