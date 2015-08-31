import java.util.*;
import java.util.LinkedList;

/**
 * Created by achowdhury on 6/21/2015.
 */
/*
* matrix of 1's and 0's is given where 0 = water and 1=land. Find the number of ponds in the array .
* Also how can you make one big pond*/
public class PondProblem {
    public class Node{
        public int row;
        public Node(int i){
            row = i;
        }
    }

    public class Vertex{
        public List<Node> edges;
        public Boolean thisExplored;

        public Vertex(List<Node> edge){edges=edge; thisExplored = false;}
    }

    public int[][] adjMatrix = new int[][]{
            {0,1,1,1,0,0,0,0},{1,0,0,0,1,1,0,0},{1,0,0,0,0,0,1,0},{1,0,0,0,0,0,0,1},{0,1,0,0,0,0,0,1},{0,1,0,0,0,0,0,1},{0,0,1,0,0,0,0,1},{0,0,0,1,1,1,1,0}
    };

    public Map<Integer, Vertex> graph = new HashMap<Integer, Vertex>();

    public void CreateGraphFromMatrix(){
       for(int i = 0; i < adjMatrix.length; i++) {
           List<Node> edges = new LinkedList<Node>();
           for(int j = i; j < adjMatrix[i].length; j++){
               if(adjMatrix[i][j] == 0 && i != j){
                   edges.add(new Node(j));
               }
           }
           graph.put(i,new Vertex(edges));
       }
    }

    public void BFS(int nodeVal){
        java.util.Queue<Integer> q = new LinkedList<Integer>();
        q.add(nodeVal);
        while( ! q.isEmpty()){
            int key = q.poll();
            Vertex v = graph.get(key);
            v.thisExplored = true;
            for(Node e : v.edges){
                if(! graph.get(e.row).thisExplored){
                    q.add(e.row);
                }
            }
        }
    }

    public void CallPond() {
        CreateGraphFromMatrix();
        List<Integer> disjointVertices = new ArrayList<Integer>();
        int connectedComponentsCount = 0;
        Iterator<Map.Entry<Integer, Vertex>> iter = graph.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<Integer, Vertex> entry = iter.next();
            int node = entry.getKey();
            Vertex edgeList = entry.getValue();
            if (!edgeList.thisExplored) {
                disjointVertices.add(node);//required since the question asked for making one big pond
                edgeList.thisExplored = true;
                connectedComponentsCount++;
                BFS(node);
            }
        }
        //in adj matrix the upper and lower
        //half of the diagonal are identical, so while making the adj list we consider the upper half. We
        //can consider the lower too. Hence no of ponds= connected components * 2

        System.out.println("there are " + connectedComponentsCount * 2 + " ponds");
        System.out.print("connect the vertices ");
        for(int i : disjointVertices){
            System.out.println(i);
        }
    }
}
