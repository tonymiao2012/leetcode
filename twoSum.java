package leetcode;

import java.util.ArrayList;

public class twoSum {

	public static int[] twoSum(int[] numbers, int target) {

		// not sure whether the array is sorted.
		if (numbers.length == 0 || numbers == null) {
			return null;
		}
		// use a hashmap to solve this problem <key,value>. Key is the index of
		// numbers[]. Value is target - numbers[key].
		// It means which number it needs.
		// HashMap<Integer, Integer> list = new HashMap<Integer, Integer>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		int[] result = new int[2];
		// set up hashmap
		for (int i = 0; i < numbers.length; i++) {
			// HashMap.put(i,target - numbers[i]);
			list.add(target - numbers[i]);
		}
		for (int i = 0; i < numbers.length; i++) {
			if (list.contains(numbers[i])) {
				int index2 = list.indexOf(numbers[i]);
				if (i < index2) {
					result[0] = i;
					result[1] = index2;
					break;
				} else if(i > index2){
					result[0] = index2;
					result[1] = i;
					break;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = { 3, 2, 4 };
		int target = 6;
		twoSum.twoSum(numbers, target);
	}

}
