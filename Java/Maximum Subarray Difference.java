public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer indicate the value of maximum difference between two
     *          Subarrays
     */
    public int maxDiffSubArrays(int[] nums) {
        // write your code here
        int max = Integer.MIN_VALUE;
        if (nums.length <2) {
            return 0;
        }
        int n = nums.length;
        int[] leftMax = new int[n];
        int[] leftMin = new int[n];

        int localMax = 0; int localMin = 0;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            
            localMax = Math.max(num + localMax, num);
            localMin = Math.min(num + localMin, num);
            if (i == 0) {
                leftMax[i] = localMax;
                leftMin[i] = localMin;
            } else {
                leftMax[i] = Math.max(localMax, leftMax[i-1]);
                leftMin[i] = Math.min(localMin, leftMin[i-1]);
            }
        }

        localMax = 0; localMin = 0;
        int lastMax = 0, lastMin = 0;
        for (int i = n-1; i > 0; i--) {
            int num = nums[i];
            localMax = Math.max(num + localMax, num);
            localMin = Math.min(num + localMin, num);
            if (i == n-1) {
                lastMax = localMax;
                lastMin = localMin;
            } else {
                lastMax = Math.max(localMax, lastMax);
                lastMin = Math.min(localMin, lastMin);
            }
            max = Math.max(Math.max(Math.abs(leftMax[i-1]-lastMin), 
                Math.abs(lastMax - leftMin[i-1])), max);
        }
        return max;
    }
}

