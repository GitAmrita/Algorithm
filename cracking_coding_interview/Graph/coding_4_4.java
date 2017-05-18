package Tree;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by amritachowdhury on 5/14/17.
 */
public class coding_4_4 {
    Tree n1, n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12;
    public class Tree {
        int val;
        int height;
        Tree left;
        Tree right;

        public Tree(int val) {
            this.val = val;
            this.height = 0;
            this.left = null;
            this.right = null;
        }
    }

    public void run() {
        int maxHeight = 0;
        boolean balanced = true;
        createTree();
        List<Tree> leafNodes = new LinkedList<Tree>();
        leafNodes = getLeafNodes(n1, leafNodes);
        maxHeight = leafNodes.get(0).height;
        for (Tree t : leafNodes) {
           // if (maxHeight >= t.height + 2 || maxHeight + 2 <= t.height) {
            if (Math.max(maxHeight, t.height) - Math.min(maxHeight, t.height) >= 2) {
                balanced = false;
                break;
            } else {
                maxHeight = Math.max(maxHeight, t.height);
            }
        }
        if (balanced) {
            System.out.println("balanced");
        } else {
            System.out.println("un balanced");
        }

    }

    private List<Tree> getLeafNodes(Tree root, List<Tree> leafNodes) {
        if (root == null) {
            return null;
        } else {
            Tree left = root.left;
            if (left != null) {
                left.height = root.height + 1;
                getLeafNodes(left, leafNodes);
            }
            Tree right = root.right;
            if (right != null) {
                right.height = root.height + 1;
                getLeafNodes(right, leafNodes);
            }
            if (left == null && right == null) {
                leafNodes.add(root);
            }
            return leafNodes;
        }
    }

    private void createTree() {
        n1 = new Tree(1); n2 = new Tree(2); n3 = new Tree(3); n4 = new Tree(4); n5 = new Tree(5);
        n6 = new Tree(6); n7 = new Tree(7);
        n8 = new Tree(8); n9 = new Tree(9); n10 = new Tree(10);
        n11 = new Tree(11); n12 = new Tree(12);
        n1.left = n2; n1.right = n3;
        n2.left = n4; n2.right = n5;
        n4.left = n6; n4.right = n7;
        n3.left = n8; n3.right = n8;
    }
}
