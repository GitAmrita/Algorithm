import java.util.*;

/**
 * Created by achowdhury on 5/29/2015.
 */
public class ShortestPathBFS {
    public class Vertex{
        public int node;
        public boolean explored;
        public int level;

        public Vertex(){}

        public  Vertex(int val){
            node = val;
            explored = false ;
            level = 0;
        }
    }
    Map<Vertex, List<Vertex>> graph  ;
    java.util.Queue<Vertex> tempQ=new java.util.LinkedList<Vertex>();


    public  void CallBFS()
    {
        ShortestPathBFS bfs = new ShortestPathBFS();
        bfs.ComputeBFS(2);
    }

    public void ComputeBFS(int search)
    {
        graph = CreateGraph();
        MarkExplored(new Vertex(1),-1);
        while(!tempQ.isEmpty())
        {
            Vertex node = tempQ.remove();
            if(node.node == search)
            {
                System.out.println("Shortest path is :" + node.level);
                return;
            }
            List<Vertex> edges = graph.get(node);
            for(Vertex e : edges){
                if( !e.explored)
                    MarkExplored(e,node.level);
            }
        }
        System.out.println("Search term could not be found");
    }

    public void MarkExplored(Vertex key, int level)
    {
        Iterator<Map.Entry<Vertex,List<Vertex>>> iter = graph.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<Vertex,List<Vertex>> entry = iter.next();
            List<Vertex>edges = entry.getValue();
            List<Vertex> newEdge = new ArrayList<Vertex> ();
            //mark the other edges that contain the node as explored
            if(entry.getKey().node != key.node){
                for(Vertex v : edges){
                    if(v.node == key.node){
                        v.explored = true;
                        v.level = level + 1;
                    }
                    newEdge.add(v);
                }
                graph.put(entry.getKey(),newEdge);
            }
            //make the node explored
            else{
                entry.getKey().explored = true;
                entry.getKey().level = level + 1;
                key.explored = true;
                key.level = level + 1;
                tempQ.add(entry.getKey());
            }
            }
        }

    public Map<Vertex, List<Vertex>> CreateGraph()
    {
        Map<Vertex,List<Vertex>> map = new HashMap<Vertex, List<Vertex>>(){{
            put(new Vertex(1), Arrays.asList(new Vertex(2), new Vertex(3)));
            put(new Vertex(2), Arrays.asList(new Vertex(1), new Vertex(4)));
            put(new Vertex(3), Arrays.asList(new Vertex(1), new Vertex(4), new Vertex(5)));
            put(new Vertex(4), Arrays.asList(new Vertex(3), new Vertex(6), new Vertex(5)));
            put(new Vertex(5), Arrays.asList(new Vertex(3), new Vertex(4), new Vertex(6)));
            put(new Vertex(6), Arrays.asList(new Vertex(5), new Vertex(4)));
        }};
        return map;
    }
    }


