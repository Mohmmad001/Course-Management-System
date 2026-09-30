package final_project;

public class BST implements IBST {

    // ================= NODE =================
    private class Node {
        Course course;
        Node left;
        Node right;

        Node(Course c) {
            this.course = c;
            this.left = null;
            this.right = null;
        }
    }

    // ================= ROOT =================
    private Node root = null;

    // ================= INTERFACE METHODS =================

    @Override
    public void insert(Course c) {
        root = insertNode(root, c);
    }

    @Override
    public Course getMax() {

        if (root == null) {
            System.out.println("No courses available");
            return null;
        }

        Node temp = root;

        while (temp.right != null) {
            temp = temp.right;
        }

        return temp.course;
    }

    @Override
    public Course getMin() {

        if (root == null) {
            System.out.println("No courses available");
            return null;
        }

        Node temp = root;

        while (temp.left != null) {
            temp = temp.left;
        }

        return temp.course;
    }

    @Override
    public void find(int grade) {

        Node temp = root;

        while (temp != null) {

            if (temp.course.Grade == grade) {
                System.out.println("Found: ID " + temp.course.ID +
                                   " Title " + temp.course.Title);
                return;
            }

            if (grade < temp.course.Grade) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }

        System.out.println("No course found with this grade");
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    

    private Node insertNode(Node node, Course c) {

        if (node == null) {
            return new Node(c);
        }

        if (c.Grade < node.course.Grade) {
            node.left = insertNode(node.left, c);
        } else {
            node.right = insertNode(node.right, c);
        }

        return node;
    }
}