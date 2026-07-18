class Solution {
    public int findGCD(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int num : nums){
            min = Math.min(min , num);
            max = Math.max(max , num);
        }
        return gcd(min , max);
    }
    public static int gcd(int a , int b){
        if(a==0)return b;
        if(b==0) return a;
        return gcd(b%a , a);
    }
}