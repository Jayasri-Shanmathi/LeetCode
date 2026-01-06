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
        if(root==null)return 0;
        int level=1;int maxlvl=0;int maxSum=Integer.MIN_VALUE;
        Queue<TreeNode> tree=new LinkedList<>();
        tree.offer(root);
        while(!tree.isEmpty()){
            int size=tree.size();
            int sum=0;
            for(int i=0;i<size;i++){
                TreeNode parent=tree.poll();
                sum+=parent.val;
                if(parent.left!=null) tree.offer(parent.left);
                if(parent.right!=null)tree.offer(parent.right);
            }
            if(sum>maxSum){
                maxSum=sum;maxlvl=level;
            }
            level++;
        }return maxlvl;   
    }
}