class Solution {
    private static void dfs(int row,int col,int R,int C,int original,int color,int[][] image){
        if(row<0 || row>=R || col<0 || col>=C ||  image[row][col]==color || image[row][col]!=original){
            return;
        }
        image[row][col]=color;
        int[][]diff={{0,1},{1,0},{-1,0},{0,-1}};
        for(int a=0;a<4;a++){
            int adjR=row+diff[a][0];
            int adjC=col+diff[a][1];
            dfs(adjR,adjC,R,C,original,color,image);
            
        }}
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int R=image.length;int C=image[0].length;
        int original=image[sr][sc];
        if(original!=color){
            dfs(sr,sc,R,C,original,color,image);
        }
        return image;
        }
    }
        

