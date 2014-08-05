package leetcode;

import java.util.HashMap;
import java.util.Stack;

public class validParentheses {
	public static boolean isValid(String s) {

		if (s.length() % 2 != 0) {
			return false;
		}

		HashMap<Character, Character> hm = new HashMap<Character, Character>();
		hm.put('(', ')');
		hm.put('[', ']');
		hm.put('{', '}');
		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i <= s.length() - 1; i++) {
			if (hm.containsKey(s.charAt(i))) {
				stack.push(s.charAt(i));
			} else if (!stack.isEmpty() && !hm.containsKey(s.charAt(i))) {
				char tmp = stack.pop();
				if (hm.get(tmp) == s.charAt(i) && i == s.length() - 1)
					return true;
			} else if (stack.isEmpty()) {
				return false;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		validParentheses.isValid("}}(]}}){)(])](}{{}[]");
	}

}
