/*
 * 
 * Given a sorted array of numbers with duplicates
 * move all the duplicates to the end and all the 
 * unique elements to the beginnning
 * 
 * */
	
	public static void rearrangeSort(int[] arr){
		int unique = 1;
		int find = 0;
		while(unique < arr.length) {
			if(unique == 1 && (arr[unique - 1] == arr[unique])){
				find = findMax(arr, arr[unique], unique);
				swap(arr, unique, find);				
			}else if(unique == 1 && (arr[unique] == arr[unique + 1])){
				find = findMax(arr, arr[unique], unique);
				swap(arr, unique + 1, find);				
			}			
			if(unique > 0 && (arr[unique - 1] < arr[unique]) && (arr[unique] < arr[unique + 1])){
				unique++;
			}
			find = findMax(arr, arr[unique], unique);
			System.out.println("Find : " + find);
			if(find == 0) {break;}
		    swap(arr, unique+1, find);
		}					
	}		
	public static int findMax(int[] arr, int target, int index){
		while(index < arr.length) {
			if(arr[index] > target) {return index;}
			index++;
		}
		return 0;
	}		
	public static void swap(int[] arr, int idx1, int idx2){
		int temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;		
	}
