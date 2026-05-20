class Solution {
     public  int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int maxA = 0;
        int maxB = 0;
        for(int i = 0;i < n ; i++){
            if(A[i] > maxA){
                maxA = A[i];
            }
            if(B[i] > maxB){
                maxB = B[i];
            }
        }
        int[]freqA = new int[maxA];
        int[]freqB = new int[maxB];
        int [] res = new int[n];
        int count = 0;
        for(int i=0;i<n;i++){
            int numA = A[i];
            int numB = B[i];
            freqA[numA-1] +=1;
            freqB[numB-1] +=1;
            if(numA == numB){
                count++;
            }
            else {
                if (freqB[numA - 1] != 0) {
                    count++;
                }

                if (freqA[numB - 1] != 0) {
                    count++;
                }
            }
            res[i] = count;
        }
        return res;
    }
}