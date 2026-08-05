class Solution {
    public static boolean dfs(int i,int j,int R,int C,int idx,String word,char[][]board,boolean[][]vis){
        if(idx==word.length()) return true;
        if(i<0 || i>R || j<0 || j>C || vis[i][j]) return false;
        vis[i][j]=true;
        int[][]dir=new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        for(int a=0;a<4;a++){
            int adjR=i+dir[a][0];
            int adjC=j+dir[a][1];
            if(adjR>=0 && adjR<R && adjC>=0 && adjC<C && board[adjR][adjC]==word.charAt(idx) && !vis[adjR][adjC]){
                boolean found=dfs(adjR,adjC,R,C,idx+1,word,board,vis);
                if(found) return true;
            }
        }
        vis[i][j]=false;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        int R=board.length;
        int C=board[0].length;
        boolean found=false;
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
              if(board[i][j]==word.charAt(0)){
                 boolean[][]vis=new boolean[R][C];
                 found=dfs(i,j,R,C,1,word,board,vis);
                 if(found) return true;
              }
            }
        }
        return found;
    }
}
