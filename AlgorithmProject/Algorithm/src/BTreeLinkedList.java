import java.util.*;
import java.util.LinkedList;

/**
 * Created by achowdhury on 6/11/2015.
 */
public class BTreeLinkedList {
    public int gDepth = 0;
    public class Node{
        public String data;
        public Node left;
        public Node right;
        public int depth;
        public Node next;//since we have to create a resultant linkedlist with the same depth nodes.

        public Node(String val){
            data = val;
            left = null;
            right = null;
            depth= gDepth;
            next = null;
        }
    }
    public class Tree{
        Node root = null ;
        LinkedList<Node> result = new LinkedList<Node>();

        public void CreateTree(){
            Node a=new Node("a");
            Node b=new Node("b");
            Node c=new Node("c");
            Node d=new Node("d");
            Node e=new Node("e");
            Node f=new Node("f");
            Node g=new Node("g");
            Node h=new Node("h");
            Node i=new Node("i");
            Node j=new Node("j");
            d.left=h;
            d.right=i;
            e.left=j;
            b.left = d;
            b.right = e;
            c.left=f;
            c.right = g;
            a.left = b;
            a.right=c;
            root = a;
        }

        public void CreateList(){
            java.util.Queue<Node> q=new java.util.LinkedList<Node>();
            Node temp = root ;
            gDepth ++ ;
            temp.depth = gDepth;
            q.add(temp);
            ResultList(root);
            while(!q.isEmpty()){
                Node head = q.remove();
                if(head.left != null){
                    head.left.depth=head.depth + 1;
                    q.add(head.left);
                    ResultList(head.left);
                }
                if(head.right != null){
                    head.right.depth=head.depth + 1;
                    q.add(head.right);
                    ResultList(head.right);
                }
            }
        }

        public void ResultList(Node n){
            if(result.isEmpty())
                result.add(n);
            else{
                for(Node p : result){
                    if(p.depth == n.depth){
                        while(p.next != null){
                            p=p.next;
                        }
                        p.next = n;
                        return;
                    }
                }
                result.add(n);
            }
        }

        public void DisplayList(){
           for(Node p : result){
               while(p != null)
               {
                   System.out.print(p.data + "->");
                   p=p.next;
               }
               System.out.println();
           }
        }
    }

    public void Start(){
        Tree t = new Tree();
        t.CreateTree();
        t.CreateList();
        t.DisplayList();
    }
}
