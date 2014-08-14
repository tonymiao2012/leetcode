package dataStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class findDup {
	public int findDup1(int[] a) {
		// time complexity: O(NlogN). Space complexity: O(1), array is mutable.
		int result = -1;
		// check input.
		if (a.length == 0)
			return result;
		Arrays.sort(a);

		// find the duplicate number after sorting.
		for (int i = 1; i < a.length; i++) {
			if (a[i - 1] == a[i])
				result = a[i];
		}

		return result;

	}

	public int findDup2(int[] a) {
		// array is immutable. Time complexity: O(N) worst case. Space
		// complexity: O(N) worst case.
		int result = -1;
		ArrayList<Integer> list = new ArrayList<Integer>(a.length);
		for (int i = 0; i < a.length; i++) {
			if (list.contains(a[i])) {
				result = a[i];
				break;
			} else {
				list.add(a[i]);
			}
		}
		return result;
	}

	public int findDup3(int[] a) {
		// if no duplicate number, sum 0f 1 - 1,000,000 numbers will be:
		// (1,000,000)*(1,000,000 + 1)/2 = 500,000 * 1,000,001 =
		// 500,000,500,000.
		long tmp = 500000500000l;
		long curSum = 0;
		for (int i = 0; i < a.length; i++) {
			curSum += a[i];
		}

		int result = (int) (curSum - tmp);
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<Integer>(1000001);
		for (int i = 0; i < 1000000; i++) {
			list.add(i + 1);
		}
		list.add(10000);

		Collections.shuffle(list);

		// get random array for test.
		int[] a = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			a[i] = list.get(i);
		}
		findDup find = new findDup();
		
		long begin1 = System.currentTimeMillis();
		System.out.println(find.findDup1(a));
		long end1 = System.currentTimeMillis();
		System.out.println("First function runtime: " + (end1 - begin1) / 1000f
				+ " seconds");

		long begin2 = System.currentTimeMillis();
		System.out.println(find.findDup2(a));
		long end2 = System.currentTimeMillis();
		System.out.println("Second function runtime: " + (end2 - begin2)
				/ 1000f + " seconds");

		long begin3 = System.currentTimeMillis();
		System.out.println(find.findDup3(a));
		long end3 = System.currentTimeMillis();
		System.out.println("Third function runtime: " + (end3 - begin3) / 1000f
				+ " seconds");
	}

}
