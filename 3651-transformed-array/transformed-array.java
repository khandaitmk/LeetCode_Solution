class Solution {
    public static int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int [] arr = new int[n];
        for(int i=0 ; i<n ; i++){
            int temp = nums[i];
            if(temp == 0){
                arr[i] = nums[i];
            } else if (temp > 0) {
                int index = (i + temp) % n;
                arr[i] = nums[index];
            }else {
                int index = (n - (Math.abs(temp) % n) +i) % n;
                arr[i] = nums[index];
            }

        }
        return arr;
    }

}