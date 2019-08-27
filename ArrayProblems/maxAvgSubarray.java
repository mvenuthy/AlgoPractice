class Solution {
    public double findMaxAverage(int[] nums, int k) {
        if (k > nums.length) {return 0;}
        double sum = 0;
        double maxSum = 0;
        for(int i = 0; i < k; i++){
            sum = sum + nums[i];
        }
        maxSum = sum;
        for(int i = k; i < nums.length; i++){
            sum = sum - nums[i -k] + nums[i];            
            maxSum = Math.max(sum,maxSum);            
        }        
     return maxSum/k;
    }
}
