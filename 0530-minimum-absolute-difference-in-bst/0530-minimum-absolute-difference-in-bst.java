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
    int ans;
    Integer prev;

    public int getMinimumDifference(TreeNode root) {
        ans = Integer.MAX_VALUE;
        prev = null;
        getInorder(root);
        return ans;
    }
    public void getInorder(TreeNode root){
        if(root == null)
        return;

        getInorder(root.left);

        if(prev != null)  //simultaneously finding the minimum difference b/w two nodes as we know Inorder of BST is sorted
        ans = Math.min(ans , root.val - prev);

        prev = root.val;
        getInorder(root.right);
    }
}