import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by achowdhury on 7/12/2015.
 */
public class DFSAndBFS {
    public class Edges{
        public List<Integer> vertices;
        public Boolean visited;

        public Edges(List<Integer> vertices){this.vertices = vertices; this.visited = false;}
    }
    Map<Integer, Edges> graph = new HashMap<Integer, Edges>();

    public void CreateGraph(){
        List<Integer> adj1= new LinkedList<Integer>();
        adj1.add(2);
        adj1.add(7);
        adj1.add(8);
        graph.put(1,new Edges(adj1));
        List<Integer> adj2= new LinkedList<Integer>();
        adj2.add(3);
        adj2.add(6);
        graph.put(2,new Edges(adj2));
        List<Integer> adj3= new LinkedList<Integer>();
        adj3.add(4);
        adj3.add(5);
        graph.put(3,new Edges(adj3));
        List<Integer> adj8= new LinkedList<Integer>();
        adj8.add(9);
        adj8.add(12);
        graph.put(8,new Edges(adj8));
        List<Integer> adj9= new LinkedList<Integer>();
        adj9.add(10);
        adj9.add(11);
        graph.put(9,new Edges(adj9));
        //leaf nodes
        graph.put(4,new Edges(new LinkedList<Integer>()));
        graph.put(5,new Edges(new LinkedList<Integer>()));
        graph.put(6,new Edges(new LinkedList<Integer>()));
        graph.put(7,new Edges(new LinkedList<Integer>()));
        graph.put(10,new Edges(new LinkedList<Integer>()));
        graph.put(11,new Edges(new LinkedList<Integer>()));
        graph.put(12,new Edges(new LinkedList<Integer>()));
    }

    public void Print(int val){
        System.out.println(val);
    }

    public void TraverseDFS(int startNode){
        Stack<Integer> st = new Stack<Integer>();
        if(graph.get(startNode) == null){
            System.out.println("bad data");
            return ;
        }
        st.push(startNode);
        graph.get(startNode).visited = true;
        Print(startNode);
        while(! st.isEmpty()){
            int top = st.peek();
            if(graph.get(top).vertices.size() == 0)
                st.pop();
            else{
                List<Integer> edges = graph.get(top).vertices;
                Boolean allEdgesVisited = true;
                for(Integer e : edges){
                    if(! graph.get(e).visited){
                        st.push(e);
                        Print(e);
                        graph.get(e).visited = true;
                        allEdgesVisited = false;
                        break;
                    }
                }
                if(allEdgesVisited)
                    st.pop();
            }
        }
    }

    public void TraverseBFS(int startNode){
        java.util.Queue<Integer> queue = new LinkedList<Integer>() ;
        if(graph.get(startNode) == null){
            System.out.println("bad data");
            return;
        }
        queue.add(startNode);
        graph.get(startNode).visited = true;
        Print(startNode);
        while(! queue.isEmpty()){
            int front = queue.poll();
            List<Integer> edges = graph.get(front).vertices ;
            if(edges.size() == 0)//leaf node
                continue;
            for(Integer e : edges){
                if(! graph.get(e).visited){
                    queue.add(e);
                    graph.get(e).visited = true;
                    Print(e);
                }
            }
        }
    }

    public void TraverseTree(){
        CreateGraph();
        TraverseBFS(1);
        System.out.println("**************************");
       // TraverseDFS(1);
    }
}
