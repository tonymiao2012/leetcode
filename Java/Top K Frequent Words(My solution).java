class Element{
    int freq;
    String key;
    
    public Element(int freq, String key){
        this.freq = freq;
        this.key = key;
    }
}

public class Solution {
    /**
     * @param words an array of string
     * @param k an integer
     * @return an array of string
     */
    private Comparator<Element> ElemCmp = new Comparator<Element>(){
        public int compare(Element a, Element b){
           if(a.freq != b.freq){
               return a.freq - b.freq;
           }
           return b.key.compareTo(a.key); 
        }  
    }; 
     
    public String[] topKFrequentWords(String[] words, int k) {
        // Write your code here
        if(words == null || words.length == 0|| k == 0){
            return new String[0];
        }
        //Count word
        HashMap<String, Integer> counter = new HashMap<>();
        for(String word : words){
            if(counter.containsKey(word)){
                counter.put(word, counter.get(word) + 1);
            }else{
                counter.put(word, 1);
            }
        }
        
        PriorityQueue<Element> queue = new PriorityQueue<Element>(k, ElemCmp);
        //Populate queue
        for(String word : counter.keySet()){
            Element newElm = new Element(counter.get(word), word);
            if(queue.size() < k){
                queue.add(newElm);
            }else{
                Element curMin = queue.peek();
                if(ElemCmp.compare(newElm, curMin) > 0){  //Take care of here, use comparator to compare.
                    queue.poll();
                    queue.add(newElm);
                }
            }
        }
        
        String[] res = new String[k];
        int index = k - 1;
        while(!queue.isEmpty()){
            Element tmp = queue.poll();
            res[index] = tmp.key;
            index--;
        }
        
        return res;
    }
}