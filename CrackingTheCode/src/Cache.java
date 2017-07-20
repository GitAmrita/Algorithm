import java.util.HashMap;

/**
 * Created by amritachowdhury on 6/29/17.
 */
public class Cache {

    public class LeastRecentlyUsedCache {
        private DoubleLinkedList list;
        private HashMap<Integer, Node> map;
        private int CACHE_SIZE;

        public LeastRecentlyUsedCache(int cacheSize) {
            this.list = new DoubleLinkedList();
            this.map = new HashMap<>();
            this.CACHE_SIZE = cacheSize;
        }

        public boolean isCacheFull() {
            return list.totalNodes == CACHE_SIZE;
        }

        public void put(int data) {
            Node node = new Node(data);
            if (isCacheFull()) {
               Node removedNode =  list.removeFront();
               map.remove(removedNode.data);
            }
            list.insertAtEnd(node);
            map.put(data, node);
        }

        public Integer get(int data) {
            if (map.get(data) == null) {
                return null;
            }
            Node node = map.get(data);
            list.deleteNode(node);
            list.insertAtEnd(node);
            return data;
        }

    }

    private class Node {
        int data;
        Node next;
        Node prev;

        public Node (int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public class DoubleLinkedList {
        Node head; Node tail; int totalNodes;

        public Node removeFront() {
            Node removedNode = head;
            head = head.next;
            head.prev = null;
            this.totalNodes --;
            return removedNode;
        }

        public void insertAtEnd(Node node) {
            if (tail != null) {
                tail.next = node;
                node.prev = tail;
                tail = node;
                node.next = null;
            } else {
                tail = node;
                head = tail;
                node.next = null;
            }
            this.totalNodes ++;
        }

        public void deleteNode(Node node) {
            if (node.next == null) {
                this.tail = node.prev;
            }
            if (node.prev == null) {
                this.removeFront();
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
                this.totalNodes --;
            }
        }
    }

    public void run() {

        LeastRecentlyUsedCache lru = new LeastRecentlyUsedCache(3);
        lru.put(1); lru.put(2); lru.put(3);
        getData(2, lru);
        lru.put(4);
        getData(1, lru);
    }

    private void getData(int dataNo, LeastRecentlyUsedCache lru) {
        Integer data = lru.get(dataNo);
        String output = data == null ? "Cache miss" : String.valueOf(data);
        System.out.println(output);
    }
}
