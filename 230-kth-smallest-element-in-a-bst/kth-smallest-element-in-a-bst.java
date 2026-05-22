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
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        inOrder(root , pq);
        for(int i=1;i<k;i++){
            pq.remove();
        }
        return pq.remove();
    }
    public static void inOrder(TreeNode root , PriorityQueue<Integer> pq){
            if(root == null) return;
            inOrder(root.left , pq);
            pq.add(root.val);
            inOrder(root.right , pq);
    }
}