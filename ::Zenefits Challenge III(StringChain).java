//Zenefits Challenge III
//StringChain

/*
 * Complete the function below.
 */
    private static int max = 0;
    public static int longest_chain(String[] w) {
        if(w == null || w.length == 0){
            return 0;
        }
        Map<Integer, Set<String>> map = new HashMap<>();
        int maxLength = 0;
        
        for(String s : w){
            int len = s.length();
            if(map.containsKey(len)){
                map.get(len).add(s);
            }else{
                Set<String> words = new HashSet();
                words.add(s);
                map.put(len, words);
            }
            maxLength = Math.max(maxLength, len);
        }
        
        int result = helper(maxLength, 1, map);
        return result;
    }

    private static int helper(int curLen, int lvl, Map<Integer, Set<String>> map){
        if(curLen == 0){
            return max;
        }
        
        if(map.containsKey(curLen)){
            Set<String> words = map.get(curLen);
            Iterator<String> it = words.iterator();
            while(it.hasNext()){
                String tmp = it.next();
                for(int i = 0; i < tmp.length(); i++){
                    StringBuilder sb = new StringBuilder(tmp);
                    sb.deleteCharAt(i);
                    String newStr = sb.toString();
                    if(map.containsKey(curLen - 1) &&
                       map.get(curLen - 1).contains(newStr)){
                        helper(curLen - 1, lvl + 1, map);
                    }
                }
                it.remove();
            }
            max = Math.max(max, lvl);
        }
        return max;
    }
