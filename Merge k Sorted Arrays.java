class Element{
    public int row, col, val;
    Element(int row, int col, int val){
        this.row = row;
        this.col = col;
        this.val = val;
    }
}

public class Solution {
    /**
     * @param arrays k sorted integer arrays
     * @return a sorted array
     */
    private Comparator<Element> ElemComparator = new Comparator<Element>(){
        public int compare(Element left, Element right){
            return left.val - right.val;
        }
    };
    
    public int[] mergekSortedArrays(int[][] arrays){
        if(arrays == null){
            return new int[0];
        }  
        
        PriorityQueue<Element> queue = new PriorityQueue<>(arrays.length,
                                                           ElemComparator);
        int totalLen = 0;
        for(int i = 0; i < arrays.length; i++){
            if(arrays[i].length > 0){
                Element tmp = new Element(i, 0, arrays[i][0]);
                queue.add(tmp);
                totalLen += arrays[i].length;
            }
        }
        int[] res = new int[totalLen];
        int index = 0;
        while(!queue.isEmpty()){
            Element curMin = queue.poll();
            res[index] = curMin.val;
            index++;
            if(curMin.col + 1 < arrays[curMin.row].length){
                curMin.col += 1;
                curMin.val = arrays[curMin.row][curMin.col];
                queue.add(curMin);
            }
        }
        
        return res;
    }
 }