/**
 * Created by achowdhury on 7/18/2015.
 */
public class SumOfAllPaths {
    public class Node{
        int val;
        Node left;
        Node right;
        public Node(int v, Node l, Node r){val = v; left=l; right=r;}
    }
    public Node root;

    public int FindPathSum(Node root){
        if(root == null)
            return 0;
        int left = FindPathSum(root.left);
        int right = FindPathSum(root.right);
        return (root.val + left + right);
    }
    public void CreateTree(){
        Node a3 = new Node(3,null,null);
        Node a20 = new Node(20,null,null);
        Node a5 = new Node(5,a3,null);
        Node a15 = new Node(15,null,a20);
        root = new Node(10,a5,a15);
    }
    public void StartHere(){
        CreateTree();
        int sum = FindPathSum(root);
        System.out.println(sum);
    }
}
