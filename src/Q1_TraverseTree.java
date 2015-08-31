import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by achowdhury on 6/6/2015.
 */

/*  QUESTION :
          1
    /          \
       3        5
  /        \    \
    2       4    7
 /   \      \
 9    6     8

    translate to
    1
    35
    247
    968
    */
public class Q1_TraverseTree {

    public class Node{
        public int val ;
        public Node right;
        public Node left ;

        public Node(int value){val = value; right = null; left = null;}
    }

    public void PrintPatternQueue(){
        StringBuilder line = new StringBuilder();
        Queue<Node> tree = new LinkedList<Node>();
        tree.add(CreateTree());
        while(!tree.isEmpty()){
            Node parent = tree.remove();
            line.append(parent.val);
            if(parent.left != null)
                tree.add(parent.left);
            if(parent.right != null)
                tree.add(parent.right);
            System.out.println(parent.val);
            line.setLength(0);
        }
    }

   /*  using linkedlist
   public void PrintPattern(){

        Node startNode = CreateTree();
        List<Node> tree = new LinkedList<Node>();
        tree.add(startNode);
        int i = 0;
        Node parent = null;
        Node childL = null;
        Node childR = null;
        System.out.println(tree.get(0).val);
        while(true){
            parent = tree.get(i) ;
            tree.remove(parent) ;
            if(parent.left != null){
                childL = parent.left;
                tree.add(childL);
                System.out.print(childL.val);
            }
            if(parent.right != null){
                childR = parent.right;
                tree.add(childR);
                System.out.print(childR.val);
            }
            if(tree.isEmpty()){
                break;
            }
        }
    }*/

    public Node CreateTree(){
        Node n1 = new Node(1);
        Node n3 = new Node(3);
        Node n5 = new Node(5);
        Node n2 = new Node(2);
        Node n4 = new Node(4);
        Node n7 = new Node(7);
        Node n9 = new Node(9);
        Node n6 = new Node(6);
        Node n8 = new Node(8);
        n1.left=n3;
        n1.right=n5;
        n3.left=n2;
        n3.right=n4;
        n5.right=n7;
        n2.left=n9;
        n2.right=n6;
        n4.right=n8;
        return n1;
    }

}
