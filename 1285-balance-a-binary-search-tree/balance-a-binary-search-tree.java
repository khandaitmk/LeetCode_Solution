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
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<TreeNode> a = new ArrayList<>();
        inorderForBalance(root,a);
        return balanceBST(a,0,a.size()-1);
    }
    static TreeNode balanceBST(ArrayList<TreeNode> a,int start ,int end){
        if(start > end){
            return null;
        }
        int mid = start +(end-start)/2;
        TreeNode root = a.get(mid);
        root.left = balanceBST(a, start , mid-1);
        root.right = balanceBST(a, mid+1 , end);
        return root;
    }
    static void inorderForBalance(TreeNode root,ArrayList<TreeNode> a){
        if(root == null){
            return;
        }
        inorderForBalance(root.left,a);
        a.add(root);
        inorderForBalance(root.right,a);
    }
}