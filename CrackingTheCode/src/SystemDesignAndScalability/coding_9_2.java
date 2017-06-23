package SystemDesignAndScalability;

import java.util.*;


/**
 * Created by amritachowdhury on 6/13/17.
 */
public class coding_9_2 {
    Node source = null; Node destination = null;
    private class Node {
        String data;
        Set<Node> connections;

        public Node() {}

        public Node(String data) {
            this.data = data;
            this.connections = new HashSet<>();
        }

        public void setConnections(Node n, Node p) {
            n.connections.add(p);
            p.connections.add(n);
        }
    }

    private class BFSHelper {
        Queue<Node> queue;
        Set<Node> visited;
        Map<Node, Node> path;

        public BFSHelper() {
            this.queue = new LinkedList<>();
            this.visited = new LinkedHashSet<>();
            this.path = new HashMap<>();
        }
    }

    public void run() {
        buildTree();
        List<Node> shortestPath = getShortestPathBiDirectionalBFS();
        if (shortestPath != null) {
            printPath(shortestPath);
        }
    }

    private void insertIntoQueue(Node node, BFSHelper helper) {
        for (Node n : node.connections) {
            if (!helper.visited.contains(n)) {
                helper.visited.add(n);
                helper.queue.add(n);
                helper.path.put(n, node);
            }
        }
    }

    private boolean checkVisited(Node node, BFSHelper helper) {
        return helper.visited.contains(node);
    }

    private List<Node> getShortestPathBiDirectionalBFS() {
        List<Node> forwardPath = new LinkedList<>();
        Node mid = null;
        Node currentS = source;
        Node currentD = destination;
        if (source == destination) {
            System.out.println("Source and Destination are the same");
            return null;
        }
        BFSHelper helperS = new BFSHelper();
        BFSHelper helperD = new BFSHelper();
        helperS.visited.add(currentS);
        helperS.queue.add(currentS);
        helperD.visited.add(currentD);
        helperD.queue.add(currentD);
        while (helperS.queue.size() != 0 && helperD.queue.size() != 0) {
            currentS = helperS.queue.poll();
            currentD = helperD.queue.poll();
            boolean isVisitedByD = checkVisited(currentS, helperD);
            insertIntoQueue(currentS, helperS);
            boolean isVisitedByS = checkVisited(currentD, helperS);
            insertIntoQueue(currentD, helperD);
            if (isVisitedByD || isVisitedByS) {
                mid = isVisitedByD ? currentS : currentD;
                break;
            }
        }

        if (mid == null) {
            System.out.println("Destination not found");
        } else {
            for (Node node = mid; node != null; node = helperS.path.get(node)) {
                forwardPath.add(0, node);
            }
            for (Node node = helperD.path.get(mid); node != null; node = helperD.path.get(node)) {
                forwardPath.add(node);
            }
        }
        return forwardPath;
    }

    private List<Node> getShortestPathBFS() {
        List<Node> forwardPath = new LinkedList<>();
        Node currentS = source;
        BFSHelper helperS = new BFSHelper();
        helperS.visited.add(currentS);
        helperS.queue.add(currentS);
        if (source == destination) {
            System.out.println("Source and Destination are the same");
            return null;
        }
        while (helperS.queue.size() != 0) {
            currentS = helperS.queue.poll();
            if (currentS == destination) {
                break;
            }
            insertIntoQueue(currentS, helperS);
        }

        if (currentS != destination) {
            System.out.println("Destination not found");
        } else {
            for (Node node = destination; node != null; node = helperS.path.get(node)) {
                forwardPath.add(0, node);
            }
        }
        return forwardPath;
    }

    private void printPath(List<Node> direction) {
        StringBuilder builder = new StringBuilder();
        int count = 0;
        for (Node path : direction) {
            count ++;
            builder.append( count < direction.size() ? path.data + " -> " : path.data);
        }
        System.out.print(builder.toString());
    }

    private void buildTree() {
        Node N = new Node();
        Node n1 = new Node("a"); Node n2 = new Node("b"); Node n3 = new Node("s");
        Node n4 = new Node("c"); Node n5 = new Node("d"); Node n6 = new Node("g");
        Node n7 = new Node("f"); Node n8 = new Node("e"); Node n9 = new Node("h");
        Node n10 = new Node("h1");
        N.setConnections(n1, n2); N.setConnections(n1, n3);
        N.setConnections(n3, n4); N.setConnections(n3, n6);
        N.setConnections(n4, n5); N.setConnections(n4, n7); N.setConnections(n4, n8);
        N.setConnections(n6, n7); N.setConnections(n6, n9);
        N.setConnections(n8, n9);
        source = n1; destination = n9;
    }
}
