import java.util.*;

/**
 * Created by achowdhury on 5/27/2015.
 */

public class MinCut {
    public void CallMinCut()
    {
        MinCut m= new MinCut();
        Map<Integer,List<Integer>> graph = m.CreateGraph();
        while(graph.size()> 2)
        {
            List<Integer> keys = new ArrayList<Integer>();
            for(Object obj : graph.keySet().toArray()){
                keys.add((Integer)obj);
            }
            //1st random function randomly selects 1 node of the graph
            int node1 = GetRandom(keys);
            //2nd random function selects one of the adjacent nodes from node 1
            int node2 = GetRandom(graph.get(node1));
            //node1 + node2 gives a random edge
            //remove the edge that is randomly selected
            List<Integer> newNode2Vals = new ArrayList<Integer>();
            for (int temp : graph.get(node2)) {
                if(temp != node1)
                    newNode2Vals.add(temp);
            }

            List<Integer> newNode1Vals = new ArrayList<Integer>();
            for (int temp : graph.get(node1)) {
                if(temp != node2)
                    newNode1Vals.add(temp);
            }
            newNode1Vals.addAll(newNode2Vals);
            //add modified edges to node1
            graph.put(node1,newNode1Vals);
            //delete one of the randomly selected nodes. We chose to delete node2.
            graph.remove(node2);
            //iterate over all other nodes and replace node2 with node1 since they have now merged
            Iterator entries =graph.entrySet().iterator();
            while(entries.hasNext()){
                Map.Entry thisEntry =(Map.Entry)entries.next();
                Object value=thisEntry.getValue();
                List<Integer> newNodeVals = new ArrayList<Integer>();
                for (Integer temp : (List<Integer>)value) {
                    if(temp == node2)
                        newNodeVals.add(node1);
                    else
                        newNodeVals.add(temp);
                }
                thisEntry.setValue(newNodeVals);
            }
        }
        //determine the min cut from the remainder nodes
        Set remainingNode =graph.keySet();
        int minCut=graph.get(remainingNode.toArray()[0]).size();
        System.out.println(minCut);
    }

    public static int GetRandom(List<Integer> nos)
    {
        Random randomGenerator = new Random();
        int index = randomGenerator.nextInt(nos.size());
        return nos.get(index);
    }
    public Map<Integer,List<Integer>> CreateGraph()
    {
        Map<Integer,List<Integer>> map = new HashMap<Integer, List<Integer>>(){{
            put(1, Arrays.asList(2,4));
            put(2, Arrays.asList(1,3,4));
            put(3, Arrays.asList(2,4));
            put(4, Arrays.asList(1,2,3));
        }};
        return map;
    }
}
