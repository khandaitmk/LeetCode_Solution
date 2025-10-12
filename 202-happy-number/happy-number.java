class Solution {
    public boolean isHappy(int n) {
       int slow = n;
       int fast = n;
       do{
            slow = getSquare(slow);
            fast = getSquare(getSquare(fast));
       }while(slow != fast);
        if(slow == 1){
            return true;
        }
        return false;
    }
    public static int getSquare(int num){
        int k=num;
        int sum=0;
        while(k>0){
            int l = k%10;
            sum = sum +(l*l);
            k/=10;
        }
        return sum;
    }
}