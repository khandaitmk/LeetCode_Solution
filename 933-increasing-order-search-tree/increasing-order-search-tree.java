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
    public TreeNode increasingBST(TreeNode root) {
        ArrayList<Integer> a = new ArrayList<>();
        inorder(root, a);
        TreeNode temp = null;
        for(int i=0 ; i < a.size() ; i++){
            temp = helper(temp,a.get(i));
        }
        return temp;
    }
    static TreeNode helper(TreeNode temp , int data){
        if(temp == null){
            return new TreeNode(data);
        }
        if(temp.val > data){
            temp.left = helper(temp.left , data);
        }else if(temp.val < data){
            temp.right = helper(temp.right , data);
        }
        return temp;
    }
    static void inorder(TreeNode root, ArrayList<Integer> a){
        if(root == null){
            return ;
        }
        inorder(root.left , a);
        a.add(root.val);
        inorder(root.right , a);
    }
}