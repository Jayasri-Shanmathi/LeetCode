class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int R=mat.length;
        int C=mat[0].length;
        boolean [][]visited=new boolean[R][C];
        Queue<int[]> queue=new LinkedList<>();

        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(mat[i][j]==0){
                    visited[i][j]=true;
                    queue.add(new int[]{i,j});
                }
            }
        }
        int[][]diff={{0,1},{1,0},{0,-1},{-1,0}};
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                int[]cell=queue.poll();
                for(int a=0;a<4;a++){
                    int adjR=cell[0]+diff[a][0];
                    int adjC=cell[1]+diff[a][1];
                    if(adjR>=0 && adjR<R &&adjC>=0 && adjC<C && !visited[adjR][adjC] && mat[adjR][adjC]!=0){
                           mat[adjR][adjC]+=mat[cell[0]][cell[1]];
                           visited[adjR][adjC]=true;
                           queue.add(new int[]{adjR,adjC});
                    }
                }
            }
        }
        return mat;
    }
}