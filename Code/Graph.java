package final_project;

public class Graph implements IGraph {

    private int[][] adjMatrix;
    private int size;

    // ================= CONSTRUCTOR =================
    public Graph(int size) {
        this.size = size;
        adjMatrix = new int[size][size];
    }

    // ================= ADD EDGE =================
    @Override
    public void addEdge(int from, int to) {

        if (valid(from) && valid(to)) {
            adjMatrix[from][to] = 1;
        }
    }

    // ================= REMOVE EDGE =================
    @Override
    public void removeEdge(int from, int to) {

        if (valid(from) && valid(to)) {
            adjMatrix[from][to] = 0;
        }
    }

    // ================= PRINT GRAPH =================
    @Override
    public void printByBFS(int start, LinkedList coursesList) {

        boolean[] visited = new boolean[size];

        Queue q = new Queue();

        Course startCourse = coursesList.search(start);

        if (startCourse == null) {
            System.out.println("Invalid course ID");
            return;
        }

        q.enqueue(startCourse);
        visited[start] = true;

        while (!q.isEmpty()) {

            Course current = q.peek();
            q.dequeue();

            System.out.println(current.Title + " unlocks:");

            for (int i = 0; i < size; i++) {

                if (adjMatrix[current.ID][i] == 1 && !visited[i]) {

                    Course next = coursesList.search(i);

                    if (next != null) {
                        System.out.println("  -> " + next.Title);
                        q.enqueue(next);
                        visited[i] = true;
                    }
                }
            }
        }
    }

    // ================= CHECK CONNECTION =================
    @Override
    public boolean isConnected(int from, int to) {

        if (valid(from) && valid(to)) {
            return adjMatrix[from][to] == 1;
        }

        return false;
    }

    // ================= SIZE =================
    @Override
    public int size() {
        return size;
    }

    // ================= HELPER =================
    private boolean valid(int index) {
        return index >= 0 && index < size;
    }
}