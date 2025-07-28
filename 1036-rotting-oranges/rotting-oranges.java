class Solution {
    public int orangesRotting(int[][] grid) {
       int R=grid.length;int C=grid[0].length;
       int days=-1;int oranges=0;
       Queue<int[]> queue=new LinkedList<>();
       boolean[][]visited=new boolean[R][C];
       for(int row=0;row<R;row++){
        for(int col=0;col<C;col++){
            if(grid[row][col]!=0){
            if(grid[row][col]==2){                
                queue.add(new int[]{row,col});
                visited[row][col]=true;
            }oranges++;
            }
        }
       }
       if(oranges==0) return 0;
       while(!queue.isEmpty()){
        days++;
        int size=queue.size();
        for(int i=0;i<size;i++){
            int[]cell=queue.poll();
            int[][]diff={{0,1},{1,0},{0,-1},{-1,0}};
            for(int a=0;a<4;a++){
                int adjR=cell[0]+diff[a][0];
                int adjC=cell[1]+diff[a][1];
                if(adjR>=0 && adjR<R && adjC>=0 && adjC<C && !visited[adjR][adjC] && grid[adjR][adjC]==1 ){
                    visited[adjR][adjC]=true;grid[adjR][adjC]=2;                    
                    queue.add(new int[]{adjR,adjC});
                }
            }
        }
           
    }  for(int i=0;i<R;i++){
        for(int j=0;j<C;j++){
            if(grid[i][j]==1) return -1;
        }
    }

       return days; 

    }
}