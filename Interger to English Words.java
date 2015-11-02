public class Solution {
            //Define some number strings here.
    static String[] big = {"", "Thousand", "Million", "Billion"};
    static String[] small = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    static String[] tens = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    static String[] ones = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    
    public String numberToWords(int num) {
        if(num == 0)    return "Zero";
        
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(num != 0){
            int temp = num % 1000;
            int o = temp % 10, t = (temp / 10) % 10, h = temp / 100;
            StringBuilder s = new StringBuilder();
            
            if(h != 0){
                s.append(ones[h] + " Hundred ");
            }
            if(t == 1){
                s.append(small[o] + " ");
            }else{
                if(t > 1)   s.append(tens[t - 2] + " ");
                if(o > 0)   s.append(ones[o] + " ");
            }
            if(s.length() != 0) s.append(big[i] + " ");
            
            sb.insert(0,s);
            num /= 1000;
            i++;
        }
        
        return sb.toString().trim();
    }
}