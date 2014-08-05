package leetcode;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class longestSubstringTest {
	public int lengthOfLongestSubstring(String s) {

		int result = 0;
		ArrayList<Character> tmp = new ArrayList<Character>();
		if (s.length() == 0)
			return 0;
		int i = 0;
		tmp.add(s.charAt(i));

		for (int j = i + 1; j < s.length(); j++) {
			char c = s.charAt(j);

			if (tmp.contains(c)) {
				result = Math.max(result, j - i);
				tmp = new ArrayList<Character>();
				i++;
				tmp.add(s.charAt(i));
			} else {
				tmp.add(c);
			}
		}

		return result;
	}

	@Test
	public void testLengthOfLongestSubstring() {
		fail("Not yet implemented");
		System.out
				.println(lengthOfLongestSubstring("wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco"));
	}

}
