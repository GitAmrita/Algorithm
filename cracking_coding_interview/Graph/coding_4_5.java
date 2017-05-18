package Tree;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by amritachowdhury on 5/14/17.
 */
public class coding_4_5 {

    Node n10, n19, n14, n31, n42, n35, n27;
    public class Node {
        int val;
        Node left;
        Node right;

        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public void run() {
        createTree();
        boolean isBST = true;
        List<Integer> values = new LinkedList<>();
        inOrderTraversal(n27, values);
        for (int i = 0; i < values.size() - 2; i++) {
            if (values.get(i) > values.get(i + 1)) {
                isBST = false;
            }
        }
        String s = isBST ? "Binary tree is a BST" : "Binary tree is not a BST";
        System.out.print(s);
    }

    private void createTree() {
        n14 = new Node(14, null, null);
        n19 = new Node(19, null, null);
        n10 = new Node(10, n14, n19);
        n31 = new Node(31, null, null);
        n42 = new Node(42, null, null);
        n35 = new Node(35, n31, n42);
        n27 = new Node(27, n10, n35);
    }

    private void inOrderTraversal(Node root, List<Integer> inOrderValues) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left, inOrderValues);
        System.out.print(root.val + " ");
        inOrderValues.add(root.val);
        inOrderTraversal(root.right, inOrderValues);
    }
}
