/**
 * Created by achowdhury on 7/16/2015.
 */
public class CommonValSubTree {
    public class Node {
        public int val;
        public Node left;
        public Node right;
        public Node(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
        public Node(int val, Node left, Node right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public class cvstObj {
        public boolean isCVST ;
        public int count ;
        public cvstObj(boolean iscvst, int val){isCVST = iscvst; count = val;}
    }
    public Node root = null;
    public void CreateTree(){
        //right sub tree
        Node a3 = new Node(3);
        Node a31 = new Node(3);
        Node a32 = new Node(3);
        Node a33 = new Node(3,a31,a32);
        Node a34 = new Node(3,a3,null);
        Node a35 = new Node(3,a33,a34);

        //left sub tree
        Node b4 = new Node(4);
        Node b5 = new Node(5);
        Node b2 = new Node(2,b4,b5);

        //root
        root = new Node(1,b2,a35);
    }
    public cvstObj CountCVST(Node root){
        System.out.println(root.val);
        cvstObj cvstL = null;
        cvstObj cvstR = null;
        //leaf node is always a CVST and plus 1 to the count
        if(root.left == null && root.right == null){
            return new cvstObj(true,1);
        }
        //only right child
        if(root.left == null)
            cvstL = new cvstObj(true,0);
         else cvstL= CountCVST(root.left);
        if(root.right == null)
            cvstR = new cvstObj(true,0);

        else cvstR= CountCVST(root.right);
        if(cvstL.isCVST && cvstR.isCVST){
            //root node is also a cvst
            if(root.left != null && root.right != null && root.left.val == root.right.val && root.left.val == root.val)
                return new cvstObj(true, cvstL.count + cvstR.count + 1);
            else if (root.left == null && root.right != null &&  root.right.val == root.val)
                return new cvstObj(true, cvstR.count + 1);
            else if (root.left != null && root.right == null &&  root.left.val == root.val)
                return new cvstObj(true, cvstL.count  + 1);
            else return new cvstObj(false, cvstL.count + cvstR.count);
        }
        else return new cvstObj(false, cvstL.count + cvstR.count);
    }

    public void StartFromHere(){
        CreateTree();
        cvstObj result =CountCVST(root);
        System.out.println(result.count);
    }
}
