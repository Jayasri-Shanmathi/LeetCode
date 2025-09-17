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
        List<List<Integer>>l=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null) return new ArrayList<>();
        q.add(root);
        boolean rev=true;
        while(!q.isEmpty()){
            int size=q.size();   
            List<Integer> ml=new ArrayList<>();     
            for(int i=0;i<size;i++){
               TreeNode parent=q.poll();
               ml.add(parent.val);
               if(parent.left!=null) q.add(parent.left);
               if(parent.right!=null) q.add(parent.right);
            }
            if(!rev) Collections.reverse(ml);
            l.add(ml);
            rev=!rev;          
        }
        return l;
        }
}             
                