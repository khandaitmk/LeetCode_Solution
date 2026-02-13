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
    public boolean isSymmetric(TreeNode root) {
        // ArrayList<Integer> a1 = new ArrayList<>();
        // ArrayList<Integer> a2 = new ArrayList<>();
        // inorder(root.left , a1);
        // inorder(root.right , a2);
        // return a1.reversed().equals(a2);
        if(root == null){
            return true;
        }
        return helper(root.left ,root.right);
    }
    static boolean helper(TreeNode r1 , TreeNode r2){
        if(r1 == null && r2 == null) return true;
        if(r1 == null || r2 == null) return false;

        return (r1.val == r2.val) && helper(r1.left, r2.right) && helper(r1.right , r2.left);
    }
    static void inorder(TreeNode root , ArrayList<Integer> a){
        if(root == null){
            return ;
        }
        inorder(root.left , a);
        a.add(root.val);
        inorder(root.right , a);
    }
}