import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by achowdhury on 6/15/2015.
 */
public class KruskalMST {

    public class Edge implements Comparable<Edge> {
        public int vertex1;
        public int vertex2;
        public int weight;

       @Override
        public int compareTo(Edge e1) {
           int compareQuantity = e1.weight;
           //ascending order
           return this.weight - compareQuantity;
        }

       public Edge(int v1,int v2,int w) {
           vertex1 = v1;
           vertex2 = v2;
           weight = w;
       }
    }

    public class Graph{
        ArrayList<Integer> vertices;
        ArrayList<Edge> edges;
        public Graph CreateGraph(){
            int[] vertex = new int[]{1,2,3,4,5,6};
            Graph g = new Graph();
            g.vertices =  new ArrayList<Integer>();
            for(int i : vertex)
                g.vertices.add(i);
            g.edges =  new ArrayList<Edge>();
            g.edges.add(new Edge(6,2,5));
            g.edges.add(new Edge(3,2,6));
            g.edges.add(new Edge(3,6,1));
            g.edges.add(new Edge(1,6,2));
            g.edges.add(new Edge(4,5,2));
            g.edges.add(new Edge(4,3,3));
            g.edges.add(new Edge(1,2,4));
            g.edges.add(new Edge(6,5,4));

            return g;
        }
    }

    public class ParentDisjoint{
        java.util.Map<Integer,Integer> hash=new java.util.HashMap<Integer,Integer>();//key = key; value=parent
        java.util.Map<Integer,Integer> rank=new java.util.HashMap<Integer,Integer>();

        public int FindParent(int val){
            if(hash.get(val)  == null)
                return 99;
            if(hash.get(val) == val)
                return val;
            else
                return FindParent(hash.get(val));
        }

        public void Union(int set1,int set2){
            //set1 looses parenthood to set2
            if(rank.get(set1) == rank.get(set2)){
                hash.put(set1,set2);
                rank.put(set2,rank.get(set2)+1);
                return;
            }
            //set2 looses parenthood to set1
            if(rank.get(set1) >= rank.get(set2)){
                hash.put(set2,set1);
                return;
            }
            //set1 looses parenthood to set2
            if(rank.get(set2) >= rank.get(set1)){
                hash.put(set1,set2);
                return;
            }
        }

        public void MakeSet(int set){
            hash.put(set,set);
            rank.put(set,0);
        }
    }

    public void PrintMST(ArrayList<Edge> mstEdges){
        for(Edge e : mstEdges){
            System.out.println(e.vertex1 + "->" + e.vertex2 + "=" + e.weight);
        }
    }

    public void Kruskal(){
        Graph g=new Graph();
        ArrayList<Edge> a = new ArrayList<Edge>();
        ParentDisjoint p = new ParentDisjoint();
        Graph graph=g.CreateGraph();
        for(Integer i :graph.vertices){
            p.MakeSet(i);
        }
        //sort graph.edges
        Collections.sort(graph.edges);
        for(Edge e : graph.edges){
            int v1 = e.vertex1;
            int v2 = e.vertex2;
            int r1=p.FindParent(v1);
            int r2=p.FindParent(v2);
            if(r1 != r2){
                a.add(e);
                p.Union(r1,r2);
            }
        }
        PrintMST(a);
    }
}
