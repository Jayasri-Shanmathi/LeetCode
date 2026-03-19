class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        int[]sum1=new int[col];
        int[]sum2=new int[col];
        int ans=0;
        for(int i=0;i<row;i++){
            int x=0;int y=0;
            for(int j=0;j<col;j++){
                if(grid[i][j]=='X')x++;
                else if(grid[i][j]=='Y')y++;
                sum1[j]+=x;
                sum2[j]+=y;
                if(sum1[j]>0 && sum1[j]==sum2[j])ans++;
            }
        }
        return ans;
    }
}