class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingDouble( o -> o[1]));
        int maxLength = 0;
        maxLength = 1;
        int last = pairs[0][1];
        for(int i=1;i<pairs.length;i++){
            if(last < pairs[i][0]){
                maxLength++;
                last = pairs[i][1];
            }
        }
        return maxLength;
    }
}