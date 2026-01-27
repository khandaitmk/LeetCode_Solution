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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    //    List<Integer> a = new ArrayList<>();
    //     List<List<Integer>> a2 = new ArrayList<>();

    //     if(root == null){
    //         return a2;
    //     }
    //     Queue<TreeNode> q = new LinkedList<>();
    //     q.add(root);
    //     q.add(null);

    //     while(!q.isEmpty()){
    //         TreeNode curr = q.remove();
    //         if(curr == null){
    //             if(q.isEmpty()){
    //                 a2.add(a);
    //                 break;
    //             }else{
    //                 a2.add(a);
    //                 a = new ArrayList<>();
    //                 q.add(null);
    //             }
    //         }else{
    //             a.add(curr.val);
    //             if(curr.left != null){
    //                 q.add(curr.left);
    //             }
    //             if(curr.right != null){
    //                 q.add(curr.right);
    //             }
    //         }
    //     }
    //     for(int i = 0; i<a2.size();i++){
    //         if(i % 2 != 0){
    //             reverse((ArrayList<Integer>) a2.get(i));
    //         }
    //     }
    //     return a2;


    List<List<Integer>> a2 = new ArrayList<>();
        if(root == null){
            return a2;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean leftToRight = true;
        while(!q.isEmpty()){
            int size = q.size();
            ArrayList<Integer> a = new ArrayList<>();
                  for(int i = 0 ; i < size ;i++){
                      TreeNode curr = q.remove();
                        if(leftToRight){
                            a.add(curr.val);
                        }else {
                            a.add(0,curr.val);
                        }
                      if (curr.left != null) q.add(curr.left);
                      if (curr.right != null) q.add(curr.right);
                  }
            a2.add(a);
            leftToRight = !leftToRight;
        }
        return a2; 
    }
    // static void reverse(ArrayList<Integer> a){
    //     int i=0;
    //     int j= a.size()-1;
    //     while(i<j){
    //         int t1 = a.get(i);
    //         int t2 = a.get(j);
    //         a.set(i++,t2);
    //         a.set(j--,t1);

    //     }
    // }
}