package ModerateProblems;

import java.util.HashMap;

/**
 * Created by amritachowdhury on 7/5/17.
 */
public class coding_16_25 {
    public class People {
        int id; String name;
        public People (int id, String name) {
            this.id = id; this.name = name;
        }
    }

    public class Cache {
        public class DoublyLinkedList {
            public class Node {
                People data; Node next; Node prev;
                public Node (People people) {
                    this.data = people;
                    this.next = null;
                    this.prev = null;
                }
            }
            Node head; Node tail; int totalNodes;

            public DoublyLinkedList() {
                this.head = null;
                this.tail = null;
                this.totalNodes = 0;
            }

            public Node addNodeToEnd(People people) {
                Node n = new Node(people);
                if (head == null && tail == null) {// first node ever
                    head = n;
                    tail = head;
                } else {
                    tail.next = n;
                    n.prev = tail;
                    tail = tail.next;
                }
                this.totalNodes++;
                return n;
            }

            public void placeNodeAtTheEndOfList(Node n) {
                if (head == n) {
                    head = n.next;
                }
                if (n.prev != null) {
                    n.prev.next = n.next;
                }
                n.next.prev = n.prev;
                tail.next = n;
                n.prev = tail;
                tail = tail.next;
            }

            public People removeNodeFromFront() {
                Node removedNode = head;
                head = head.next;
                head.prev = null;
                this.totalNodes --;
                return removedNode.data;
            }
        }

        DoublyLinkedList list; HashMap<Integer, DoublyLinkedList.Node> map; int cacheSize;

        public Cache(int cacheSize) {
            this.list = new DoublyLinkedList();
            this.map = new HashMap<>();
            this.cacheSize = cacheSize;
        }

        public boolean isCacheFull() {
            return this.cacheSize == list.totalNodes;
        }

        public void insertInCache(People people) {
            if (isCacheFull()) {
                People removed = list.removeNodeFromFront();
                map.remove(removed.id);

            }
            DoublyLinkedList.Node n = list.addNodeToEnd(people);
            map.put(people.id, n);
        }

        public People getFromCache(int peopleId) {
            DoublyLinkedList.Node n = map.get(peopleId);
            if (n == null) {
                return null;
            }
            list.placeNodeAtTheEndOfList(n);
            return n.data;

        }

    }

    public void run() {
        Cache cache = new Cache(3);
        People p1 = new People(1, "Amrita");
        People p2 = new People(2, "Manoj");
        People p3 = new People(3, "Mita");
        People p4 = new People(4, "Sekhar");
        cache.insertInCache(p1);
        cache.insertInCache(p2);
        cache.insertInCache(p3);
        getFromCache(cache, 1);
        cache.insertInCache(p4);
        getFromCache(cache, 1);
        getFromCache(cache, 2);
    }

    private void getFromCache(Cache cache, int id) {
        People p = cache.getFromCache(id);
        if (p == null) {
            System.out.println("Cache Miss");
        } else {
            System.out.println(p.name);
        }
    }

}
