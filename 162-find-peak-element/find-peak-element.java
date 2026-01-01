class Solution {
    public int findPeakElement(int[] nums) {
        int n=nums.length;
        int start=0;
        int end=n-1;
        while(start<end){
            int mid=start+(end-start)/2;
            if(mid+1<n && nums[mid]<nums[mid+1]){
                start=mid+1;
            }else{
                end=mid;
            }
        }
        return start;
    }
}