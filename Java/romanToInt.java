package leetcode;

import java.util.HashMap;

public class romanToInt {
	public static int romantoint(String s) {

		// we will check roman string by one char.
		int result = 0;

		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		hm.put("I", 1);
		hm.put("V", 5);
		hm.put("X", 10);
		hm.put("L", 50);
		hm.put("C", 100);
		hm.put("D", 500);
		hm.put("M", 1000);
		// result += hm.get(String.valueOf(s.charAt(0)));
		for (int i = 0; i < s.length(); i++) {
			if (i > 0
					&& hm.get(String.valueOf(s.charAt(i - 1))) < hm.get(String
							.valueOf(s.charAt(i)))) {
				result += hm.get(String.valueOf(s.charAt(i))) - 2
						* hm.get(String.valueOf(s.charAt(i - 1)));
			} else {
				result += hm.get(String.valueOf(s.charAt(i)));
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "MDCXCV";
		// System.out.println(test.charAt(0));
		System.out.println(romanToInt.romantoint(test));
	}

}
