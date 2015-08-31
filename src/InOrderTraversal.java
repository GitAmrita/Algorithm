import java.util.Stack;

/**
 * Created by achowdhury on 6/7/2015.
 */

// left -> root -> right
public class InOrderTraversal {
    public class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int val){
            value= val; left = null; right = null;}
    }
    public void TraverseInorder(){
        Node root = CreateTree();
        Stack<Node> store = new Stack<Node>();
        if(root == null)
            return;
        while(! store.isEmpty() || root != null){
            if(root != null){
                store.push(root);
                root=root.left ;
            }
            else{
                root = store.pop();
                System.out.println(root.value);
                root = root.right;
            }
        }
        }

    public Node CreateTree(){
        Node n10 = new Node(10);
        Node n6 = new Node(6);
        Node n3 = new Node(3);
        Node n7 = new Node(7);
        Node n15 = new Node(15);
        Node n11 = new Node(11);
        Node n17 = new Node(17);
        n10.left = n6;
        n10.right = n15;
        n6.left = n3;
        n6.right = n7;
        n15.left = n11;
        n15.right = n17;
        return n10;
    }
}
