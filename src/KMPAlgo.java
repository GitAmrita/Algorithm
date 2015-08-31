import java.util.HashMap;
import java.util.Map;

/**
 * Created by achowdhury on 6/29/2015.
 */
public class KMPAlgo {

    public String segment = "ACACAGT";
    public String text = "ACAT ACGACACAGT";
    public int[] prefixArray = new int[segment.length()];
    public Map<String, Integer> prefixHash = new HashMap<String, Integer>();

    public void ConstructPrefixTable(){
        for(int i = 0; i < segment.length(); i++){
            if(i == 0)
                prefixArray[0]=0;
            else{
                GetPrefix(i);
                prefixArray[i]=FindMaxSuffix(i);
            }
        }
    }

    public void GetPrefix(int pos){
        String prefix = "";
        for(int i =0; i< pos; i++){
            prefix= prefix + segment.charAt(i);
            prefixHash.put(prefix,1);
        }
    }

    public int FindMaxSuffix(int pos){
        String suffix = "";
        int max = 0;
        for(int i = pos; i > 0 ; i--){
            suffix = segment.charAt(i) + suffix;
            if(prefixHash.get(suffix) != null){
                max = max < suffix.length() ? suffix.length(): max;
            }
        }
        return max;
    }

    public void PrintPrefixTable(){
        for(int i =0; i< segment.length();i++)
            System.out.println(segment.charAt(i) + " -> " + prefixArray[i]);
    }

    public void IsPatternExist(){
        int j =0;
        int i = 0;
        Boolean matched =false ;
        int patternCount = 0;
        while(i< text.length()){
            char textTest = text.charAt(i);
            char segTest = segment.charAt(j);
            if(matched && j == segment.length() - 1){
                patternCount ++ ;
                int stIndex = i-segment.length();
                int endIndex = i;
                System.out.println("startIndex " + stIndex + "end index " + endIndex);
                i=j;
                j=0;
            }
            if(text.charAt(i) == segment.charAt(j)){
                j++ ;
                i++ ;
                matched = true;
            }
            else{
                int shiftBy = 1;
                if(prefixArray[j] >0){
                    shiftBy =j-(prefixArray[j] - 1) ;
                }
                i=0;
                i = i + shiftBy ;
                j=0;
                matched = false;
            }

        }
        System.out.println("frequency of pattern : " + patternCount);
    }

    public void CallKMP(){
        ConstructPrefixTable();
        PrintPrefixTable();
        IsPatternExist();
    }
}
