package leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class LRUcache {
	private HashMap<Integer, Integer> cache;
	private HashMap<Integer, Integer> num;

	public void LRUCache(int capacity) {

		this.cache = new HashMap<Integer, Integer>(capacity);
		this.num = new HashMap<Integer, Integer>(capacity);
	}

	public int get(int key) {

		int result = -1;
		if (cache.containsKey(key)) {
			int value = cache.get((int) key);
			int record = num.get((int) key);
			record += 1;
			num.put(key, record);
			return value;
		}
		return result;
	}

	public void set(int key, int value) {
		// replace the least use item in cache. num[i] = 0.

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
