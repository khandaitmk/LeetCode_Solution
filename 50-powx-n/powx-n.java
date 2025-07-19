class Solution {
    public double myPow(double x, int n) {
        int N=n;
        if(n<0){
            N=-n;
            x=1/x;
        }
        return pow(x,N);
    }
    static double pow(double x,int n){
        if(n==0){
            return 1;
        }
        double halfSq=pow(x,n/2);
        double fullSq=halfSq*halfSq;
        if(n%2!=0){
            fullSq=x*fullSq;
        }
            return fullSq;
    }
}