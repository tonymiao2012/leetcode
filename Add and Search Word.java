public class WordDictionary {
    public class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public String item = "";
    }

    private TrieNode root = new TrieNode();
    
    public void addWord(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray()){
            if(curr.getChild(c) == null)
                curr.setChild(c, new TrieNode());
            curr = curr.getChild(c);
        }
        curr.item = word;

    }

    public boolean search(String word) {
        return search(word,root);
    }

    public boolean search(String word, TrieNode node){
        if(word.length() < 1)
            return node != null && !node.item.equals("");
            
        TrieNode curr = node;
        char c = word.charAt(0);
        if(c != '.' && node.getChild(c) != null){
            return search(word.substring(1),node.getChild(c));
        }else if(c == '.'){
            for(char i = 'a'; i <= 'z'; i++){
                if(node.getChild(i) != null && search(word.substring(1),node.getChild(i)))
                    return true;
            }
            return false;
        }else
            return false;
    }
}