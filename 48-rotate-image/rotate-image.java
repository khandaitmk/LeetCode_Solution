class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        //trnspose of the matrix
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                if(i != j){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
        for(int i=0;i<n;i++){
            reverseRow(matrix[i]);
        }
    }
    public static void reverseRow(int[] arr){
        int n = arr.length;
        int start = 0;
        int end = n-1;
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}