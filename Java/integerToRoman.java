package leetcode;

public class integerToRoman {
	public static String integertoroman(int num) {
		//
		String result = "";
		int[] numradix = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		String[] roman = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X",
				"IX", "V", "IV", "I" };
		for (int i = 0; num > 0; i++) {
			int count = num / numradix[i];
			num = num % numradix[i];
			for (; count > 0; --count) {
				result += roman[i];
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(integerToRoman.integertoroman(1));
	}

}
