class Solution {
    public int findPeakElement(int[] arr) {
        if(arr == null || arr.length == 0){return 0;}
        int start = 0;
        int end = arr.length - 1;
        while(start < end){
            int mid = start + (end - start)/2;
            if(arr[mid] > arr[mid+1]){
                end = mid;   
            }else if(arr[mid] <= arr[mid+1]){
                start = mid + 1;
            }
        }
    return start;
    }
}
