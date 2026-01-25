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
    public List<Double> averageOfLevels(TreeNode root) {
        ArrayList<Double> a = new ArrayList<>();
        if(root == null){
            return a;
        }
        Queue<TreeNode> q = new LinkedList<>();
        long sum = 0;
        int count = 0;
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            TreeNode curr = q.remove();
            if(curr == null){
                double avg = (double)sum/count;
                a.add(avg);
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                    count = 0;
                    sum = 0;
                }
            }else{
                count++;
                sum += curr.val;
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
        }
        return a;

    }
}