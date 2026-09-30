package final_project;

public interface IGraph {

    void addEdge(int from, int to);

    void removeEdge(int from, int to);

    public void printByBFS(int start, LinkedList coursesList);
    
    boolean isConnected(int from, int to);

    int size();
}