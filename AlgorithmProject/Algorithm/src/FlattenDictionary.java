import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by achowdhury on 6/16/2015.
 */

//http://stackoverflow.com/questions/27361003/how-to-flatten-a-nested-dict-and-exclude-duplicate-keys
public class FlattenDictionary {

   public Map<Integer, Map<String,String>>outerMap = new HashMap<Integer, Map<String,String>>();
   public Map<String,String>resultMap = new HashMap<String,String>();

    public void InsertMap(){
        Map<String,String> m1 = new HashMap<String,String>();
        m1.put("a","x");
        m1.put("b","y");
        Map<String,String> m2 = new HashMap<String,String>();
        m2.put("c","z");
        m2.put("b","y");
        Map<String,String> m3 = new HashMap<String,String>();
        m2.put("d","m");
        m2.put("b","y");
        outerMap.put(1,m1);
        outerMap.put(2,m2);
        outerMap.put(3,m3);
    }

    public void FlattenMap(){
        Iterator<Map.Entry<Integer, Map<String,String>>> iter = outerMap.entrySet().iterator();
        while (iter.hasNext()){
            Map.Entry<Integer, Map<String,String>> entry = iter.next();
            Map<String,String> tempMap = entry.getValue();
            Iterator<Map.Entry<String,String>> innerIter = tempMap.entrySet().iterator();
            while(innerIter.hasNext()){
                Map.Entry<String,String> innerEntry = innerIter.next();
                String key = innerEntry.getKey();
                String value = innerEntry.getValue();
                if(resultMap.get(key) == null){
                    resultMap.put(key,value);
                }
                else{
                    resultMap.remove(key);
                }
            }
        }
    }

    public void PrintMap(){
        Iterator<Map.Entry<String,String>> iter = resultMap.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry<String,String> innerEntry =iter.next();
            String key = innerEntry.getKey();
            String value = innerEntry.getValue();
            System.out.println(key + " -> " + value);
        }
    }

    public void CallFlatten(){
        InsertMap();
        FlattenMap();
        PrintMap();
    }
}
