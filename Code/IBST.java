package final_project;

public interface IBST {

    void insert(Course c);

    Course getMax();   

    Course getMin();   

    void find(int grade);

    boolean isEmpty();
}