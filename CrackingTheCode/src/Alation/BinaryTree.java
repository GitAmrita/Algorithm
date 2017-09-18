package Alation;

import java.util.List;

/**
 * Created by amritachowdhury on 8/14/17.
 */
//http://www.geeksforgeeks.org/construct-a-binary-tree-from-parent-array-representation/
public class BinaryTree {
    public Node root;

    public class Node {
        public int data;
        public Node left;
        public Node right;

        public Node (int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public Node (int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    void inorder(Node node)
    {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }
    }

    void createNode(int parent[], int i, Node created[])
    {
        // If this node is already created
        if (created[i] != null)
            return;
        // Create a new node and set created[i]
        created[i] = new Node(i);
        // If 'i' is root, change root pointer and return
        if (parent[i] == -1)
        {
            root = created[i];
            return;
        }
        // If parent is not created, then create parent first
        if (created[parent[i]] == null)
            createNode(parent, parent[i], created);
        // Find parent pointer
        Node p = created[parent[i]];
        // If this is first child of parent
        if (p.left == null)
            p.left = created[i];
        else // If second child
            p.right = created[i];
    }

    Node createTree(int parent[], int n)
    {
        // Create an array created[] to keep track
        // of created nodes, initialize all entries
        // as NULL
        Node[] created = new Node[n];
        for (int i = 0; i < n; i++)
            created[i] = null;

        for (int i = 0; i < n; i++)
            createNode(parent, i, created);

        return root;
    }

    public void run() {
        BinaryTree tree = new BinaryTree();
        int parent[] = new int[]{1, 5, 5, 2, 2, -1, 3};
        int n = parent.length;
        Node node = tree.createTree(parent, n);
        System.out.println("Inorder traversal of constructed tree ");
        tree.inorder(node);
    }

}
