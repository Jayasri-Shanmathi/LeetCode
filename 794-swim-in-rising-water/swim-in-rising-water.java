class Solution {
    public int swimInWater(int[][] grid) {
        int n=grid.length;int time=0;
        boolean[][]visited=new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
        pq.add(new int[]{0,0,grid[0][0]});visited[0][0]=true;
        int[][]diff=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        while(!pq.isEmpty()){
            int[]cell=pq.poll();
            time=Math.max(time,cell[2]);
            if(cell[0]==n-1 &&cell[1]==n-1){
                break;
            }
            for(int a=0;a<4;a++){
                int adjR=cell[0]+diff[a][0];
                int adjC=cell[1]+diff[a][1];
                if(adjR>=0 && adjR<n && adjC>=0 && adjC<n && !visited[adjR][adjC]){
                    pq.add(new int []{adjR,adjC,grid[adjR][adjC]});
                    visited[adjR][adjC]=true;
                }
            }
        } 
        return time;
        
       
    }
}