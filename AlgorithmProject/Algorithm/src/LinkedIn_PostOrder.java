import java.util.*;
import java.util.LinkedList;

/**
 * Created by achowdhury on 7/9/2015.
 */
//http://www.careercup.com/question?id=6266917077647360
public class LinkedIn_PostOrder {
    public class Node{
        public int value;
        public Node left ;
        public Node right ;

        public Node(int n){value = n; left = null; right = null;}
        public Node(){value = 0; left = null; right = null;}
    }
    public Node root;
    public Node invertedRoot = null;
    public java.util.Queue<Integer> outputQueue = new LinkedList<Integer>();
    public void PostOrder(Node root){
        if(root == null)
            return ;
        PostOrder(root.left);
        PostOrder(root.right);
        outputQueue.add(root.value);
    }
    public void AddNode(int n){
        Node p = new Node(n);
      if(invertedRoot == null){
          invertedRoot = p;
          return;
      }
        Node temp = invertedRoot;
        while(temp != null){
            if(temp.left == null){temp.left = p; break;}
            else if(temp.right == null){temp.right = p;break;}
            else
                temp = temp.right ;
        }
      }

    public void createTree(){
        Node n1 =new Node(1);
        Node n2 =new Node(2);
        Node n3 =new Node(3);
        Node n4 =new Node(4);
        Node n5 =new Node(5);
        Node n6 =new Node(6);
        Node n7 =new Node(7);
        n4.left = n6;
        n4.right = n7;
        n2.left = n4;
        n2.right =n5;
        n1.left = n2;
        n1.right = n3;
        root = n1;
    }
    public void testPostOrder(){
        createTree();
        PostOrder(root);
        while(! outputQueue.isEmpty()){
            AddNode(outputQueue.poll());
        }
        Node temp =invertedRoot;
        while( temp != null){
            int left = temp.left == null ? -99 : temp.left.value;
            int right = temp.right == null ? -99 : temp.right.value;
            System.out.println(temp.value + "->" + left + "," + right);
            if(right != -99)
                temp = temp.right;
            else
                break;
        }
    }
}
