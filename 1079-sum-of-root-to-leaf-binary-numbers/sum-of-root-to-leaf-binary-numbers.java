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
    public int sumRootToLeaf(TreeNode root) {
        ArrayList<String> a = new ArrayList<>();
        helper(root,new StringBuilder(),a);
        int sum = 0;
        int i=0;
        while(i<a.size()){
            sum += Integer.parseInt(a.get(i++),2);
        }
        return sum;
    }
    public static void helper(TreeNode root,StringBuilder str, ArrayList<String> a){
        if(root == null) return ;
        str.append(root.val);

        if(root.left == null && root.right == null){
            a.add(str.toString());
        }else{
            helper(root.left , str,a);
            helper(root.right , str , a);
        }
        

        str.deleteCharAt(str.length()-1);
    }
}