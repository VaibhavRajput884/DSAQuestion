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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        // TreeNode temp = root;
        queue.add(root);
        queue.add(null);
        int index=1;
        int sum =Integer.MIN_VALUE;
        int i=1;
        int tempSum =0;
        while(!queue.isEmpty()){
            TreeNode temp = queue.remove();
            if(temp==null){
                if(tempSum>sum){
                    index = i;
                    sum = tempSum;
                }
                if(!queue.isEmpty()) queue.add(null);
                tempSum=0;
                i++;
            }
            else{
                tempSum +=temp.val;
                if(temp.left!=null)
                    queue.add(temp.left);
                if(temp.right!=null)
                    queue.add(temp.right);
            }
            
        }
        return index;
    }
}