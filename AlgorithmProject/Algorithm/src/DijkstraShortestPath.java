import sun.util.resources.cldr.sah.LocaleNames_sah;

import java.util.*;

/**
 * Created by achowdhury on 6/3/2015.
 */
public class DijkstraShortestPath {
    public static int max_val = 2000;
    public Map<Integer, Vertex> graph = new HashMap<Integer,Vertex>();
    //initially all nodes except the start node is here. nodes get removed as we find their shortest path
    List<Explored> unExplored = new ArrayList<Explored>();
    //initially only the start node is here. nodes whose shortest path is found are added
    List<Explored> explored = new ArrayList<Explored>();
    //this is the map that keeps track of the traversed paths. Map<destinationNode, parentNode>
    public Map<Integer,Integer> traversal = new HashMap<Integer, Integer>();

    public class Edge{
        int destNode ;
        int edgeLen ;

        public Edge(int node, int len){
            destNode = node ;
            edgeLen = len ;
        }
    }

    public class Vertex{
        public List<Edge> edges;
        public int shortestPath;

        public Vertex(List<Edge> e){
            edges = e;
            shortestPath = max_val;
        }
        //this is just for the starting node where visit = true and leaf node where visit = false
        public Vertex(List<Edge> e, int path, Boolean visit){
            edges = e;
            shortestPath = path;
        }
    }

    public class Explored{
        public int destNode ;
        public int destLocalShortest ;

        public Explored(int node, int path){
            destNode = node;
            destLocalShortest = path;
            }
    }

    //compares the localShortestPath in the explored list
    class PathComparator implements Comparator<Explored> {
        @Override
        public int compare(Explored a, Explored b) {
            return a.destLocalShortest < b.destLocalShortest ? -1 : a.destLocalShortest == b.destLocalShortest ? 0 : 1;
        }
    }


    public void ComputeShortest(){
        graph = CreateGraph() ;
        InitializeExplored();
        InitializeUnexplored();
        //contains the node with the min len at that point from all the available nodes in unexplored
        Explored minLen = explored.get(0);
        //initialize with start node which is a self loop
        traversal.put(1,1);
        //keep on looping until all the nodes are explored
        while(explored.size() != graph.size()){
            Vertex v =graph.get(minLen.destNode);
            for(Edge e : v.edges){
                //update the len in unexplored only if the new length < old length
                UpdateUnExplored(e.destNode,e.edgeLen,v.shortestPath,minLen.destNode);
            }
            //find the smallest path among the unexplored
            minLen = FindMinUnexplored();
            //move to explored and move out of unexplored
            explored.add(minLen);
            unExplored.remove(minLen);
            //update graph with shortest path
            graph.get(minLen.destNode).shortestPath = minLen.destLocalShortest ;
        }
        //print the shortest path dist for each node from the start node
        DisplayShortestPath();
        //print the actual path for each node from the start node
        for(Explored m : explored){
            DisplayTraversal(m.destNode);
        }

    }
    public Explored FindMinUnexplored(){
        Collections.sort(unExplored, new PathComparator());
        return unExplored.get(0);
    }

    public void UpdateUnExplored(int node, int len, int path, int parentNode){
        for(Explored updateNode : unExplored){
            if(updateNode.destNode == node){
                if(updateNode.destLocalShortest > len + path){
                    updateNode.destLocalShortest = len + path ;
                    traversal.put(node,parentNode);
                }
                break ;
            }
        }
    }

    public void InitializeExplored(){
        explored.add(new Explored(1,0));
    }

    public void InitializeUnexplored(){
        unExplored.add(new Explored(2,max_val));
        unExplored.add(new Explored(3,max_val));
        unExplored.add(new Explored(4,max_val));
        unExplored.add(new Explored(5,max_val));
        unExplored.add(new Explored(6,max_val));
        unExplored.add(new Explored(7,max_val));
    }

    public Map<Integer, Vertex> CreateGraph(){
        graph.put(1,new Vertex(Arrays.asList(new Edge(2,1)), 0, true));
        graph.put(2,new Vertex(Arrays.asList(new Edge(3,2), new Edge(4,4))));
        graph.put(3,new Vertex(Arrays.asList(new Edge(4,1), new Edge(7,5))));
        graph.put(4,new Vertex(Arrays.asList(new Edge(5,2), new Edge(6,2))));
        graph.put(5,new Vertex(Arrays.asList(new Edge(2,1), new Edge(7,4))));
        graph.put(6,new Vertex(Arrays.asList(new Edge(7,1))));
        graph.put(7,new Vertex(null, max_val, false));//this is leaf node which has infinity shortestPath
        return graph;
    }

    public void DisplayShortestPath(){
        for(Explored e : explored){
            System.out.println("Node " + e.destNode + " ShortestDist " + e.destLocalShortest);
        }
    }

    public void DisplayTraversal(int node){
        int startNode = 1;
        int i = 1;
        while(i != traversal.size()){
            System.out.print(node + "-> ");
            node =traversal.get(node);
            if(node == startNode){
                System.out.print("1");
                break;
            }
            i++;
        }
        System.out.println();
    }
}
