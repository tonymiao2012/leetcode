package leetcode;

public class CountAndSay {
	public static String countAndSay(int n) {
        
        StringBuilder s = new StringBuilder("1");
        while(n-- > 1){
            int count = 1;
            StringBuilder temp = new StringBuilder();
            for(int i = 1; i < s.length();i++){
                if(s.charAt(i - 1) == s.charAt(i)){
                    count++;
                }else{
                    temp.append(count);
                    temp.append(s.charAt(i - 1));
                    count = 1;
                }
            }
            //deal with the remains
            temp.append(count);
            temp.append(s.charAt(s.length() - 1));
            s = temp;
        }
        return s.toString();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(CountAndSay.countAndSay(1));
	}

}
