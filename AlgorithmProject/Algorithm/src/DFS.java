import java.util.*;
import java.util.LinkedList;

/**
 * Created by achowdhury on 7/6/2015.
 */
public class DFS {
    public class Edges{
        public List<String> vertices;
        public Boolean visited ;
        public Edges(List<String> v){vertices = v; visited = false;}
    }
    public Map<String, Edges> graph = new HashMap<String, Edges>();
    public void CreateGraph(){
        List<String> adjA= new LinkedList<String>();
        adjA.add("B");
        adjA.add("S");
        graph.put("A",new Edges(adjA));
        graph.put("B",new Edges(new LinkedList<String>()));
        graph.put("F",new Edges(new LinkedList<String>()));
        graph.put("D",new Edges(new LinkedList<String>()));
        graph.put("H",new Edges(new LinkedList<String>()));
        List<String> adjS= new LinkedList<String>();
        adjS.add("C");
        adjS.add("G");
        graph.put("S",new Edges(adjS));
        List<String> adjC= new LinkedList<String>();
        adjC.add("D");
        adjC.add("E");
        adjC.add("F");
        graph.put("C",new Edges(adjC));
        List<String> adjG= new LinkedList<String>();
        adjG.add("F");
        adjG.add("H");
        graph.put("G",new Edges(adjG));
        List<String> adjE= new LinkedList<String>();
        adjE.add("H");
        graph.put("E",new Edges(adjE));
    }
    public void PrintDFS(String startNode){
        Stack<String> stack = new Stack<String>();
        if(graph.get(startNode) == null){
            System.out.println("node not present");
            return;
        }
        stack.push(startNode);
        System.out.println(startNode);
        while( ! stack.isEmpty()){
            String top =stack.peek();
            Edges adjList = graph.get(top);
            adjList.visited = true;
            if(adjList.vertices.size() == 0){
                stack.pop();
                continue;
            }
            Collections.sort(adjList.vertices);
            Boolean allVisited = true;
            for(int i = 0; i < adjList.vertices.size() ; i++){
                String node=adjList.vertices.get(i);
                if(! graph.get(node).visited){
                    stack.push(node);
                    System.out.println(node);
                    allVisited = false;
                    break;
                }
            }
            if(allVisited)
                stack.pop();
        }
    }
    public void TestDFS(){
        CreateGraph();
        PrintDFS("A");
    }
}
