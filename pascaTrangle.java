package leetcode;

import java.util.ArrayList;

public class pascaTrangle {
    public static ArrayList<ArrayList<Integer>> generate(int numRows) {
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(numRows == 0){
            return result;
        }
        
        for(int i = 0; i < numRows; i++){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(1);
            if(i > 0){
                for(int j =0; j < result.get(i - 1).size() - 1; j++){
                    temp.add(result.get(i - 1).get(j) + result.get(i - 1).get(j + 1));
                }
                temp.add(1);
            }
            result.add(temp);
        }
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pascaTrangle.generate(5);
	}

}
