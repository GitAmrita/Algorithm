import java.util.*;

/**
 * Created by achowdhury on 6/24/2015.
 */
public class TopologicalSort {
    public class Edge{
        public List<Integer> values;
        public boolean visited ;

        public Edge(){values = new java.util.LinkedList<Integer>(); visited = false;}


        public Edge(List<Integer> val){values = val; visited = false;}
    }

    public Map<Integer, Edge> graph = new HashMap<Integer, Edge>();
    public Stack<Integer> s = new Stack<Integer>();

    public void CreateGraph(){
        List<Integer> nos = new java.util.LinkedList<Integer>();
        List<Integer> nos1 = new java.util.LinkedList<Integer>();
        List<Integer> nos2 = new java.util.LinkedList<Integer>();
        List<Integer> nos3 = new java.util.LinkedList<Integer>();
        nos.add(2);
        nos.add(0);
        graph.put(5,new Edge(nos));
        nos1.add(3);
        graph.put(2,new Edge(nos1));
        nos2.add(1);
        graph.put(3,new Edge(nos2));
        nos3.add(1);
        nos3.add(0);
        graph.put(4,new Edge(nos3));
        graph.put(0,new Edge());
        graph.put(1,new Edge());
    }

    public void TopologicalSort(){
        CreateGraph();
        Iterator<Map.Entry<Integer,Edge>> iter = graph.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry<Integer,Edge> entry = iter.next();
            int key = entry.getKey();
            Edge e = entry.getValue();
            if( !e.visited){
                e.visited = true;
                CallDFS(key);
            }
        }
        PrintTopologicalSort();
    }

    public void CallDFS(int node){
        Edge e = graph.get(node);
        for(Integer p : e.values){
            if( ! graph.get(p).visited){
                graph.get(p).visited = true;
                CallDFS(p);
            }
        }
        s.add(node);
        return ;
    }

    public void PrintTopologicalSort(){
        while( !s.empty()){
            System.out.println(s.pop());
        }
    }
}
