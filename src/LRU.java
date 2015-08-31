import java.util.HashMap;
import java.util.Map;

/**
 * Created by achowdhury on 6/18/2015.
 */
public class LRU {
    public int max_cap = 3;
    public class Node{
        public int key ;
        public int val ;
        public Node prev;
        public Node next;

        public Node (int key, int val){this.key = key; this.val = val; this.prev=null; this.next = null;}
    }
    public class LRUCache{
        Map<Integer, Node> map;
        int capacity ;
        public Node head ;
        public Node end ;

        public LRUCache(){this.map = new HashMap<Integer, Node>(); this.capacity = 0; head = null; end = null;}

        public void SetNode(int key, int value){
            Node n = new Node(key,value);
            //key does not exist
            if(map.get(key)== null){
                map.put(key,n);
            }
            //just update the value at the key
            else {
                map.get(key).val=value;
            }
            //deal with the queuing part
            //this is the first element ever
            if(head == null && end == null){
                head = n;
                end = n;
                capacity ++ ;
                return;
            }
            //the cache isn't full yet
            if(capacity < max_cap){
                n.next = head ;
                head.prev = n;
                head = n;
                capacity ++ ;
                return;
            }
            //cache is full, time to delete the least used
            if(capacity == max_cap){
                //remove the last element in the list which is least used
                end.prev.next = null;
                end = end.prev;
                //add new node to head
                n.next = head ;
                head.prev = n;
                head = n;
            }
        }

        public void GetNode(int key){
            //key does not exist
            if(map.get(key) == null){
                System.out.println("key not found");
                return;
            }
            Node target = map.get(key);
            //since the target is in head itself just print it out, no need of any extra work
            if(head.val == target.val){
                System.out.println("key found " + target.val);
                return;
            }
            //since the target was the least used at the end bring it to the front
            if(end.val == target.val){
                Node moveNode = end;
                end= end.prev;
                end.next = null;
                //move the target node to the front
                moveNode.next = head ;
                head.prev = moveNode;
                head = moveNode ;
                System.out.println("key found " + target.val);
                return;
            }
            //if the target is one of the middle elements bring it to the front
            Node temp = head;
            while(temp != null){
                if(temp.val == target.val){
                    temp.prev = temp.next;
                    temp.next.prev = temp.prev;
                    //move target node to the front
                    temp.next = head ;
                    head.prev = temp;
                    head = temp ;
                    System.out.println("key found " + target.val);
                    return;
                }
            }
        }
    }

    public void TestLRU(){
        LRUCache cache = new LRUCache();
        cache.SetNode(1,1);
        cache.SetNode(2,3);
        cache.SetNode(1,2);
        cache.SetNode(3,4);
        cache.GetNode(3);
        cache.SetNode(5,5);
        cache.SetNode(6,6);
    }
}
