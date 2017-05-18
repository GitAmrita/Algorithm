package Graph;

/**
 * Created by amritachowdhury on 5/14/17.
 */
public class coding_4_6 {
    Node n50, n17, n72, n12, n23, n18, n24, n54, n76;
    public class Node {
        int val;
        Node left;
        Node right;
        Node parent;

        public Node() {}

        public Node (int val) {
            this.val = val;
            this.left = null;
            this.right = null;
            this.parent = null;
        }

        public void fillFamily(Node current, Node left, Node right, Node parent) {
            current.left = left; current.right = right; current.parent = parent;
        }
    }

    public void run() {
        createTree();
        Node predesessor = n76;
        Node successor = getSuccessor(predesessor);
        if (successor == null) {
            System.out.print("This is the last node in the in order traversal");
        } else {
            System.out.print(successor.val);
        }
    }

    private Node getSuccessor(Node node) {
        if (node.parent == null) {
            return traverseLeftSubTree(node.right);
        } else {
            Node parent = node.parent;
            // left leaf of left subtree or inner node of left subtree
            if (parent.left.val == node.val) {
                return node.right != null ? traverseLeftSubTree(node.right) : parent;
            }
            else {
                // inner node of left subtree
                return node.right != null ? node.right : traverseRightLeaf(node);
            }
        }
    }

    private Node traverseLeftSubTree(Node node) {
        if (node == null) {
            return null;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    private Node traverseRightLeaf(Node node) {
        Node parent = node.parent;
        while (parent.parent != null) {
            parent = parent.parent;
        }// right leaf of left subtree
        if (node.val < parent.val) {
            return parent;
        } else {
            return traverseLeftSubTree(node.right);
        }
    }

    private void createTree() {
        Node n = new Node();
        n50 = new Node(50); n17 = new Node(17); n72 = new Node(72); n12 = new Node(12);
        n23 = new Node(23); n18 = new Node(18); n24 = new Node(24); n54 = new Node(54);
        n76 = new Node(76);
        n.fillFamily(n50, n17, n72, null); n.fillFamily(n17, n12, n23, n50); n.fillFamily(n72, n54, n76, n50);
        n.fillFamily(n12, null, null, n17); n.fillFamily(n23, n18, n24, n17);
        n.fillFamily(n54, null, null, n72); n.fillFamily(n76, null, null, n72);
        n.fillFamily(n18, null, null, n23); n.fillFamily(n24, null, null, n23);
    }
}
