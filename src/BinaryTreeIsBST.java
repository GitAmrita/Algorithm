/**
 * Created by achowdhury on 7/26/2015.
 */
public class BinaryTreeIsBST {

    public class Node{
        public int value;
        public Node left;
        public Node right;
        public Node(int v, Node l, Node r){value = v; left = l; right = r;}
    }
    public Node root ;
    public boolean IsBST(Node root) {
        boolean bstL, bstR;
        if (root.left == null && root.right == null)
            return true;
        if (root.left == null) {
            if (root.right.value > root.value)
                return true;
            else
                return false;
        } else
            bstL = IsBST(root.left);
        if (root.right == null) {
            if (root.left.value < root.value)
                return true;
            else
                return false;
        } else
            bstR = IsBST(root.right);
        if(bstL && bstR){
            if(root.left != null && root.right != null)
                return root.left.value < root.value && root.right.value > root.value;
            else if(root.left == null && root.right != null)
                return root.right.value > root.value;
            else if(root.left != null && root.right == null)
                return root.left.value < root.value ;
            else return true;
        }
        else return false;
    }
    public void CreateTree(){
        Node n10 = new Node(10,null,null);
        Node n13 = new Node(13,null,null);
        Node n18 = new Node(18,null,null);
        Node n21 = new Node(21,null,null);
        Node n28 = new Node(28,null,null);
        Node n12 = new Node(12,n10,n13);
        Node n15 = new Node(15,n12,n18);
        Node n25 = new Node(25,n21,n28);
        root = new Node(20,n15,n25);
    }
    public void Start(){
        CreateTree();
        boolean result =  IsBST(root);
        System.out.println(result);
    }
}

