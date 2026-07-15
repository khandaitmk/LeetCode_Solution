class Solution {
    public int gcdOfOddEvenSums(int n) {
        int sumOdd = 0;
        int sumEven = 0;
        // int i=1;
        // int evenCount = 0;
        // while(evenCount < n){
        //     if((i&1)==0){
        //         sumEven += i;
        //         evenCount++;
        //     }
        //     i++;
        // }
        // int j = 1;
        // int oddCount = 0;
        // while(oddCount < n){
        //     if((j&1)==1){
        //         sumOdd += j;
        //         oddCount++;
        //     }
        //     j++;
        // }
        sumEven = n*(n+1);
        sumOdd = n*n;
        return gcd(sumEven , sumOdd);
    }
    public static int gcd(int a , int b){
        if(a==0){
            return b;
        }
        if(b==0){
            return a;
        }
        int small = Math.min(a , b);
        int big = Math.max(a , b);
        return gcd(big % small , small);
    }
}