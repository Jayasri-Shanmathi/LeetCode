class Solution {
    public int shortestPathAllKeys(String[] grid) {
        int row=grid.length;
        int col=grid[0].length();
        boolean visited[][][]=new boolean[row][col][(1<<6)];//row idx,col idx,flag(as total keys are 6 so total states are 2^6)
        Queue<int[]>queue=new LinkedList<>();
        int keyCount=0;//calculating no. of keys
        int matrix[][]=new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                char ch=grid[i].charAt(j);
                if (ch=='@'){
                    queue.add(new int[]{i,j,0,0});
                    visited[i][j][0]=true;
                }
                else if (Character.isLowerCase(ch)) keyCount++;                   
                
            }
        }
        int diff[][]=new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        while(!queue.isEmpty()){
            int[] cell=queue.poll();
            int r=cell[0],c=cell[1],moves=cell[2],flag=cell[3];
            if(flag==((1<<keyCount)-1)) return moves;//to check if all keys are acquired
            for(int a=0;a<4;a++){
                int adjR=r+diff[a][0];
                int adjC=c+diff[a][1];
                if(adjR>=0 && adjR<row && adjC>=0 && adjC<col){
                    char ch=grid[adjR].charAt(adjC);
                    if (ch=='#') continue;
                    if (Character.isUpperCase(ch)){
                        if((flag & (1<<(ch-'A')))==0) continue;
                    }
                    int newFlag=flag;
                    if(Character.isLowerCase(ch))  newFlag=newFlag | (1<<(ch-'a'));
                    if (!visited[adjR][adjC][newFlag]){
                        queue.add(new int[]{adjR,adjC,moves+1,newFlag});
                        visited[adjR][adjC][newFlag]=true;
                    }
                }
            }

        }return -1;

           
    }
}