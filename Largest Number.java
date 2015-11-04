public class Solution {
    public String largestNumber(int[] nums) 
    {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> list = new ArrayList<String>(nums.length);
        
        for(int i : nums)   list.add(String.valueOf(i));
        Collections.sort(list,new StringCompare());
        
        for(String s : list)    sb.append(s);
        
        //boundry case
        String res = sb.toString();
        if(res.length() > 0 && res.charAt(0) == '0')  return "0";
        
        return sb.toString();
    }
    
    
}

class StringCompare implements Comparator<String>
{
    public int compare(String a, String b)
    {
        if(a.length() == b.length())
            return b.compareTo(a);
        else{
            String ba = b + a;
            String ab = a + b;
            return ba.compareTo(ab);
        }
    }
}
