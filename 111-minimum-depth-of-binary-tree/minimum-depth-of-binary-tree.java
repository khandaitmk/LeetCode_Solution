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
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int h1 = minDepth(root.left);
        int h2 = minDepth(root.right);
        int h = 0;
        if(h1 == 0 && h2 == 0){
            h = 1;
        }
        if(h1 == 0){
             h = h2 + 1;
        }
        if(h2 == 0) {
             h = h1 + 1;
        }
        if(h1 != 0 && h2 != 0){
            h = Math.min(h1 ,h2)+1;
        }
        return h;
    }
}