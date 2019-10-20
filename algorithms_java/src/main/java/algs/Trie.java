package algs;

import java.util.HashMap;

class Trie {
    class TrieNode {
        public final Character c;
        public final HashMap<Character, TrieNode> m = new HashMap<>();
        public boolean terminate = false;

        public TrieNode(Character c){
            this.c = c;
        }
    }

    private final HashMap<Character, TrieNode> nodes = new HashMap<>();

    /** Initialize your data structure here. */
    public Trie() {

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(word == null || word.isEmpty())
            return;
        TrieNode current = nodes.get(word.charAt(0));
        if(current == null)
            nodes.put(word.charAt(0), current = new TrieNode(word.charAt(0)));
        for(int i=1; i<word.length(); i++){
            Character ic = word.charAt(i);
            TrieNode in = current.m.get(ic);
            if(in == null){
                in = new TrieNode(ic);
                current.m.put(ic, in);
            }
            current = in;
        }
        current.terminate = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode n = getNode(word);
        return n != null && n.terminate;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return getNode(prefix) != null;
    }

    private TrieNode getNode(String word){
        if(word == null || word.isEmpty())
            return null;
        TrieNode current = nodes.get(word.charAt(0));
        for(int i=1; i<word.length() && current != null; i++)
            current = current.m.get(word.charAt(i));
        return current;
    }
}