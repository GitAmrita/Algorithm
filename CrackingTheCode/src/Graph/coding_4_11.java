package Graph;

import java.util.Random;

/**
 * Created by amritachowdhury on 5/19/17.
 */
public class coding_4_11 {

    public class BinarySearchTree {
        Node root;

        public BinarySearchTree() {
            this.root = null;
        }

        public class Node {
            int val;
            Node left;
            Node right;
            int size;

            public Node(int val) {
                this.val = val; this.size = 1;
            }
        }

        public void insert(int key) {
            root = insertRec(root, key);
        }

        private Node insertRec(Node root, int data) {
            if ( root == null ) {
                root = new Node(data);
            } else {
                root.size ++;
                if (data <= root.val) {
                    root.left = insertRec(root.left, data);
                } else {
                    root.right =  insertRec(root.right, data);
                }
            }
            return root;
        }

        public void inOrderTraversal() {
            inOrderRec(root);
        }

        private void inOrderRec(Node node) {
            if (node != null) {
                inOrderRec(node.left);
                System.out.println(node.val + " : " + node.size);
                inOrderRec(node.right);
            }
        }

        
    }

    private void buildTree() {
        BinarySearchTree b = new BinarySearchTree();
        b.insert(20);
        b.insert(10);
        b.insert(30);
        b.insert(40);
        b.inOrderTraversal();
    }


    public void run() {
        buildTree();
    }
}
