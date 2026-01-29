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
    static class Pair{
        TreeNode node;
        int pos;
        Pair(TreeNode node, int pos) {
            this.node = node;
            this.pos = pos;
        }

    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        int width = 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root,0));

        while(!q.isEmpty()){
            int size = q.size();
            int start = 0;
            int end = 0;
            int base = q.peek().pos;
//            int [] arr = new int[(int)Math.pow(2,k)];
            for(int i = 0 ; i < size ; i++){
                Pair curr = q.poll();
                int pos = curr.pos - base;
                if (i == 0) start = pos;
                if (i == size - 1) end = pos;

                if (curr.node.left != null) {
                    q.offer(new Pair(curr.node.left, 2 * pos));
                }
                if (curr.node.right != null) {
                    q.offer(new Pair(curr.node.right, 2 * pos + 1));
                }
            }

            width = Math.max(width, end - start + 1);
        }

        return width;

    }
}