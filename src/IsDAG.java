import java.util.*;

/**
 * Created by achowdhury on 7/7/2015.
 */
//find if the graph is a directed acyclic graph
public class IsDAG {
    public class Edges{
        public List<String> vertices ;
        public Boolean visited ;

        public Edges(List<String> vertices){this.vertices = vertices; this.visited = false;}
    }
    public Map<String, Edges > graph = new HashMap<String, Edges>();
    public Stack<String> stack = new Stack<String>();
    public Map<String, String > maintainCyclic = new HashMap<String, String>();
    public Boolean IsNodeInStack(String key){
       return maintainCyclic.get(key) == null ? false : true ;
    }

    public void PushIntoStack(String root){
        stack.push(root) ;
        graph.get(root).visited = true;
        maintainCyclic.put(root,root);
        System.out.println(root);
    }
    public void PopOutOfStack(String root){
        stack.pop();
        maintainCyclic.remove(root);
    }
    public Boolean CheckIfDAG(String root){
        if(graph.get(root)== null)
            return false;
        PushIntoStack(root);
        while(! stack.isEmpty()){
            String top = stack.peek();
            Edges e = graph.get(top);
            if(e.vertices.size() == 0)//leaf node
                PopOutOfStack(top);
            else {
                Boolean allVisited= true;
                for(String s : e.vertices){
                    if(IsNodeInStack(s))
                        return false;
                    if(graph.get(s).visited == false){
                        PushIntoStack(s);
                        allVisited = false;
                        break;
                    }
                }
                if(allVisited)
                    PopOutOfStack(top);
            }
        }
        return true;
     }
    public void CreateGraph(){
        // this is acyclic graph
        graph.put("a", new Edges(Arrays.asList("b" ,"c")));
        graph.put("b", new Edges(Arrays.asList("c")));
        graph.put("c", new Edges(Arrays.asList("d")));
        graph.put("d", new Edges(new ArrayList<String>()));

        //this is cyclic graph
      /*
        graph.put("a", new Edges(Arrays.asList("b" ,"c")));
        graph.put("b", new Edges(Arrays.asList("c")));
        graph.put("c", new Edges(Arrays.asList("a","d")));
        graph.put("d", new Edges(Arrays.asList("d"))); */
       /*
        graph.put("a", new Edges(Arrays.asList("b" ,"c", "g")));
        graph.put("b", new Edges(Arrays.asList("c")));
        graph.put("c", new Edges(Arrays.asList("d")));
        graph.put("g", new Edges(Arrays.asList("b" ,"h")));
        graph.put("h", new Edges(Arrays.asList("a")));
        graph.put("d", new Edges(new ArrayList<String>())); */
    }
    public void CallIsDAG(){
        CreateGraph();
        Boolean DAG =CheckIfDAG("a");
        String message = DAG == true ? "acyclic" : "cyclic";
        System.out.println(message);
    }
}
