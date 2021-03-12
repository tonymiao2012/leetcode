public class WordDictionary {
    public class TrieNode{
        public TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }
    
    private TrieNode root = new TrieNode();
    
    static int index(char c){
        return c-'a';
    }
    // Adds a word into the data structure.
    public void addWord(String word) {
        // Write your code here
        TrieNode cur = root;
        for(char c : word.toCharArray()){
            if(cur.children[index(c)] == null){
                cur.children[index(c)] = new TrieNode();
            }
            cur = cur.children[index(c)];
        }
        
        cur.isEnd = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        // Write your code here
        return search(root, word, 0);
    }
    
    private boolean search (TrieNode cur, String word, int idx){
        if(cur == null) return false;
        else if(idx == word.length()){
            return cur.isEnd; // some words ended here.
        }

        final char c = word.charAt(idx);

        if(c == '.'){
            /*check existance*/
            for(TrieNode n : cur.children)
                if(search (n, word, idx + 1))
                    return true;

            return false;
        }
        else{
            TrieNode n = cur.children[index(c)];
            return search(n, word, idx +1);
        }
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
