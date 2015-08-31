import java.util.HashMap;

/**
 * Created by achowdhury on 6/15/2015.
 */
//https://www.youtube.com/watch?v=UBY4sF86KEY
public class DisjointSet {
    public class Parent{
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
            if(rank.get(set1) > rank.get(set2)){
                hash.put(set2,set1);
                return;
            }
            //set1 looses parenthood to set2
            if(rank.get(set2) > rank.get(set1)){
                hash.put(set1,set2);
                return;
            }
        }
    }
    public void CallDisjoint(){
        //1,2,3,5 are all disjoint sets. 2 and 4 belong to the same set with 2 as parent.
        Parent p = new Parent();
        p.hash.put(1,1);
        p.rank.put(1,0);
        p.hash.put(2,2);
        p.rank.put(2,1);
        p.hash.put(3,3);
        p.rank.put(3,0);
        p.hash.put(4,2);
        p.rank.put(4,0);
        p.hash.put(5,5);
        p.rank.put(5,0);
        System.out.println( p.FindParent(3));
        p.Union(3,1);
        System.out.println( p.FindParent(3));
        p.Union(1,2);
    }
}
