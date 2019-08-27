public static void leaders(int[] nums){
		if(nums == null || nums.length < 1){return;}
		int rightmostMax = nums[nums.length - 1];
		System.out.println(rightmostMax);
		for(int i = nums.length - 2; i >= 0; i--) {
				if(nums[i] > rightmostMax) {
					rightmostMax = nums[i];
					System.out.println(rightmostMax);
				}		
		}		
	}
}
