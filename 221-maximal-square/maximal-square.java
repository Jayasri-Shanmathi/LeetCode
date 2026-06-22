class Solution {
    public int maximalSquare(char[][] matrix) {
        int R=matrix.length;
        int C=matrix[0].length;
        int[][]mat=new int[R][C];
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(matrix[i][j]=='1') mat[i][j]++;
            }
        }
        for(int i=0;i<R;i++){
            for(int j=1;j<C;j++){
                if(mat[i][j]==0) continue;
                mat[i][j]+=mat[i][j-1];
            }
        }
        int maxArea=0;
        for(int j=0;j<C;j++){
            for(int i=0;i<R;i++){
                if(mat[i][j]==0) continue;
                int w=mat[i][j];

                for(int k=i;k<R;k++){
                    w=Math.min(w,mat[k][j]);
                    int h=k-i+1;
                    if(h==w){
                        maxArea=Math.max(maxArea,h*h);
                    }
                }

                for(int k=i;k>=0;k--){
                    w=Math.min(w,mat[k][j]);
                    int h=i-k+1;
                    if(h==w){
                        maxArea=Math.max(maxArea,h*h);
                    }
                }
            }
        }
        return maxArea;
    }
}