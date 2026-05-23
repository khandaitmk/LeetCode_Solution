class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
         Arrays.sort(happiness);
        int decFactor = 0;
        int n = happiness.length;
        int i = n-1;
        long sum = 0;
        while(k != 0){
            long num = happiness[i];
            long tempSum = happiness[i] - decFactor;
            if(num > 0 && tempSum > 0){
                sum += happiness[i] - decFactor;
            }
            decFactor++;
            k--;
            i--;
        }
        return sum;
    }
}