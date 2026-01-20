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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
         if(root == null){
            return new ArrayList<>();
        }
        List<Integer> l1 = new ArrayList<>();
        List<List<Integer>> l2 = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            TreeNode curr = q.remove();
            if(curr == null){
                if(q.isEmpty()){
                    l2.add(l1);
                    break;
                }else{
                    q.add(null);
                    l2.add(l1);
                    l1 = new ArrayList<>();

                }
            }else{
                l1.add(curr.val);
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
        }
        Stack<List<Integer>> s = new Stack<>();
        int n = l2.size()-1;
        int i=0;
        while(i <= n){
            s.push(l2.get(i++));
        }
        l2.clear();
        while(!s.isEmpty()){
            l2.add(s.pop());
        }
        return l2; 
    }
}