package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by amritachowdhury on 8/14/17.
 */
public class DepthFirstSearch {
    public List<Node> graph = new ArrayList<>();
    public Node start;


    public class Node {
        public int val;
        public List<Node> edges;
        public boolean visited;

        public Node(int val) {
            this.val = val;
            this.edges = new ArrayList<>();
            this.visited = false;
        }
    }

    public void createGraph() {
        Node n0 = new Node (0);
        Node n1 = new Node (1);
        Node n2 = new Node (2);
        Node n3 = new Node (3);
        n0.edges = new ArrayList<>(Arrays.asList(n1, n2));
        n1.edges = new ArrayList<>(Arrays.asList(n2));
        n2.edges = new ArrayList<>(Arrays.asList(n0, n3));
        n3.edges = new ArrayList<>(Arrays.asList(n3));
        graph.add(n0); graph.add(n1); graph.add(n2); graph.add(n3);
        this.start = n2;
    }

    public void printNode(Node n) {
        System.out.println(n.val);
    }

    public void DFS (Node n) {
        if (! n.visited) {
            n.visited = true;
            printNode(n);
            for (Node p : n.edges) {
                DFS(p);
            }
        }
    }

    public void run() {
        createGraph();
        DFS(start);
    }
}
