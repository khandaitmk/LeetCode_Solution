class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int n = mat[0].length;
        int[][] copy = new int[mat.length][n];
        for (int i = 0; i < mat.length; i++) {
            copy[i] = mat[i].clone();
        }
        k = k % n;
        if(k==0) return true;
        for(int i=0;i< mat.length;i++){
            if(i % 2 == 0){
                reverse(mat[i],0,k-1);
                reverse(mat[i],k,n-1);
                reverse(mat[i],0,n-1);
            }else{
                reverse(mat[i],0,n-1);
                reverse(mat[i],0,k-1);
                reverse(mat[i],k,n-1);
            }
        }
        return Arrays.deepEquals(copy , mat);
    }
    public static void reverse(int[] arr , int start , int end){
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}