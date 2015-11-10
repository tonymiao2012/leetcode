public class Solution {
    /**
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public List<String> anagrams(String[] strs) {
        // write your code here
        List<String> res = new ArrayList<String>();
        if(strs.length == 0){
            return res;
        }
        Map<String, List<String>> hm = new HashMap<String, List<String>>();
        
        for(String s : strs){
            char[] tmp = s.toCharArray();
            Arrays.sort(tmp);
            String tempStr = new String(tmp);
            
            if(hm.containsKey(tempStr)){
                hm.get(tempStr).add(s);
            }else{
                List<String> list = new ArrayList<String>();
                list.add(s);
                hm.put(tempStr,list);
            }
        }
        
        for(Map.Entry<String, List<String>> entry : hm.entrySet()){
            if(entry.getValue().size() > 1){
                res.addAll(entry.getValue());
            }
        }
        
        return res;
    }
}
