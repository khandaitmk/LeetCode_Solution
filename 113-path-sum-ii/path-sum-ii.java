/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        sum(root , temp , res , 0 , targetSum);
        return res;
    }
    public static void sum(TreeNode root , List<Integer> temp , List<List<Integer>> res , int tSum , int targetSum){

        if(root == null){
            return;
        }
        temp.add(root.val);
        tSum +=root.val;
        if(tSum == targetSum && root.left == null && root.right == null){
            res.add(new ArrayList<>(temp));
        }
        sum(root.left , temp , res , tSum , targetSum);
        sum(root.right , temp , res,tSum , targetSum);
        temp.remove(temp.size() - 1);
    }
}