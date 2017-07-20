package Moderate;

import java.util.HashSet;

/**
 * Created by amritachowdhury on 7/14/17.
 */
public class p2 {

    public void run() {
        int s = lengthOfLongestSubstring("abcbbcac");
        System.out.println(s);
    }

    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int start = 0;
        int max = 0;
        HashSet<Character> set = new HashSet<>();
        for ( int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(!set.contains(c)){
                set.add(c);

                max = Math.max(max, i-start+1);
            } else {
                for(int j = start; j < i; j++){
                    set.remove(s.charAt(j));

                    if(s.charAt(j) == c){
                        start = j + 1;
                        break;
                    }
                }

                set.add(c);
            }
        }

        return max;
    }
    /*public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet(); int maxLength = 0; int localLength = 0;
        int maxInner = 0; int maxOuter = 0;
        int outer = 0; int inner = 0;
        while (outer < s.length())   {
            if (!set.contains(s.charAt(inner))) {
                set.add(s.charAt(inner));
                localLength = inner - outer + 1;
                inner++;
            } else {
                if (localLength >= maxLength) {
                    maxLength = localLength;
                    maxInner = inner;
                    maxOuter = outer;
                }
                outer++;
                inner = outer;
                set.clear();
            }
            if (inner == s.length()) {
                if (localLength >= maxLength) {
                    maxLength = localLength;
                    maxInner = inner;
                    maxOuter = outer;
                }
                break;
            }
        }
        String longestSequenceString = s.substring(maxOuter, maxInner);
        System.out.println(longestSequenceString);
        return maxLength;
    }*/
}
