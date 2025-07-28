class Solution {
    private void dfs(int row,int col,int R,int C,char[][]grid){
        if(row<0 || row>=R || col<0 || col>=C || grid[row][col]=='0') {return;}
        grid[row][col]='0';
        int[][]diff={{0,1},{1,0},{0,-1},{-1,0}};
        for(int a=0;a<4;a++){
            int adjR=row+diff[a][0];
            int adjC=col+diff[a][1];
            if(adjR>=0 && adjR<R && adjC>=0 && adjC<C && grid[adjR][adjC]=='1'){
                dfs(adjR,adjC,R,C,grid);
            }
        }

    } 
      
   
    public int numIslands(char[][] grid) {
        int R=grid.length;int C=grid[0].length;
        int island=0;
        for(int row=0;row<R;row++){
            for(int col=0;col<C;col++){
                if(grid[row][col]=='1'){
                    island++;
                    dfs(row,col,R,C,grid);
                }
            }
        }return island;
    }
    
}