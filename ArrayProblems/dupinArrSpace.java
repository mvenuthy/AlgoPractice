class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> count = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(count.containsKey(nums[i]) != true){
                int numCount = 1;
                count.put(nums[i], numCount);
            }else{
               count.put(nums[i], count.get(nums[i]) + 1);    
            }            
        }        
        for(int i = 0; i < nums.length; i++){
            if(count.get(nums[i]) > 1 && (!result.contains(nums[i]))){
                result.add(nums[i]);
            }
        }    
        return result;
    }
}
