class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        helper(image , sr , sc , color , image[sr][sc]);
        return image;
    }
    public static void helper(int[][] image , int i , int j , int color , int ori){
        if(i<0 || i == image.length || j == image[i].length ||j<0 || image[i][j]!= ori){
            return;
        }

        if(image[i][j] != color){
            image[i][j] = color;
        }else{
            return;
        }
        // up
        helper(image , i-1 , j , color , ori);
        // right
        helper(image , i , j+1 , color , ori);
        // down
        helper(image , i+1 , j , color, ori);
        // right
        helper(image , i , j-1 , color, ori);
    }
}