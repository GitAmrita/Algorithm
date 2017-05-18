package Tree;

/**
 * Created by amritachowdhury on 5/15/17.
 */
public class coding_4_8 {
    Node n1, n2, n3, n4, n5, n6, n7, n8;
    boolean f1,  f2;
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
        buildTree();
        Node root = n1;
        boolean hasCommonAncestor = isNodePresent(root, n8) && isNodePresent(root, n6);
        if (hasCommonAncestor) {
            Node ancestor = firstCommonAncestor(root, n8, n6);
            System.out.print(ancestor.val);
        } else {
            System.out.print("no ancestor");
        }

    }

    private Node firstCommonAncestor(Node root, Node node1, Node node2) {
        if (root == node1 || root == node2) {
            return root;
        }
        if (root == null) {
            return null;
        }
        Node left = firstCommonAncestor(root.left, node1, node2);
        Node right = firstCommonAncestor(root.right, node1, node2);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }

    private boolean isNodePresent(Node root, Node n) {
        if (root == null) {
            return false;
        }
        if (root == n) {
            return true;
        }
        return isNodePresent(root.left, n) ||  isNodePresent(root.right, n);
    }

    private void buildTree() {
        n8 = new Node(8, null, null); n5 = new Node(5, null, null);
        n6 = new Node(6, null, null); n7 = new Node(7, null, null);
        n4 = new Node(4, n8, null); n2 = new Node(2, n4, n5); n3 = new Node(3, n6, n7);
        n1 = new Node(1, n2, n3);
    }
}
