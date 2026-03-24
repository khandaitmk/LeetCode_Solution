class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int total = n * m;

        int[] flat = new int[total];

        for(int i = 0; i < total; i++){
            int row = i / m;
            int col = i % m;
            flat[i] = grid[row][col] % 12345;
        }

        int[] pre = new int[total];
        int[] suf = new int[total];

        pre[0] = 1;
        for(int i = 1; i < total; i++){
            pre[i] = (pre[i-1] * flat[i-1]) % 12345;
        }

        suf[total-1] = 1;
        for(int i = total-2; i >= 0; i--){
            suf[i] = (suf[i+1] * flat[i+1]) % 12345;
        }

        for(int i = 0; i < total; i++){
            int row = i / m;
            int col = i % m;
            grid[row][col] = (pre[i] * suf[i]) % 12345;
        }

        return grid;
    }
}
