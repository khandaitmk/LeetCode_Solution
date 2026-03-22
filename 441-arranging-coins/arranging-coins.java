class Solution {
    public int arrangeCoins(int n) {
         int i = 1;
        int completed = i;
        while(n >= i){
            n = n - i;
            completed = i;
            i++;
        }
        return completed;
    }
}