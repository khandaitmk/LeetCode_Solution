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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        return calculate(root,targetSum , 0);
    }
    static boolean calculate(TreeNode root, int targetSum ,int sum){
        if(root == null){
            return false;
        }
        sum +=root.val;
        if(root.left == null && root.right == null){
            if(targetSum == sum){
                return true;
            }
            return false;
        }
        boolean b1 = calculate(root.left,targetSum,sum);
        boolean b2 = calculate(root.right,targetSum,sum);
        return (b1 || b2);
    }
}