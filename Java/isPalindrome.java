package leetcode;

import java.util.ArrayList;

public class isPalindrome {
	public static ArrayList<ArrayList<String>> partition(String s) {
		// substring of the partition is a palindrome.
		//
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		if (s.length() == 0 || s == null) {
			return result;
		}
		ArrayList<String> partition = new ArrayList<String>();
		addPalindrome(s, 0, partition, result);
		return result;
	}

	public static void addPalindrome(String s, int start, ArrayList<String> partition,
			ArrayList<ArrayList<String>> result) {

		if (start == s.length()) {
			ArrayList<String> temp = new ArrayList<String>(partition);
			result.add(temp);
			return;
		}
		for (int i = start + 1; i <= s.length(); i++) {
			String substr = s.substring(start, i);
			if (isPalindromes(substr)) {
				partition.add(substr);
				addPalindrome(s, i, partition, result);
				partition.remove(partition.size() - 1);
			}
		}
	}

	public static boolean isPalindromes(String str) {

		int left = 0;
		int right = str.length() - 1;
		while (left < right) {
			if (str.charAt(left) != str.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aabbc";
		System.out.println(isPalindrome.partition(s));
	}

}
