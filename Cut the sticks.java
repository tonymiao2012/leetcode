import java.io.*;
import java.util.*;

public class Solution {
    public static List<Integer> numberAfterCut(int[] woods){
        if(woods == null || woods.length == 0){
            return null;
        }
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < woods.length; i++){
            if(woods[i] == 0){
                continue;
            }
            result.add(woods.length - i);
            int tmp = woods[i];
            for(int j = i; j < woods.length; j++){
                woods[j] -= tmp;
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); 
        int[] woods = new int[n];
        for (int i = 0; i < n; i++){
            woods[i] = sc.nextInt();
        }
        sc.close();
        
        Arrays.sort(woods);
        List<Integer> list = numberAfterCut(woods);
        
        for(int i : list){
            System.out.println(i);
        }
    }
}