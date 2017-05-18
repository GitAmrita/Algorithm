package Tree;

import java.util.*;

/**
 * Created by amritachowdhury on 5/15/17.
 */
public class coding_4_7 {
    Node a, b, c, d, e, f;
    List<Node> graph = new LinkedList<>();
    public class Node {
        String val;
        boolean visited;
        List<Node> edges;

        public Node(String val) {
            this.val = val;
            this.visited = false;
            edges = new LinkedList<>();
        }
    }

    public void run() {
        createDependency();
        Stack<Node> stack = new Stack<>();
        for (Node n : graph) {
            if (!n.visited) {
                topologicalSort(n, stack);
            }
        }
        while (!stack.empty()) {
            System.out.println(stack.pop().val);
        }
    }

    private void topologicalSort(Node node, Stack<Node> stack) {
        node.visited = true;
        List<Node> dependencies = node.edges;
        Collections.sort(dependencies, new Comparator<Node>() {
            @Override
            public int compare(Node a1, Node a2) {
                return  a1.val.compareTo(a2.val);
            }
        });
        for (Node n : dependencies) {
            if (!n.visited) {
                topologicalSort(n, stack);
            }
        }
        stack.push(node);



        /*if (isAllDependenciesMet(node)) {
            stack.push(node);
        } else {
            Collections.sort(dependencies, new Comparator<Node>() {
                @Override
                public int compare(Node a1, Node a2) {
                    return  a1.val.compareTo(a2.val);
                }
            });
            for (Node n : dependencies) {
                if (!n.visited) {
                    topologicalSort(n, stack);
                }
            }

        }*/


    }

    private boolean isAllDependenciesMet(Node node) {
        List<Node> dependencies = node.edges;
        boolean metDependencies = true;
        if (dependencies == null || dependencies.size() == 0) {
            return metDependencies ;
        } else {
            for (Node n : dependencies) {
                if (!n.visited) {
                    metDependencies = false;
                    break;
                }
            }
            return metDependencies;
        }
    }

    private void createDependency() {
        a = new Node ("a"); b = new Node ("b"); c = new Node ("c"); d = new Node ("d");
        e = new Node ("e"); f = new Node ("f");
        f.edges.add(a); f.edges.add(b); a.edges.add(d); b.edges.add(d); d.edges.add(c);
        graph.add(a); graph.add(b); graph.add(c); graph.add(d); graph.add(e); graph.add(f);
    }


}
