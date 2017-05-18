package Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by amritachowdhury on 5/13/17.
 */
public class coding_4_1 {
    public Node n0, n1, n2, n3;
    public List<Node> graph = new LinkedList<>();
    public class Node {
        int value;
        boolean visited;
        List<Node> edges;

        public Node(int value) {
            this.value = value;
            this.visited = false;
            this.edges = new LinkedList<>();
        }
    }

    public void run() {
        createGraph();
        boolean routePresent = isRoutePresent(n0, n2);
        System.out.println(routePresent);
    }

    private boolean isRoutePresent(Node source, Node destination) {
        if (source == null || destination == null) {
            return false;
        } else if (source == destination) {
            return true;
        }
        Queue<Node> queue = new LinkedList<>();
        source.visited = true;
        queue.add(source);
        while (!queue.isEmpty()) {
            Node popped = queue.poll();
            List<Node> edges = popped.edges;
            for (Node n : edges) {
                if (n == destination) {
                    return true;
                }
                if (!n.visited) {
                    n.visited = true;
                    queue.add(n);
                }
            }
        }
        return false;
    }

    private void createGraph() {
        n0 = new Node(0);
        n1 = new Node(1);
        n2 = new Node(2);
        n3 = new Node(3);
        n0.edges.add(n1);
        n1.edges.add(n2);
        n2.edges.add(n0);
        n3.edges.add(n2);
        graph.add(n0);
        graph.add(n1);
        graph.add(n2);
        graph.add(n3);
    }
}
