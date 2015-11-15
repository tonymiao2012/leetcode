public class Solution {
    /** 
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     */
    public int search(int[] A, int target) {
        // write your code here
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < A.length; i++){
            list.add(A[i]);
        }
        
        if(list.contains(target)){
            return list.indexOf(target);
        }else{
            return -1;
        }
    }
    
}

