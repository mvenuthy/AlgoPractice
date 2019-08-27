class Solution {
    public boolean search(int[] arr, int target) {
        if(arr == null || arr.length < 1){return false;}
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] == target){return true;}
            if(arr[start] < arr[mid]){
                if(target < arr[start] || target > arr[mid]){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }else if (arr[start] > arr[mid]){
                if(target < arr[mid] || target > arr[end]){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }else{
                start++;
            }
        }
        return false;
    }
}
