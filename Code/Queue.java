package final_project;

public class Queue implements IQueue {

    private LinkedList list = new LinkedList();

    @Override
    public void enqueue(Course c) {
        
        list.insert(c, list.size());
    }

    @Override
    public void dequeue() {

        if (list.isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        Course first = list.getFirst();
        list.delete(first.ID);
    }

    @Override
    public Course peek() {

        if (list.isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }

        return list.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void printAll() {
        list.printAll();
    }
}