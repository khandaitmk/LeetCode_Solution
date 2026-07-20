class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> res = new ArrayList<>();
        helper(grid , k, res);
        return res;

    }
    public static void helper(int[][] grid , int k , List<List<Integer>> res){
        int n =grid.length;
        if(k==0){
            for(int i=0;i<grid.length;i++){
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j = 0;j<grid[i].length;j++){
                    temp.add(grid[i][j]);
                }
                res.add(new ArrayList<>(temp));
            }
            return;
        }
        int[][] temp = new int[grid.length][grid[0].length];
        for(int i=0;i< grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(j+1 < grid[i].length){
                    temp[i][j+1] = grid[i][j];
                }
            }
        }

        for(int i=0;i< grid.length;i++){
            if(i+1<n){
                temp[i+1][0] = grid[i][grid[i].length-1];
            }
        }

        temp[0][0] = grid[n-1][grid[0].length-1];
        helper(temp , k-1 , res);
    }
}