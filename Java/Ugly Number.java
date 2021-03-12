class Solution {
    /**
     * @param k: The number k.
     * @return: The kth prime number as description.
     */
    public long kthPrimeNumber(int k) {
        // write your code here
        Queue<Long> queue = new PriorityQueue<>();
        HashMap<Long, Boolean> inQueue = new HashMap<>();
        Long[] primes = new Long[3];
        primes[0] = Long.valueOf(3);
        primes[1] = Long.valueOf(5);
        primes[2] = Long.valueOf(7);
        for(int i = 0; i < 3; i++){
            queue.add(primes[i]);
            inQueue.put(primes[i], true);
        }
        Long number = Long.valueOf(0);
        
        for(int i = 0; i < k; i++){
            number = queue.poll();
            for(int j = 0; j < 3; j++){
                if(!inQueue.containsKey(primes[j] * number)){
                    queue.add(number * primes[j]);
                    inQueue.put(number * primes[j], true);
                }
            }
        }
        
        return number;
    }
};
