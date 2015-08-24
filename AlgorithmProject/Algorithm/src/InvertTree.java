/**
 * Created by achowdhury on 6/12/2015.
 */
public class InvertTree {
    public class Node{
        public int data;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int value){data=value; left=null;right=null;parent=null;}
    }
    public class BinaryTree{
        public Node root=null;

        public void CreateTree(){
            Node a1 = new Node(1);
            Node a2 = new Node(2);
            Node a3 = new Node(3);
            Node a4 = new Node(4);
            Node a5 = new Node(5);
            Node a6 = new Node(6);
            a1.left = a2;
            a1.right = a3;
            a2.left = a4;
            a2.right = a5;
            a3.right = a6;
            root = a1;
        }

        public Node InvertTree(Node n){
            if(n==null)
                return n;
            if (n.left != null){
              Node leftChild =  InvertTree(n.left);
                leftChild.right = n;
            }
            if (n.right != null){
                Node rightChild =  InvertTree(n.right);
                rightChild.left = n;
            }
            n.left=null;
            n.right=null;
            return n;
        }
    }

    public void CallInvert(){
        BinaryTree bt= new BinaryTree();
        bt.CreateTree();
        Node finalTree =bt.InvertTree(bt.root);
    }
}
