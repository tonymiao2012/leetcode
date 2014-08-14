package dataStructure;

import java.util.HashMap;
import java.util.Random;

public class firstChar {
	public char findFirst(String s) {
		// Use hashmap to solve this problem instead of array. Assume you use
		// array for counting the appearence of characters in string.
		// if we have a Unicode string, we would need to have 65,536 elements
		// (assuming a 16 bit Unicode encoding) in our array to account for
		// every possible character that could be in the string – whether or not
		// it is actually in the string. This is because we simply do not know
		// what is going to be in the string that’s being passed in – but with
		// an array we have to be ready to accept all possible values. But for
		// an ASCII string, an array would really only need 128 elements,
		// because there are only 128 possible ASCII values.
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		if (s.length() == 0)
			return 0;

		for (int i = 0; i < s.length(); i++) {
			char key = s.charAt(i);
			if (!hm.containsKey(key)) {
				hm.put(key, 1);
			} else {
				int val = hm.get(key);
				hm.put(key, val + 1);
			}
		}
		char result = 0;
		for (Character c : hm.keySet()) {
			if (hm.get(c) == 1) {
				result = c;
				break;
			}
		}

		return result;
	}
	
	public void shuffle(int[] a){
		//use random function to deal with this problem. 
		int tmp, index;
		Random r = new Random();
		for(int i = a.length - 1; i > 0; i--){
			index = r.nextInt(i + 1);
			tmp = a[index];
			a[index] = a[i];
			a[i] = tmp;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "DEEFGDD";
		firstChar fc = new firstChar();
		System.out.println(fc.findFirst(s));
		
		//shuffle test
		int[] a = new int[52];
		for(int i = 0; i < 52; i++){
			a[i] = i + 1;
		}
		
		fc.shuffle(a);
		
		for(int i = 0; i < 52; i++){
			System.out.println(a[i]);
		}
		
	}

}
