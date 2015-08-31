/**
 * Created by achowdhury on 6/14/2015.
 */
public class HashImplementation {
    public class Node{
        public int data;
        public Node next;

        public Node(int value){data=value; next = null;}
    }

    public Node[] table = new Node[10];

    public int HashFn(int val){
        return val % 10;
    }

    public void InsertValue(int val){
        int hashed = HashFn(val);
        Node n = new Node(val);
        if(table[hashed] == null){//there is no collision yet
            table[hashed] = n;
        }
        else{// perform chaining mechanism for collision resolution
            Node existingNode = table[hashed];
            n.next = existingNode;
            table[hashed] = n;
        }
    }

    public void FindTarget(int target){
        Boolean found = false;
        int hashed = HashFn(target);
        Node targetNode=table[hashed];
        if(targetNode == null){
            System.out.println("target not found");
            return;
        }
        while(targetNode != null){
            if(targetNode.data == target){
                System.out.println("target found");
                found = true ;
                break;
            }
            targetNode = targetNode.next ;
        }
        if(!found)
            System.out.println("target not found");
        return;
    }

    public void CallHash(){
        InsertValue(12);
        InsertValue(2);
        InsertValue(10);
        InsertValue(5);
        InsertValue(8);
        InsertValue(18);
        FindTarget(2);
        FindTarget(12);
        FindTarget(7);
    }
}
