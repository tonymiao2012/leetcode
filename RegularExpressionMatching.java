package leetcode;

public class RegularExpressionMatching {
	public static boolean isMatch(String s, String p) {

		// null cases.
		if (p.length() == 0)
			return false;
		int i = 0, j = 0;

		while (j < p.length()) {
			if (s.charAt(i) == p.charAt(j)) {
				i++;
				j++;
				if (!(i == s.length() && j == p.length()))
					return false;
			} else {
				// [j] == '.', match
				if (p.charAt(j) == '.') {
					i++;
					j++;
					if (i == s.length() && s.length() != p.length()) {
						if (p.charAt(j) == '*')
							return true;
						else
							return false;
					}
				}
				// [j] == '*', match a lot
				else if (p.charAt(j) == '*') {
					if (i - 1 >= 0) {
						char tmp = s.charAt(i - 1);
						while (s.charAt(i) == tmp && i < s.length()) {
							i++;
							if (i > s.length() - 1)
								return true;
						}
						if (i == s.length() - 1)
							return true;
						j++;
					} else {
						return false;
					}
				}
				// [j + 1] == '*', 'a' < [j] < 'z', match 0
				else if (p.charAt(j) >= 'a' && p.charAt(j) <= 'z') {
					if (j + 1 < p.length() && p.charAt(j + 1) == '*')
						j++;
					else
						return false;
				}
			}
		}

		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RegularExpressionMatching.isMatch("a", ".");
	}

}
