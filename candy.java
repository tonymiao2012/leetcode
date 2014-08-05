package leetcode;

public class candy {
	public static int candy(int[] ratings) {
		// scan ratings twice: from left to right and from right to left. Ensure
		// higer rater has more candy than their neighbor.
		if (ratings == null || ratings.length == 0) {
			return 0;
		}
		int[] candy = new int[ratings.length];
		int result = 0;
		// all people has at least one candy
		for (int i = 0; i < ratings.length; i++) {
			candy[i] = 1;
		}
		// scan from left to right
		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i - 1] < ratings[i]) {
				candy[i] = candy[i - 1] + 1;
			}
		}
		// scan from right to left
		for (int i = ratings.length - 2; i >= 0; i--) {
			if (ratings[i + 1] < ratings[i] && candy[i] <= candy[i + 1]) {
				candy[i] = candy[i + 1] + 1;
			}
		}
		for (int i = 0; i < candy.length; i++) {
			result += candy[i];
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ratings = {1,2};
		int result = candy.candy(ratings);
		System.out.println(result);
	}

}
