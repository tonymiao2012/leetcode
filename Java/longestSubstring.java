package leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class longestSubstring {
	public static int lengthOfLongestSubstring(String s) {

		int result = 0;
		ArrayList<Character> tmp = new ArrayList<Character>();
		if (s.length() == 0)
			return 0;
		int i = 0;
		int j = 1;
		tmp.add(s.charAt(i));

		for (; j < s.length(); j++) {
			char c = s.charAt(j);

			if (tmp.contains(c)) {
				result = Math.max(result, j - i);
				tmp = new ArrayList<Character>();
				i++;
				j = i;
				tmp.add(s.charAt(i));
			} else {
				tmp.add(c);
			}
		}
		// deal with the rest.
		if (!tmp.isEmpty())
			result = Math.max(result, j - i);

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out
				.println(lengthOfLongestSubstring("wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco"));
	}

}
