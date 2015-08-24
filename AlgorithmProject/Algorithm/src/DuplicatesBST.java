/**
 * Created by achowdhury on 8/3/2015.
 */
//http://www.geeksforgeeks.org/how-to-handle-duplicates-in-binary-search-tree/
public class DuplicatesBST {

    public class Node{
        public int value;
        public Node left;
        public Node right;
        public int count;

        public Node(int val){
            value = val; left = null; right = null; count = 1;
        }
    }
    public Node root = null ;

    //this is the non recursive method
    public void InsertNode(int key){
        boolean isRightChild = false;
        boolean isDuplicate = false;
        if(root == null){
            root = new Node(key);
            return;
        }
        Node temp = root;
        while(true){
            if(temp.value == key){
                isDuplicate = true ;
                break;
            }
            if(temp.value > key){
                if(temp.left == null){
                    break;
                }
                temp = temp.left ;
            }
            if(temp.value < key){
                if(temp.right == null){
                    isRightChild = true;
                    break;
                }
                temp = temp.right ;
            }
        }
        if( !isDuplicate && isRightChild)
            temp.right = new Node(key);
        else if(!isDuplicate && !isRightChild)
            temp.left = new Node(key);
        else
            temp.count = temp.count + 1;
    }
    public void Insert(int key) {
        if(root == null){
            root = new Node(key);
            return;
        }
        root = InsertRecurse(root, key);
    }

    public Node InsertRecurse(Node node,int key){
        if(node == null)
            node = new Node(key);
        else if(node.value == key)
            node.count ++ ;
        else if(node.value < key)
            node.right = InsertRecurse(node.right, key);
        else
            node.left = InsertRecurse(node.left, key);
        return node;
    }

    public void InOrder(Node node){
        if(node != null){
            InOrder(node.left);
            System.out.println("key " + node.value  + " frequency " + node.count);
            InOrder(node.right);
        }
    }

    public Node FindMin(Node node){
        while(node.left != null)
            node = node.left ;
        return node;
    }

    public Node DeleteNode(Node node, int key){
        if(node == null)
            return null;
        else if(node.value < key)
            node.right = DeleteNode(node.right, key);
        else if(node.value > key )
            node.left = DeleteNode(node.left, key);
        else{
            if(node.count > 1)
                node.count -- ;
            else{
                if(node.left == null && node.right == null)
                    node = null;
                else if(node.left == null){
                    node.value = node.right.value;
                    node.right = null;
                }
                else if(node.right == null){
                    node.value = node.left.value;
                    node.left = null;
                }
                else{
                    Node temp = FindMin(node.right);
                    node.value = temp.value ;
                    node.right = DeleteNode(node.right, temp.value);
                }
            }
        }
        return node;
    }

    public void CreateTree(){
        int[] arr = new int[]{12,10, 20, 9, 11, 10, 12, 12};
        for(int i : arr)
               Insert(i);
        InOrder(root);
        root = DeleteNode(root, 20);
        root = DeleteNode(root, 9);
        root = DeleteNode(root, 12);
        root = DeleteNode(root, 12);
        root = DeleteNode(root, 12);
        InOrder(root);
    }
}
