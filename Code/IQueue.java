package final_project;

public interface IQueue {

    void enqueue(Course c);

    void dequeue();

    Course peek();

    boolean isEmpty();

    void printAll();
}