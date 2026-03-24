class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int R=grid.length;
        int C=grid[0].length;
        long[]prefix=new long[R*C];
        long[]suffix=new long[R*C];
        int[][]mat=new int[R][C];
        long prod=1;
        int idx=0;
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                prefix[idx]=prod;
                prod=(prod*grid[i][j])%12345;
                idx++;
            }
        }
        prod=1;idx=R*C-1;
        for(int i=R-1;i>=0;i--){
            for(int j=C-1;j>=0;j--){
               suffix[idx]=prod;
               prod=(prod*grid[i][j])%12345;
               idx--;   
            }
        }
        int[]result=new int[R*C];
        for(int i=0;i<R*C;i++){
            result[i]=(int)(prefix[i]*suffix[i])%12345;
        }
        idx=0;
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                mat[i][j]=result[idx];
                idx++;
            }
        }
       return mat;
    }
}