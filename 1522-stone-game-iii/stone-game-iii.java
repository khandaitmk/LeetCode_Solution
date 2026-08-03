class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;

        Integer[] dp = new Integer[n];

        int diff = helper(stoneValue, 0, dp);

        if (diff > 0) {
            return "Alice";
        } else if (diff < 0) {
            return "Bob";
        } else {
            return "Tie";
        }
    }
    public static int helper(int[] arr , int idx , Integer[] dp ){
        if(idx == arr.length){
            return 0;
        }
        if (dp[idx] != null) {
            return dp[idx];
        }
        int sum = 0;
        int max = Integer.MIN_VALUE;

        for(int i=idx;i<arr.length && i <idx+3;i++){

            sum += arr[i];
            int diff = sum - helper(arr , i+1 , dp);
            max = Math.max(max , diff);
        }
        return dp[idx] = max;
    }
}