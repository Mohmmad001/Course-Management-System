package final_project;

public interface ILinkedList {

    void insert(Course c, int index);

    void delete(int id);

    Course search(int id);

    void printAll();

    boolean isEmpty();

    int size();

    Course getFirst();

    Course getLast();
}