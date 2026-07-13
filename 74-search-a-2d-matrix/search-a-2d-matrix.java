class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int R=matrix.length;
        int C=matrix[0].length;
        int left=0;int right=R*C-1;
        while(left<=right){
            int mid=(left+right)/2;
            int val=matrix[mid/C][mid%C];
            if(val==target) return true;
            else if(val<target) left=mid+1;
            else right=mid-1;
        }
        return false;
    }
}