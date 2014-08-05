package leetcode;

import java.util.ArrayList;
import java.util.Collections;

public class triangle {
	public static int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {

		ArrayList<Integer> list = new ArrayList<Integer>();
		int result = 0;
		if (triangle.size() == 0)
			return result;

		for (int i = 0; i < triangle.size(); i++) {
			ArrayList<Integer> tmp = triangle.get(i);
			Collections.sort(tmp);
			list.add(tmp.get(0));
		}

		for (int i : list) {
			result += i;
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> l1 = new ArrayList<Integer>();
		l1.add(2);
		ArrayList<Integer> l2 = new ArrayList<Integer>();
		l2.add(3);
		l2.add(4);
		ArrayList<Integer> l3 = new ArrayList<Integer>();
		l3.add(6);
		l3.add(5);
		l3.add(7);
		ArrayList<Integer> l4 = new ArrayList<Integer>();
		l4.add(4);
		l4.add(1);
		l4.add(8);
		l4.add(3);
		triangle.add(l1);
		triangle.add(l2);
		triangle.add(l3);
		triangle.add(l4);
		System.out.println(minimumTotal(triangle));

	}

}
