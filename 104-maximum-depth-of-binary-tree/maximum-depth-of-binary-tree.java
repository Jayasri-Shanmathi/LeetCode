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
    public int depth(TreeNode node,int max){
        if(node==null) return 0;
        return  1+Math.max(depth(node.right,max),depth(node.left,max));
    }
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        int max=0;
        return depth(root,max);
    }
}