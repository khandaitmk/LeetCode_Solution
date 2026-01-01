class Solution {
    
    public static int search(int[] nums,int target){
        int n= nums.length;
        int start = 0;
        int end = n-1;
        while(start <= end){
            int mid  = start +(end-start)/2;
            if(nums[mid] == target ){
                return mid;
            }
            if (nums[start] <= nums[mid]){ //means the left part of the array is sorted
                if(target < nums[mid] && target >= nums[start]){
                    end = mid-1;
                }else {
                    start = mid+1;
                }
            } else{
                if(target > nums[mid] && target <= nums[end]){
                    start = mid+1;
                }else {
                    end = mid-1;
                }
            }
        }
        return -1;
    }
}