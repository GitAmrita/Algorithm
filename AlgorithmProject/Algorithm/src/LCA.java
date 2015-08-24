import java.util.*;
import java.util.LinkedList;

/**
 * Created by achowdhury on 6/7/2015.
 */
//LCA = Lowest Common Ancestor
public class LCA {
    public class Node{
        public String value;
        public Node left ;
        public Node right ;

        public Node(String val){
            value=val;
            left = null;
            right = null;
        }
    }

    List<Node> tree = new LinkedList<Node>();

    public void  LowestCommonAncestor(){
        tree.add(CreateTree()) ;
        Node root = tree.get(0);
        Node LCANode =ComputeLCA(root,new Node("e"), new Node("f"));
        System.out.println(LCANode.value);
    }

    public Node ComputeLCA(Node root, Node n1, Node n2){
        if(root == null)
            return root;
        else if(root.value == n1.value || root.value == n2.value )
            return root;
        else {
            Node nodeLeft = ComputeLCA(root.left, n1, n2);
            Node nodeRight = ComputeLCA(root.right, n1, n2);
            if(nodeLeft != null && nodeRight != null)
                return root;
            if(nodeLeft != null)
                return nodeLeft ;
            if(nodeRight != null)
                return nodeRight ;
        }
        return null;
    }

    public  Node CreateTree(){
        Node root = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        Node d = new Node("d");
        Node e = new Node("e");
        Node f = new Node("f");
        Node g = new Node("g");
        Node m = new Node("m");
        d.left  = g;
        d.right = f;
        b.left = d;
        b.right = e;
        c.right = m;
        root.left = b;
        root.right = c;
        return root;
    }
}
