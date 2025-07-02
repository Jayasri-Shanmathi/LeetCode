class Solution {
    public int orangesRotting(int[][] grid) {
        int r=grid.length;
        int c=grid[0].length;
        int days=-1;int oranges=0;
        boolean[][] visited=new boolean[r][c];
        Queue<int[]>queue=new LinkedList<>();
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]!=0){
                    if(grid[i][j]==2){
                    queue.add(new int[]{i,j});
                }
                oranges++;
            }
        }}
        if(oranges==0)
           return 0;
        int diff[][]=new int[][]{{0,-1},{0,1},{-1,0},{1,0}};
        while(!queue.isEmpty()){
            days++;
            int qsize=queue.size();
            int a=0;int b=0;
            for(int ctr=1;ctr<=qsize;ctr++){
                int cell[]=queue.poll();
                oranges--;
                for(int index=0;index<4;index++){
                    int adjR=cell[0]+diff[index][0];
                    int adjC=cell[1]+diff[index][1];
                    if(adjR>=0 && adjR<r && adjC>=0 && adjC<c){
                        if(grid[adjR][adjC]==1 && !visited[adjR][adjC]){
                            queue.add(new int[]{adjR,adjC});
                            visited[adjR][adjC]=true;
                        }
                    }
                }
            }
            
        
        
        }
        if(oranges>0)
           return -1;
        return days;   

    }
}