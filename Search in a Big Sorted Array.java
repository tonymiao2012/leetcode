/**
 * Definition of ArrayReader:
 * 
 * class ArrayReader {
 *      // get the number at index, return -1 if not exists.
 *      public int get(int index);
 * }
 */
public class Solution {
    /**
     * @param reader: An instance of ArrayReader.
     * @param target: An integer
     * @return : An integer which is the index of the target number
     */
    public int searchBigSortedArray(ArrayReader reader, int target) {
        // write your code here
        int end = 0;
        while(reader.get(end) != -1 && reader.get(end) < target){
            end = end * 2 + 1;
        }
        
        int start = 0;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(reader.get(mid) == -1 || reader.get(mid) >= target){
                end = mid;
            }else{
                start = mid;
            }
        }
        
        if(reader.get(start) == target){
            return start;
        }
        
        if(reader.get(end) == target){
            return end;
        }
        
        return -1;
    }
}
