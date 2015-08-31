/**
 * Created by achowdhury on 7/17/2015.
 */
//find the depth at which target is found --OOyala
public class DFSTree {
    public class Node{
        int val;
        Node left;
        Node right;
        int depth;
        public Node(int v, Node l, Node r){val = v; left=l; right=r; depth = 0;}
    }
    public Node root;
    public int target = 2;
    public int targetDepth = -1;
    public void  FindDepth(Node n){
            if(n.val == target){
                targetDepth = n.depth;
                return;
            }
            else {
                if(n.left != null){
                    n.left.depth=n.depth + 1;
                    FindDepth(n.left);
                }
                if(n.right != null){
                    n.right.depth=n.depth + 1;
                    FindDepth(n.right);
                }
            }
    }
    public void CreateTree(){
        Node a5 = new Node(5,null,null);
        Node a6 = new Node(6,null,null);
        Node a8 = new Node(8,null,null);
        Node a9 = new Node(9,null,null);
        Node a4 = new Node(4,null,a8);
        Node a7 = new Node(7,a9,null);
        Node a2 = new Node(2,a4,a5);
        Node a3 = new Node(3,a6,a7);
        Node a1 = new Node(1,a2,a3);
        root = a1;
    }
    public void FindTargetDepth(){
        CreateTree();
        FindDepth(root);
        System.out.println(targetDepth);
    }
}
