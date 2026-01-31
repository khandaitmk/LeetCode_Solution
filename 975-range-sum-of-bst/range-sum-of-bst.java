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
    public int rangeSumBST(TreeNode root, int low, int high) {
        // int sum = 0;
        // ArrayList<Integer> list = new ArrayList<>();
        // inorderTraversal(root,list);
        // for(int i=0; i<list.size() ;i++){
        //     int temp = list.get(i);
        //     if(temp >= low && temp<= high){
        //         sum += temp;
        //     }
        // }
        // return sum;
        if(root == null){
            return 0;
        }
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }

        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }

        return root.val
                + rangeSumBST(root.left, low, high)
                + rangeSumBST(root.right, low, high);
    }
    // static void inorderTraversal(TreeNode root , ArrayList<Integer> list){
    //     if(root == null){
    //         return;
    //     }
    //     inorderTraversal(root.left , list);
    //     list.add(root.val);
    //     inorderTraversal(root.right,list);
    // }
}