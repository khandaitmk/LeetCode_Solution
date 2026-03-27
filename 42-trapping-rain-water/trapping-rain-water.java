class Solution {
    public int trap(int[] height) {
       int n = height.length;
        int[] leftMaxDP = new int[n];
        int[] rightMaxDP = new int[n];
        leftMaxDP[0] = 0;
        rightMaxDP[n-1] = 0;
        for(int i=1;i<n;i++){
            leftMaxDP[i] = Math.max(leftMaxDP[i-1] , height[i-1]);
        }
        for(int i=n-2;i>=0;i--){
            rightMaxDP[i] = Math.max(rightMaxDP[i+1] , height[i+1]);
        }
        int res = 0;
        for(int i=0;i<n;i++){
            int water = Math.min(leftMaxDP[i],rightMaxDP[i]) - height[i];
            if(water > 0){
                res += water;
            }
        }
        return res; 
    }
    
}