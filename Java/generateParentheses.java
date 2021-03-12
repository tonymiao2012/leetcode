package leetcode;

import java.util.ArrayList;

public class generateParentheses {
	public static ArrayList<String> generateParenthesis(int n) {

		ArrayList<String> result = new ArrayList<String>();
		StringBuilder sb = new StringBuilder(2 * n);

		generate(2 * n, 0, 0, result, sb);
		return result;
	}

	public static void generate(int maxLength, int left, int right,
	        ArrayList<String> result, StringBuilder sb) {
	    if (left + right == maxLength) {
	        if (left == right)
	            result.add(sb.toString());
	    } else if (left >= right) {
	        generate(maxLength, left + 1, right, result, sb.append('('));
	        sb.deleteCharAt(sb.length() - 1);

	        generate(maxLength, left, right + 1, result, sb.append(')'));
	        sb.deleteCharAt(sb.length() - 1);
	    }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(generateParenthesis(5));
	}

}
