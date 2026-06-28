class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        if(arr[0] != 1){
            arr[0] = 1;
        }
        for(int i=1;i<n;i++){
            int diff = Math.abs(arr[i] - arr[i-1]);
            if(diff <= 1){
                continue;
            }else {
                arr[i] = arr[i-1] + 1;
            }
        }
        int max = arr[0];
        for(int num : arr){
            max = Math.max(max , num);
        }
        return max;
    }
}