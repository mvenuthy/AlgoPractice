class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 1){return nums[0];}
        int prevSum = nums[0];
        int maxSum = nums[0];
        for(int i = 1; i < nums.length; i++){
            prevSum = nums[i] + (prevSum <= 0 ? 0 : prevSum);
            maxSum = (prevSum > maxSum ? prevSum : maxSum);            
        }
        return maxSum;
    }
}
