class Solution {
    public void nextPermutation(int[] nums) {
       boolean swapped = false;
        int n = nums.length;
        int min = n-1;
        int pivot = n-1;
        for(int i = n-1 ; i > 0 ; i--){
            if(nums[i] > nums[i - 1]){
                swapped = true;
                pivot = i - 1;
                int start = pivot + 1;
                int end = n-1;
                while(start < end){
                    int temp =  nums[start];
                    nums[start] = nums[end];
                    nums[end] = temp;
                    start++;
                    end--;
                }
                for(int j = pivot+1;j<n;j++){
                    if(nums[j] > nums[pivot]){
                        int temp = nums[j];
                        nums[j] = nums[pivot];
                        nums[pivot] = temp;
                        return;
                    }
                }
            }

        }
        if(!swapped){
            Arrays.sort(nums);
        }
    }
}