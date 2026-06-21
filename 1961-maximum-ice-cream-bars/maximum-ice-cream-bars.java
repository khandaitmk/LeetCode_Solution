class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int count = 0;
        for(int num : costs){
            if(num <= coins){
                count++;
                coins -= num;
            }
        }
        return count;
    }
}