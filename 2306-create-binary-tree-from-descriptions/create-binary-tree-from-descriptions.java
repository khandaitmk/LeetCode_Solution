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
    public TreeNode createBinaryTree(int[][] descriptions) {
       HashMap<Integer , TreeNode> hs = new HashMap<>();
        int n = descriptions.length;
        int m = descriptions[0].length;
        int root = -1;
        HashSet<Integer> child = new HashSet<>();
        for(int i=0;i<n;i++){
            int num = descriptions[i][1];
            child.add(num);
        }
        for(int i=0;i<n;i++){
            int num = descriptions[i][0];
            if(!child.contains(num)){
                root = num;
            }
        }

        for(int i=0;i<n;i++){
            int par = descriptions[i][0];
            int chi = descriptions[i][1];
            int isLeft = descriptions[i][2];
            if(!hs.containsKey(par)){
                TreeNode temp = new TreeNode(par);
                if(!hs.containsKey(chi)){
                    TreeNode temp1 = new TreeNode(chi);
                    if(isLeft == 1){
                        temp.left = temp1;
                    }else {
                        temp.right = temp1;
                    }
                    hs.put(par , temp);
                    hs.put(chi , temp1);
                }else{
                    TreeNode temp1 = hs.get(chi);
                    if(isLeft == 1){
                        temp.left = temp1;
                    }else {
                        temp.right = temp1;
                    }
                    hs.put(par , temp);
                }
            }else {
                TreeNode temp = hs.get(par);
                if(!hs.containsKey(chi)){
                    TreeNode temp1 = new TreeNode(chi);
                    if(isLeft == 1){
                        temp.left = temp1;
                    }else {
                        temp.right = temp1;
                    }
                    hs.put(chi , temp1);
                }else{
                    TreeNode temp1 = hs.get(chi);
                    if(isLeft == 1){
                        temp.left = temp1;
                    }else {
                        temp.right = temp1;
                    }
                }
            }
        }
        return hs.get(root); 
    }
}