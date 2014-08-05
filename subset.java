package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class subset {
	public static ArrayList<ArrayList<Integer>> subsets(int[] S) {
	    ArrayList<ArrayList<Integer>> cache = new ArrayList<ArrayList<Integer>>();
	    if (S == null || S.length == 0) {
	        return cache;
	    }
	    cache.add(new ArrayList<Integer>());
	    Arrays.sort(S);
	    return helper(S, 0, cache);
	}

	private static ArrayList<ArrayList<Integer>> helper(int[] s, int index, ArrayList<ArrayList<Integer>> cache) {
	    if (index == s.length) return cache;

	    ArrayList<ArrayList<Integer>> newCache = new ArrayList<ArrayList<Integer>>(cache);
	    for (ArrayList<Integer> set : cache) {
	        ArrayList<Integer> temp = new ArrayList<Integer>(set);
	        temp.add(s[index]);
	        newCache.add(temp);
	    }

	    return helper(s, index + 1, newCache);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] S = {0,1,2,3,4,5};
		System.out.println(subsets(S));
	}

}
