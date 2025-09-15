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
    static int height(TreeNode root){
        if(root==null)return 0;
        return 1 + Math.max(height(root.left),height(root.right));
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        int lefth=height(root.left);
        int righth=height(root.right);
        int d1= diameterOfBinaryTree(root.left);
        int d2= diameterOfBinaryTree(root.right);
        return Math.max(Math.max(d1,d2),lefth+righth);
    
    }
}