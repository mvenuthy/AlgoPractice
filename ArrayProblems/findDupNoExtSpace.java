    public List<Integer> findDuplicates(int[] nums){
        List<Integer> result = new ArrayList<Integer>();
        if(nums.length < 1 || nums == null){return result;}
        for(int i = 0; i < nums.length; i++){
            if(nums[Math.abs(nums[i])] > 0 && nums[Math.abs(nums[i])] <= nums.length){
                nums[Math.abs(nums[i])] = -nums[Math.abs(nums[i])];
            }else{
                result.add(nums[Math.abs(nums[i])]);
            }   
        }
        return result;
    }
