/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        if(root == p || root == q){
            return root;
        }
        TreeNode n1 = lowestCommonAncestor(root.left , p ,q);
        TreeNode n2 = lowestCommonAncestor(root.right , p ,q);
        if(n1 == null){
            return n2;
        }
        if(n2 == null){
            return n1;
        }
        return root;
    }
}