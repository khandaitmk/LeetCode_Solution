class Solution {
    public int minimumPushes(String word) {
        int threshold = 8;
        int n = word.length();
        int weight = 1;
        int res = 0;
        for(int i=0;i<n;i++){
            if(i == threshold){
                threshold += 8; 
                weight += 1;
            }
            res += weight;
        }
        return res;
    }
}