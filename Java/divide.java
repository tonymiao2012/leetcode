package leetcode;

public class divide {
	public static int divide(int dividend, int divisor) {
		// assume divisor is not zero.
		int result = 0;
		boolean sign = true;
		if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
			sign = false;
		}
		/*
		 * long a = dividend; long b = divisor; if (a < 0) a = -a; if (b < 0) b
		 * = -b;
		 */
		long a = Math.abs((long)dividend);
		long b = Math.abs((long)divisor);
		// divisor multiply.
		while (a >= b) {
			int mult = 1;
			long temp = b;
			while (a >= temp) {
				a -= temp;
				result += mult;
				temp += temp;
				mult += mult;
			}
		}
		if (!sign) {
			return -result;
		} else {
			return result;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		divide.divide(-2147483648, 1);
	}

}
