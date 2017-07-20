package StringDataStructure;

/**
 * Created by amritachowdhury on 7/2/17.
 */
public class TestTrie {

    public void run() {
        try {
            Trie trie = new Trie();
            trie.insertRecursive("car");
            trie.insertRecursive("cabinet");
            trie.insertRecursive("cab");
           /* boolean isFound = trie.searchRecursive("cab", false);
            System.out.println(isFound);
            isFound = trie.search("car", false);
            System.out.println(isFound);
            isFound = trie.search("cabinet", false);
            System.out.println(isFound);*/
            boolean isDeleted = trie.delete("car", false);
            System.out.println(isDeleted);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
