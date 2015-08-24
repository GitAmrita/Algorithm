import java.util.*;
import java.util.LinkedList;

/**
 * Created by achowdhury on 6/21/2015.
 */
public class BST {

    public class  Node{
        public int val;
        public Node left;
        public Node right ;

        public Node(int v){val = v; left = null; right = null;}
    }

    public Node root = null;

    public void Insert(int value){
        Boolean isRightChild = false;
        Node n = new Node(value);
        if(root == null){//this is the first node
            root = n;
            return;
        }
        Node temp = root;
        while(true){
            if(temp.val < value ){
                if(temp.right == null){
                    isRightChild = true ;
                    break;
                }
                temp = temp.right;
            }
            else {
                if(temp.left == null){
                    isRightChild = false;
                    break;
                }
                temp = temp.left;
            }
        }
        if(isRightChild)
            temp.right = n;
        else
            temp.left = n;
        return;
    }

   private void Delete(int value){
       Node parent = root;
       Node temp =root;
       while(temp != null){
           if(temp.val==value){
               if(temp.left == null && temp.right == null){//delete node is the leaf node
                   if( parent.left == temp)
                       parent.left = null;
                   else
                        parent.right = null;
                   Print();
                   break;
               }
               if(temp.left == null || temp.right == null){//delete node has only one child
                  Node copyNode ;
                   if(temp.left == null)
                       copyNode = temp.right ;
                   else
                       copyNode = temp.left ;
                   if( parent.left == temp)
                       parent.left = copyNode;
                   else
                        parent.right = copyNode;
                   Print();
                   break;
               }
               //delete node has two children
               Node replace = temp.right ;
               while(replace.left != null){
                   replace = replace.left ;
               }
               temp.val = replace.val;
               Print();
               break;
           }
           else {
               parent = temp;
               if(temp.val < value)
                   temp = temp.right;
               else temp = temp.left;
           }
       }
   }

    private void FindNode(int value){
        Node temp = root;
        while(temp.val != value){
            if(temp.val > value)
                temp = temp.left ;
            else
                temp = temp.right ;
            if(temp == null){
                System.out.println("value not found");
                break;
            }
        }
        System.out.println("value found");
    }

    public void Print(){
        java.util.Queue<Node> printQ = new java.util.LinkedList<Node>();
        printQ.add(root);
        while(! printQ.isEmpty()){
            Node temp = printQ.poll();
            String leftVal = "" ;
            String rightVal = "" ;
            if(temp.left != null){
                leftVal = Integer.toString(temp.left.val);
                printQ.add(temp.left);
            }
            if(temp.right != null){
                rightVal = Integer.toString(temp.right.val);
                printQ.add(temp.right);
            }
            System.out.println(temp.val + "-> " + leftVal + ", " + rightVal);
        }
    }

    public void BSTOperations(){
        Insert(15);
        Insert(10);
        Insert(20);
        Insert(7);
        Insert(12);
        Insert(17);
        Insert(30);
        Insert(40);
        Insert(21);
        Insert(22);
        FindNode(17);
       // Delete(20);
     //   Delete(21);
      //  Print();
    }
}
