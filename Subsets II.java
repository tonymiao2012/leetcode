class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(S == null){
            return result;
        }
        Collections.sort(S);
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        
        for(int i = 0; i <= S.size(); i++){
            helper(result, i, S, tmp, 0);
        }
        
        return result;
    }
    private void helper(ArrayList<ArrayList<Integer>> res, int len, ArrayList<Integer> S, ArrayList<Integer> tmp, int index){
        if(tmp.size() == len){
            if(!res.contains(tmp)){
                res.add(new ArrayList<Integer>(tmp));
                return;
            }
        }else if(index == S.size()){
            return;
        }
        
        for(int i = index; i < S.size(); i++){
            int n = S.get(i);
            tmp.add(n);
            helper(res, len, S, tmp, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}

