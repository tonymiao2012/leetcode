class Solution {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        // write your code here
        //Time complexity: O(N), Space complexity: O(k)
        if(colors == null || colors.length == 0 || k == 0)  return;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for(int num : colors){
            if(!map.containsKey(num)){
                map.put(num, 1);
            }else{
                map.put(num, map.get(num) + 1);
            }
        }
        int i = 0;
        for(int key : map.keySet()){
            int number = map.get(key);
            while(number > 0){
                colors[i] = key;
                number--;
                i++;
            }
        }
        
    }
}