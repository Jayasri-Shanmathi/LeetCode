class Solution {
    public int maxProductPath(int[][] grid) {
        int r=grid.length;
        int c=grid[0].length;
        long[][]max=new long[r][c];
        long[][]min=new long[r][c];
        max[0][0]=grid[0][0];
        min[0][0]=grid[0][0];
        for(int i=1;i<c;i++){
            max[0][i]=max[0][i-1]*grid[0][i];
            min[0][i]=max[0][i];
        }
        for(int i=1;i<r;i++){
            max[i][0]=max[i-1][0]*grid[i][0];
            min[i][0]=max[i][0];
        }
        for(int i=1;i<r;i++){
            for(int j=1;j<c;j++){
                long num=grid[i][j];
                long a=max[i-1][j]*num;
                long b=max[i][j-1]*num;
                long ca=min[i-1][j]*num;
                long d=min[i][j-1]*num;
                max[i][j]=Math.max(Math.max(a,ca),Math.max(b,d));
                min[i][j]=Math.min(Math.min(a,ca),Math.min(b,d));
            }
        }
        if(max[r-1][c-1]<0)return -1;
        return (int)(max[r-1][c-1]%1_000_000_007);
    }
}