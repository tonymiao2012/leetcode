class Solution {
    /*
     * param n: As desciption
     * return: An integer, denote the number of trailing zeros in n!
     */
    public long trailingZeros(long n) {
        // write your code here. 2, 5, 10
        if(n == 0){
            return 1;
        }
        HashMap<Integer, Long> map = new HashMap<>();
        map.put(2, 0l);
        map.put(5, 0l);
        long count = 0l;
        while(n > 0){
            if(n % 2 == 0){
                long temp = n;
                long count2 = 0;
                while(temp % 2 == 0){
                    temp /= 2;
                    count2++;
                }
                map.put(2, map.get(2) + count2);
            }
            if(n % 5 == 0){
                long temp = n;
                long count5 = 0;
                while(temp % 5 == 0){
                    temp /= 5;
                    count5++;
                }
                map.put(5, map.get(5) + count5);    
            }
            n--;
        }
        count = Math.min(map.get(2), map.get(5));
        return count;
    }
};
