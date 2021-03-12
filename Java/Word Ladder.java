public class Solution {
    /**
      * @param start, a string
      * @param end, a string
      * @param dict, a set of string
      * @return an integer
      */
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        Map<String, Integer> map = new HashMap<>();
        Queue<String> q = new LinkedList<>();
        map.put(start, 1);
        q.offer(start);
        
        while(!q.isEmpty()){
            String word = q.poll();
            int len = map.get(word);
            if(word.equals(end))    
                break;
            for(int i = 0; i < word.length(); i++){
                String temp = word;
                for(char j = 'a'; j <= 'z'; j++){
                    char[] c = temp.toCharArray();
                    c[i] = j;
                    String newStr = new String(c);
                    if(!map.containsKey(newStr) && dict.contains(newStr)){
                        map.put(newStr, len + 1);
                        q.add(temp);
                    }
                }
            }
        }
        if(!map.containsKey(end)){
            return 0;
        }
        return map.get(end);
    }
}
