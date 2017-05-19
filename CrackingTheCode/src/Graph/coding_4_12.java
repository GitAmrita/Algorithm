package Graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by amritachowdhury on 5/18/17.
 */
public class coding_4_12 {
    Node na, nb, nc, nd, ne, nf, ng, nh, ni;
    int targetSum = 8;
    int currentCount;
    public class Node {
        int val;
        Node left;
        Node right;
        List<Integer> sum;

        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.sum = new LinkedList<>();
        }
    }

    public void run() {
        buildTree();
        countPathSum(na, null);
        System.out.println(currentCount);
    }

    private void countPathSum(Node root, Node parent) {
        if (root == null) {
            return;
        }
        root.sum.add(root.val);
        if (root.val == targetSum) {
            currentCount ++;
        }
        if (parent != null) {
            List<Integer> parentSum = parent.sum;
            for (Integer i : parentSum) {
                int localSum = i + root.val;
                root.sum.add(localSum);
                if (localSum == targetSum) {
                    currentCount ++;
                }
            }
        }
        System.out.println("Value at node is : " + root.val + " -> " + root.sum.size());
        countPathSum(root.left, root);
        countPathSum(root.right, root);
    }

    private void buildTree() {
        nf = new Node (11, null, null); ng = new Node (3, null, null);
        nh = new Node (-2, null, null); ni = new Node (1, null, null);
        nc = new Node (-3, null, nf); nd = new Node (3, ng, nh); ne = new Node (2, null, ni);
        nb = new Node (5, nd, ne); na = new Node (10, nb, nc);
    }
}
