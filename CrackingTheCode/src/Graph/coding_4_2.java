package Graph;

/**
 * Created by amritachowdhury on 5/14/17.
 */
public class coding_4_2 {
    public class Tree {
        int val;
        Tree left;
        Tree right;

        public Tree(int val, Tree left, Tree right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public void run() {
        int [] nodes = new int [] {1, 2, 3, 4, 5, 6, 7};
        Tree root = growTree(0, nodes.length - 1, nodes);
        inOrderTraversal(root);
    }

    private Tree growTree(int lower, int upper, int [] nodes) {
        Tree root = null;
        if (lower <= upper) {
            int length = upper - lower + 1;
            if (length == 1) {
                return new Tree(nodes[(lower + upper ) / 2], null, null);
            } else {
                int mid = (lower + upper ) / 2;
                mid = Math.max(1, mid);
                root = new Tree(nodes[mid], null, null);
                Tree left = growTree(lower, mid - 1, nodes);
                Tree right = growTree(mid + 1, upper, nodes);
                root.left = left;
                root.right = right;
                return root;
            }
        } else {
            return root;
        }
    }

    private void inOrderTraversal(Tree root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.println(root.val);
            inOrderTraversal(root.right);
        }
    }
}
