import java.util.HashMap;
import java.util.Map;

/**
 * Created by amritachowdhury on 8/23/17.
 */
public class TrieIterative {

    public class Node {
        public Map<Character, Node> map;
        public boolean isAWord;

        public Node() {
            map = new HashMap<>();
            isAWord = false;
        }

        public void add(String s) {
            for (char c : s.toCharArray()) {
                Node child = this.map.get(c);
                if (child == null) {
                    child = this.map.put(c, new Node());
                }
                child = this.map.get(c);
            }
            this.isAWord = true;
        }

        public boolean isAWord(String s) {
            for (char c : s.toCharArray()) {
                Node child = this.map.get(c);
                if (child == null){
                    return false;
                }
                child = child.map.get(c);
            }
            return this.isAWord;
        }

        public boolean isAPrefix(String s) {
            for (char c : s.toCharArray()) {
                Node child = this.map.get(c);
                if (child == null){
                    return false;
                }
                child = child.map.get(c);
            }
            return true;
        }
    }

    public void run() {
        Node n = new Node();
        n.add("trie");
        n.add("try");
        boolean s = n.isAWord("trie");
        boolean s1 = n.isAWord("trial");
        boolean s2 = n.isAPrefix("tri");
        boolean s3 = n.isAPrefix("trm");
        int p = 1;
    }
}
