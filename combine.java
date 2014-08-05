package leetcode;

import java.util.ArrayList;

public class combine {
    public static ArrayList<ArrayList<Integer>> combine(int n, int k) {
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int[] temp = new int[k];
        //dfs, incursive
        helper(n,k,0,temp,result);
        return result;
    }
    public static void helper(int n, int k, int d, int[] combination, ArrayList<ArrayList<Integer>> result){
        
        if(d == k){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for(int i = 0; i < k; i++){
                temp.add(combination[i]);
            }
            result.add(temp);
            return;
        }
        for(int i = 0; i < n; i++){
            if(d == 0 || i + 1 > combination[d - 1]){
                combination[d] = i + 1;
                helper(n,k,d + 1,combination,result);
            }
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 6;
		int k = 3;
		combine.combine(n, k);
	}

}
