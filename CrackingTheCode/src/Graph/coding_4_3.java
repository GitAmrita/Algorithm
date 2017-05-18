package Graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by amritachowdhury on 5/14/17.
 */
public class coding_4_3 {
    Node n1, n2, n3, n4, n5, n6, n7;
    List<Node> graph = new LinkedList<>();

    public class Node {
        int val;
        boolean visited;
        int level;
        List<Node> edges;

        public Node(int val) {
            this.val = val;
            this.visited = false;
            this.level = 1;
            this.edges = new LinkedList<>();
        }
    }

    public void run() {
        createGraph();
        printLinkedListOfNodes(n1);
    }

    private void printLinkedListOfNodes(Node start) {
        int lastLevelPrinted = 1;
        Queue<Node> queue = new LinkedList<>();
        start.visited = true;
        queue.add(start);
        System.out.println(start.val);
        while (!queue.isEmpty()) {
            Node popped = queue.poll();
            if (lastLevelPrinted < popped.level) {
                System.out.println();
                lastLevelPrinted = popped.level;
            }
            for (Node n : popped.edges) {
                if (!n.visited) {
                    n.visited = true;
                    n.level = popped.level + 1;
                    queue.add(n);
                    System.out.print(n.val + " ");
                }
            }
        }
    }

    private void createGraph() {
        n1 = new Node(1);
        n2 = new Node(2);
        n3 = new Node(3);
        n4 = new Node(4);
        n5 = new Node(5);
        n6 = new Node(6);
        n7 = new Node(7);
        n1.edges.add(n2); n1.edges.add(n3);
        n2.edges.add(n4); n2.edges.add(n5);
        n3.edges.add(n6); n3.edges.add(n7);
        graph.add(n1); graph.add(n2); graph.add(n3); graph.add(n4); graph.add(n5); graph.add(n6); graph.add(n7);
    }
}
