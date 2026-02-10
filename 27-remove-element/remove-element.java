class Solution {
    public int removeElement(int[] nums, int val) {
    int n = nums.length;
        int start = 0;
        int last = n-1;
        int count = 0;
        while(start <= last){
            if(nums[start] == val){
                if(nums[last] != val){
                    swap(nums,start,last);
                    count++;
                    start++;
                    last--;
                }else{
                    last--;
                }
            }
            else {
                start++;
            }
        }
        return start;
    }
     static void swap(int [] arr ,int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}