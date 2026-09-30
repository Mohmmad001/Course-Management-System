package final_project;

public class LinkedList {

    // ================= NODE =================
    private class Node {
        Course course;
        Node next;

        Node(Course c) {
            this.course = c;
            this.next = null;
        }
    }

    // ================= DATA =================
    private Node head = null;
    private Node tail = null;
    private int size = 0;

    // ================= INSERT =================
    public void insert(Course c, int index) {
    	
    	

        if (index <= 0) {
            insertAtFirst(c);
        } else if (index >= size) {
            insertAtLast(c);
        } else {
            insertAtPosition(c, index);
        }
    }

    private void insertAtFirst(Course c) {

        Node newNode = new Node(c);

        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }

        size++;
    }

    private void insertAtLast(Course c) {

        Node newNode = new Node(c);

        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }

    private void insertAtPosition(Course c, int index) {

        Node newNode = new Node(c);
        Node temp = head;

        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;

        size++;
    }

    // ================= DELETE =================
    public void delete(int id) {

        int pos = searchPosition(id);

        if (pos == -1) {
            System.out.println("Course not found");
            return;
        }

        if (pos == 0) {
            deleteAtFirst();
        } else if (pos == size - 1) {
            deleteAtLast();
        } else {
            deleteAtPosition(pos);
        }
    }

    private void deleteAtFirst() {

        if (head == null) return;

        head = head.next;

        if (head == null) {
            tail = null;
        }

        size--;
    }

    private void deleteAtLast() {

        if (head == null) return;

        if (head == tail) {
            head = tail = null;
        } else {

            Node temp = head;

            while (temp.next != tail) {
                temp = temp.next;
            }

            temp.next = null;
            tail = temp;
        }

        size--;
    }

    private void deleteAtPosition(int pos) {

        Node temp = head;

        for (int i = 0; i < pos - 1; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;

        size--;
    }

    // ================= SEARCH =================
    private int searchPosition(int id) {

        Node temp = head;
        int index = 0;

        while (temp != null) {

            if (temp.course.ID == id) {
                return index;
            }

            temp = temp.next;
            index++;
        }

        return -1;
    }

    public Course search(int id) {

        Node temp = head;

        while (temp != null) {

            if (temp.course.ID == id) {
                return temp.course;
            }

            temp = temp.next;
        }

        return null;
    }

    // ================= PRINT =================
    public void printAll() {

        Node temp = head;

        while (temp != null) {
            System.out.println(
                "ID: " + temp.course.ID +
                " | Title: " + temp.course.Title +
                " | Credits: " + temp.course.CreditHours
            );

            temp = temp.next;
        }
    }

    public void printUpcoming() {

        Node temp = head;

        while (temp != null) {

            if (temp.course.Statues.equals("Did not Finish")) {

                System.out.println(
                    "ID: " + temp.course.ID +
                    " | Title: " + temp.course.Title +
                    " | Credits: " + temp.course.CreditHours
                );
            }

            temp = temp.next;
        }
    }

    public void printCompleted() {

        Node temp = head;

        while (temp != null) {

            if (temp.course.Statues.equals("Completed")) {

                System.out.println(
                    "ID: " + temp.course.ID +
                    " | Title: " + temp.course.Title +
                    " | Credits: " + temp.course.CreditHours
                );
            }

            temp = temp.next;
        }
    }
    
    
    // ================= ACCESS =================
    public Course getFirst() {
        if (head == null) return null;
        return head.course;
    }

    public Course getLast() {
        if (tail == null) return null;
        return tail.course;
    }

    // ================= UTILITY =================
    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }
}