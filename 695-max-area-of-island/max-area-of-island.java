class Solution {
    public int dfs(int i,int j,int R,int C,int[][]grid){
        if(i<0 || i>=R || j<0 || j>=C) return 0;
        if(grid[i][j]==0)return 0;
        grid[i][j]=0;
        int total=1;
        int[][]dir={{0,1},{1,0},{0,-1},{-1,0}};
        for(int a=0;a<4;a++){
            int adjR=i+dir[a][0];
            int adjC=j+dir[a][1];
            total+=dfs(adjR,adjC,R,C,grid);
        }
        return total;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int R=grid.length;int C=grid[0].length;
        int area=0;
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(grid[i][j]==1) area=Math.max(area,dfs(i,j,R,C,grid));
            }
        }
        return area;
    }
}