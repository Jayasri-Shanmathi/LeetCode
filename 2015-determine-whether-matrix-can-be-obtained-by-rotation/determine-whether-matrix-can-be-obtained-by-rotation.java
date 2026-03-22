class Solution {
    private boolean compare(int[][]mat,int[][]target){
        int n=mat.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]!=target[i][j])return false;
            }
        }
        return true;
    }
    public boolean findRotation(int[][] mat, int[][] target) {
        int n=mat.length;
        for(int i=0;i<4;i++){
            for(int j=0;j<n/2;j++){
                for(int k=0;k<(n+1)/2;k++){
                    int temp=mat[j][k];
                    mat[j][k]=mat[n-1-k][j];
                    mat[n-1-k][j]=mat[n-1-j][n-1-k];
                    mat[n-1-j][n-1-k]=mat[k][n-1-j];
                    mat[k][n-1-j]=temp;
                }
            }
            if(compare(mat,target)) return true;
        }
        return false;
    }
}