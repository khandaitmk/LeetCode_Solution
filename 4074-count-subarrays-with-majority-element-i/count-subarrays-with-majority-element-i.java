class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int count = 0;
        int[] arr = new int[n+1];
        arr[0] = 0;
        for(int i=1;i<n+1;i++){
            if(nums[i-1] == target){
                arr[i] = arr[i-1]+1;
            }else{
                arr[i] = arr[i-1];
            }
        }
        for(int i=0;i<n;i++){
            for(int j = i;j<n;j++){
                int tempCount = arr[j+1] - arr[i];
                if(tempCount > (j- i + 1)/2){
                    count++;
                }
            }
        }
        return count;
    }
    public static boolean isValid(int[] nums , int start , int end , int target){
        int count = 0;
        for(int i = start;i <= end;i++){
            if(nums[i] == target){
                count++;
            }
        }
        int n = end - start + 1;
        if(count > (n/2)) return true;
        return false;
    }
}