class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int [] count = new int[n];
        int res = 0;
        for(int i=0;i<n;i++){
            int tempCount = 0;
            for(int j = n-1 ;j >=0;j--){
                if(grid[i][j] == 0){
                    tempCount++;
                }else {
                    break;
                }
            }
            count[i] = tempCount;
        }
        for(int i = 0; i < n; i++){
            int reqCount = n - 1 - i;

            // find row that satisfies
            int j = i;
            while(j < n && count[j] < reqCount){
                j++;
            }

            if(j == n) return -1;

            while(j > i){
                swap(count, j, j-1);  
                res++;
                j--;
            }
        }
        return res;
    }
    public static void swap(int[] arr , int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }
}