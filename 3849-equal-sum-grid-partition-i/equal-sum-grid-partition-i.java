class Solution {
    public boolean canPartitionGrid(int[][] grid) {
       int n = grid.length;
        int m = grid[0].length;
        int [] vertical = new int[n];
        int [] horizontal = new int[m];
        long  totalSum = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                totalSum += grid[i][j];
            }
        }
        for(int i=0;i<n;i++){
            calculateVerticalSum(i,grid,vertical,m);
        }
        for(int i=0;i<m;i++){
            calculateHorizontalSum(i,grid,horizontal,n);
        }
        long temp = 0;
        for(int i=0;i<n-1;i++){
            temp += vertical[i];
            long temp2 = totalSum - temp;
            if(temp2 == temp){
                return true;
            }
        }
         temp = 0;
        for(int i=0;i<m-1;i++){
            temp += horizontal[i];
            long temp2 = totalSum - temp;
            if(temp2 == temp){
                return true;
            }
        }

        return false;
    }
    public static void calculateHorizontalSum(int k,int[][] arr , int [] sum,int n){
        for(int i=0;i<n;i++){
            sum[k] += arr[i][k];
        }
    }
    public static void calculateVerticalSum(int k,int[][] arr , int [] sum,int n){
        for(int i=0;i<n;i++){
            sum[k] += arr[k][i];
        }
    }
}