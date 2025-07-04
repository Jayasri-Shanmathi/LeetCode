class Solution {
    public int minFlips(int[][] mat) {
        int row=mat.length;
        int col=mat[0].length;
        int state=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                state=state|(mat[i][j]<<(i*col+j));
            }
        }
        Queue<Integer> queue=new LinkedList<>();queue.add(state);
        Set<Integer> visited=new HashSet<>();visited.add(state);
        int count=0;
        int[][]diff={{0,1},{1,0},{0,-1},{-1,0},{0,0}};
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                int cstate=queue.poll();
                if (cstate==0){ return count;}
                for(int r=0;r<row;r++){
                    for(int c=0;c<col;c++){
                        int newstate=cstate;
                        for(int a=0;a<5;a++){
                            int adjR=r+diff[a][0];
                            int adjC=c+diff[a][1];
                            if(adjR>=0 && adjR<row && adjC>=0 && adjC<col){
                                newstate=newstate^(1<<(adjR*col+adjC));
                            }
                        }
                        if(!visited.contains(newstate)){
                            visited.add(newstate);queue.add(newstate);
                        }

                    }
                }
                
            }count++;
        }return -1;
    }
}