class Solution {
    public long gcdSum(int[] nums) {
         int n = nums.length;
        int[] preMax = new int[n];
        for(int i=0;i<n;i++){
            if(i==0){
                preMax[i] = nums[i];
            }else{
                preMax[i] = Math.max(preMax[i-1] , nums[i]);
            }
        }
        int[] prefixGCD = new int[n];
        for(int i=0;i<n;i++){
            prefixGCD[i] = gcd(nums[i] , preMax[i]);
        }
        Arrays.sort(prefixGCD);

        int start = 0;
        int end = n-1;
        long sum = 0;
        while(start < end){
            int a = prefixGCD[start++];
            int b = prefixGCD[end--];
            sum += gcd(a ,b);

        }
        return sum;
    }
    public static int gcd(int a , int b){
        if(a==0) return b;
        if(b==0) return a;
        return gcd(b%a , a);
    }
}