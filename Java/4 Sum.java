public class Solution {
    /**
     * @param numbers : Give an array numbersbers of n integer
     * @param target : you need to find four elements that's sum of target
     * @return : Find all unique quadruplets in the array which gives the sum of
     *           zero.
     */
    public ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) {
        /* your code */
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        HashSet<ArrayList<Integer>> set = new HashSet<>();
        if(numbers == null || numbers.length == 0){
            return res;
        }
        
        Arrays.sort(numbers);
        for(int i = 0; i < numbers.length - 3; i++){
            for(int j = i + 1; j < numbers.length - 2; j++){
                if(j == i + 1 || numbers[j] != numbers[j - 1]){
                    int k = j + 1, l = numbers.length - 1;
                
                    while(k < l){
                        int num = numbers[i] + numbers[j] + numbers[k] + numbers[l];
                        if(num < target){
                            k++;
                        }else if(num > target){
                            l--;
                        }else{
                            ArrayList<Integer> tmp = new ArrayList<>();
                            tmp.add(numbers[i]);
                            tmp.add(numbers[j]);
                            tmp.add(numbers[k]);
                            tmp.add(numbers[l]);
                            if(!set.contains(tmp)){
                                res.add(tmp);
                                set.add(tmp);
                            }
                            k++;
                            l--;
                            
                            while(k < l && numbers[k] == numbers[k - 1]){
                                k++;
                            }
                            while(l > k && numbers[l] == numbers[l + 1]){
                                l--;
                            }
                        }
                    }
                }
            }
        }
        
        return res;
    }
}