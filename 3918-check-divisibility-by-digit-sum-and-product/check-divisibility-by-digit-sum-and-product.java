class Solution {
    public boolean checkDivisibility(int n) {
        int sum = getSum(n);
        return n % sum == 0;
    }
    public static int getSum(int n){
        int s = 0;
        int p = 1;
        while(n != 0){
            int rem = n % 10;
            s += rem;
            p *= rem;
            n /= 10;
        }
        return s + p;
    }
}