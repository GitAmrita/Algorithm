package StringDataStructure;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by amritachowdhury on 7/2/17.
 */
public class Trie {
    public final TrieNode root;

    public class TrieNode {
        Map<Character, TrieNode> map;
        boolean endOfWord;

        public TrieNode() {
            this.map = new HashMap<>();
            this.endOfWord = false;
        }
    }

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            TrieNode node = current.map.get(c);
            if (node == null) {
                node = new TrieNode();
                current.map.put(c, node);
            }
            current = node;
        }
        current.endOfWord = true;
    }

    public void insertRecursive(String word) {
        insertRecursive(root, word, 0);
    }

    public void insertRecursive(TrieNode current, String word, int index) {
        if ( word.length() == index) {
            current.endOfWord = true;
            return;
        }
        TrieNode node = current.map.get(word.charAt(index));
        if (node == null) {
            node = new TrieNode();
            current.map.put(word.charAt(index), node);
        }
        insertRecursive(node, word, index + 1);
    }

    public boolean search(String word, boolean isPrefixSearch) throws Exception {
        if (root.map.size() == 0) {
            throw new Exception(" The trie data structure hasn't been initialized yet");
        }
        if (isPrefixSearch) {
            return prefixSearch(word);
        } else {
            return wholeWordSearch(word);
        }
    }

    public boolean searchRecursive(String word, boolean isPrefixSearch) throws Exception {
        if (root.map.size() == 0) {
            throw new Exception(" The trie data structure hasn't been initialized yet");
        }
        if (isPrefixSearch) {
            return prefixSearchRecursive(root, word, 0);
        } else {
            return wholeWordSearchRecursive(root, word, 0);
        }
    }

    private boolean prefixSearch(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            TrieNode node = current.map.get(c);
            if ( node == null) {
                return false;
            }
            current = node;
        }
        return true;
    }

    private boolean wholeWordSearch(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            TrieNode node = current.map.get(c);
            if ( node == null) {
                return false;
            }
            current = node;
        }
        return current.endOfWord;
    }

    private boolean prefixSearchRecursive(TrieNode current, String word, int index) {
        if (word.length() == index) {
            return true;
        }
        TrieNode node = current.map.get(word.charAt(index));
        return node == null ? false : prefixSearchRecursive(node, word, index + 1) ;
    }

    private boolean wholeWordSearchRecursive(TrieNode current, String word, int index) {
        if (word.length() == index) {
            return current.endOfWord;
        }
        TrieNode node = current.map.get(word.charAt(index));
        return node == null ? false : prefixSearchRecursive(node, word, index + 1) ;
    }

    public boolean delete(String word, boolean isPrefixDelete) {
        return wholeWordDelete(root, word, 0);
    }

    private boolean wholeWordDelete(TrieNode current, String word, int index) {
        if (index == word.length()) {

            if (!current.endOfWord) {
                return false;
            }
            current.endOfWord = false;
            //if current has no other mapping then return true
            return current.map.size() == 0;
        }
        char ch = word.charAt(index);
        TrieNode node = current.map.get(ch);
        if (node == null) {
            return false;
        }
        boolean shouldDeleteCurrentNode = wholeWordDelete(node, word, index + 1);


        if (shouldDeleteCurrentNode) {
            current.map.remove(ch);
            return current.map.size() == 0;
        }
        return false;
    }

}


