import java.util.*;

/**
 * Created by achowdhury on 6/1/2015.
 */
public class TopologicalOrdering {
    public class Vertex{
        public int node;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Vertex vertex = (Vertex) o;

            if (node != vertex.node) return false;

            return true;
        }

        @Override
        public int hashCode() {
            return node;
        }

        public Vertex(int nodeNo){
            node=nodeNo ; }
    }

    public class Edge{
        public List<Vertex> edges ;
        public Boolean exploredVertex ;
        public int exploredLabel;

        public Edge(List<Vertex> edgesIn){
            edges = edgesIn; exploredVertex = false; exploredLabel = 0; }
    }

    public int current_label ;

    public Map<Integer, Edge> graph =new HashMap<Integer, Edge>();

    public Map<Integer, Edge> CreateGraph(){
        List<Vertex> edges1 = new ArrayList<Vertex>();
        edges1.add(new Vertex(2));
        edges1.add(new Vertex(3));
        Edge s1= new Edge(edges1);
        graph.put(1,s1);

        List<Vertex> edges2 = new ArrayList<Vertex>();
        edges2.add(new Vertex(4));
        edges2.add(new Vertex(5));
        Edge s2= new Edge(edges2);
        graph.put(2,s2);

        List<Vertex> edges3 = new ArrayList<Vertex>();
        edges3.add(new Vertex(6));
        Edge s3= new Edge(edges3);
        graph.put(3,s3);

        List<Vertex> edges4 = new ArrayList<Vertex>();
        edges4.add(new Vertex(7));
        edges4.add(new Vertex(8));
        Edge s4= new Edge(edges4);
        graph.put(4,s4);

        //leaf node
        List<Vertex> edges5 = new ArrayList<Vertex>();
        Edge s5= new Edge(edges5);
        graph.put(5,s5);

        List<Vertex> edges6 = new ArrayList<Vertex>();
        Edge s6= new Edge(edges6);
        graph.put(6,s6);

        List<Vertex> edges7 = new ArrayList<Vertex>();
        Edge s7= new Edge(edges7);
        graph.put(7,s7);

        List<Vertex> edges8 = new ArrayList<Vertex>();
        Edge s8= new Edge(edges8);
        graph.put(8,s8);

        return graph;
    }

    public void DFS(int key){
        Edge getEdges= graph.get(key);
        getEdges.exploredVertex = true ;
        for(Vertex v : getEdges.edges){
            if( !graph.get(v.node).exploredVertex)
                DFS(v.node);
        }
        getEdges.exploredLabel = current_label;
        current_label -- ;
    }

    public void DFS_Loop(){
        graph = CreateGraph();
        current_label = graph.size();
        Iterator<Map.Entry<Integer,Edge>> iterator = graph.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer,Edge> entry = iterator.next();
            int key = entry.getKey();
            Edge values=entry.getValue();
            if(! values.exploredVertex)
                DFS(key);
        }
        PrintGraph();
    }

    public void PrintGraph(){
        Iterator<Map.Entry<Integer,Edge>> iterator = graph.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer,Edge> entry = iterator.next();
            int key = entry.getKey();
            Edge values=entry.getValue();
            System.out.println("Vertex : " + key + " Explored : " + values.exploredVertex + " Label : " + values.exploredLabel);
        }
    }
}
