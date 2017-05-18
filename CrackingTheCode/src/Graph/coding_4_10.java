package Graph;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by amritachowdhury on 5/17/17.
 */
public class coding_4_10 {
    Node n1, n2, n3, n4, n5, n6, n7, n8, n9, n10, n11;
    public class Node {
        int val;
        Node left;
        Node right;

        public Node() {}

        public Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }

        public void getSubTree(Node n, Node left, Node right) {
            n.left = left; n.right = right;
        }
    }

    public void run() {
        buildTree();
        boolean isSubTree = checkSubtree(n1, n3);
        if (isSubTree) {
            System.out.println("Tree2 is subtree of Tree1");
        } else {
            System.out.println("Tree2 is not a subtree of Tree1");
        }
    }

    private boolean checkSubtree(Node r1, Node r2) {
        if (r1 == r2) {
            List<Node> tree1 = new LinkedList<>();
            inOrderTraversal(r1, tree1);
            List<Node> tree2 = new LinkedList<>();
            inOrderTraversal(r2, tree2);
            return checkIfPathsAreEqual(tree1, tree2);
        } else if (r1 == null) {
            return false;
        }
        else {
             return checkSubtree(r1.left, r2) || checkSubtree(r1.right, r2);
        }
    }

    private List<Node> inOrderTraversal(Node root, List<Node> traversal) {
        if (root != null) {
            inOrderTraversal(root.left, traversal);
            traversal.add(root);
            inOrderTraversal(root.right, traversal);
        }
        return traversal;
    }

    private boolean checkIfPathsAreEqual(List<Node> tree1, List<Node> tree2) {
        return tree1.equals(tree2);
    }

    private void buildTree() {
        Node obj = new Node();
        n1 = new Node(1);  n2 = new Node(2);  n3 = new Node(3);  n4 = new Node(4);  n5 = new Node(5);
        n6 = new Node(6);  n7 = new Node(7);  n8 = new Node(8); n9 = new Node(9); n10 = new Node(10);
        n11 = new Node(11);
        obj.getSubTree(n1, n2, n3); obj.getSubTree(n2, n4, n5); obj.getSubTree(n3, n6, n7); obj.getSubTree(n4, n8, null);
        obj.getSubTree(n9, n10, n11);
    }
}
