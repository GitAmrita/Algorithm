
import java.util.HashMap;
import java.util.Map;
//https://www.youtube.com/watch?v=AXjmTQ8LEoI&t=12s

/**
 * Created by amritachowdhury on 1/22/17.
 */
public class trie {
    public class TrieNode {
        Map<Character,TrieNode> map;
        boolean isWord;

        public TrieNode() {
            this.map = new HashMap<>();
            this.isWord = false;
        }

        public void add(String s) {

            if (s.isEmpty()) {
                this.isWord = true;
                return;
            }
            if (map.get(s.charAt(0)) == null) {
                map.put(s.charAt(0), new TrieNode());
            }
            TrieNode child = this.map.get(s.charAt(0));
            // System.out.println(s + ": " +  s.charAt(0) + ": " + this.map.size());

            child.add(s.substring(1));
        }

        public void deleteWord(String s) {
            if (s.isEmpty()) {
                this.isWord = false;
                return;
            }
            TrieNode node = this.map.get(s.charAt(0));
            if (node == null) {
                return;
            }

            if (node.map.size() == 0) {
                node.map.remove(s.charAt(0));
            }
            node.deleteWord(s.substring(1));
        }

        public void deleteWordWithPrefix(String s) {
            TrieNode node = this.map.get(s.charAt(0));
            if (node == null) {
                return;
            }
            if (s.length() == 1) {
                node.map.clear();
                return;
            }
            node.deleteWordWithPrefix(s.substring(1));
        }

        public boolean isWord(String s) {
            if (s.isEmpty()) {
                return this.isWord;
            }
            if (map.get(s.charAt(0)) == null) {
                return false;
            }
            return this.map.get(s.charAt(0)).isWord(s.substring(1));
        }

        public boolean isPrefix(String s) {
            if (s.isEmpty()) {
                return true;
            }
            if (map.get(s.charAt(0)) == null) {
                return false;
            }
            return this.map.get(s.charAt(0)).isPrefix(s.substring(1));
        }
        public void explore(String s, TrieNode child) {
            for (Map.Entry<Character,TrieNode> entry : child.map.entrySet()) {
                if (entry.getValue().isWord) {
                    System.out.print(s + entry.getKey());
                }
                this.explore(s + entry.getKey(), entry.getValue());
            }
            System.out.println("");
        }
        public void listAll(String orig, String s) {
            if (s.length() == 1) {
                for (Map.Entry<Character,TrieNode> entry : map.entrySet()) {
                    this.explore(orig, entry.getValue());
                    System.out.println("listAll");
                }
                return;
            }
            if (map.get(s.charAt(0)) == null) {
                return;
            }
            TrieNode child = this.map.get(s.charAt(0));
          //  System.out.println(s + ": " +  s.charAt(0) + ": " + this.map.size());

            child.listAll(s, s.substring(1));
        }
    }

    public void addAWord() {
        TrieNode t = new TrieNode();
        t.add("trie");
        t.add("trial");
        t.add("try");
        t.add("rat");
        t.add("mat");
        t.listAll("tr", "tr");
       /* boolean isTrial = t.isWord("trial");
        boolean isTry = t.isWord("try");
        boolean isTrie = t.isWord("trie");
        boolean isR = t.isWord("r");

        boolean isPrefixR = t.isPrefix("r");
        boolean isPrefixM = t.isPrefix("m");

        t.deleteWord("trie");
        boolean isTrieWordAgain = t.isWord("trie");
        boolean isTryWordAgain = t.isWord("try");


        t.deleteWordWithPrefix("tr");
        boolean isTrialWordAgain = t.isWord("trial");
        boolean isTryWordAgain1 = t.isWord("try");*/
        System.out.println("end");
    }
}
