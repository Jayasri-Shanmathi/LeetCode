class Solution {
    private void dfs(int n,int i,int isConnected[][],boolean[] visited){
            visited[i]=true;
            for(int other=0;other<n;other++){
                if(!visited[other]&& isConnected[i][other]==1){
                    dfs(n,other,isConnected,visited);
                }
            }
    }
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        int province=0;
        boolean[]visited=new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i])
                province++;
                dfs(n,i,isConnected,visited);   
        }
        return province;
    }
}