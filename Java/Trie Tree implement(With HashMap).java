/**
 * Your Trie object will be instantiated and called as such:
 * Trie trie = new Trie();
 * trie.insert("lintcode");
 * trie.search("lint"); will return false
 * trie.startsWith("lint"); will return true
 */
class TrieNode {
    char c;
    HashMap<Character, TrieNode> children = new HashMap<>();
    boolean isLeaf;
    // Initialize your data structure here.
    public TrieNode(char c) {
        this.c = c;
    }
    public TrieNode(){}
}

public class Solution {
    private TrieNode root;

    public Solution() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if(word == null || word.length() == 0){
            return;
        }
        HashMap<Character, TrieNode> children = root.children;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            TrieNode t = null;
            if(children.containsKey(c)){
                t = children.get(c);
            }else{
                t = new TrieNode(c);
                children.put(c, t);
            }
            
            children = t.children;
            
            if(i == word.length() - 1){
                t.isLeaf = true;
            }
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        if(searchNode(word) != null && searchNode(word).isLeaf){
            return true;
        }
        return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if(searchNode(prefix) == null){
            return false;
        }
        return true;
    }
    
    public TrieNode searchNode(String str){
        Map<Character, TrieNode> t = root.children;
        1TrieNode res = null;
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(t.containsKey(c)){
                res = t.get(c);
                t = res.children;
            }else{
                return null;
            }
        }
        
        return res;
        
    }
}
