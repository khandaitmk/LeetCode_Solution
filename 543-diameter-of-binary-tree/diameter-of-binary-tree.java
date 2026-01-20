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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        int ld = diameterOfBinaryTree(root.left);
        int lh = height(root.left);
        int rd = diameterOfBinaryTree(root.right);
        int rh = height(root.right);
        int selfDiameter = lh + rh ;
        return Math.max(selfDiameter,Math.max(ld,rd));
    }
    public static int height(TreeNode root){
        if(root == null){
            return 0;
        }
        int h1 = height(root.left);
        int h2 = height(root.right);
        return Math.max(h1,h2)+1;

    }
}