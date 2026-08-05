class Solution {
    public boolean path(int u,int v,boolean[]vis,List<List<Integer>>l){
        if(u==v) return true;
        vis[u]=true;
        for(int n:l.get(u)){
            if(!vis[n]){
            if(path(n,v,vis,l)){
                return true;
            }}
        }
        return false;
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        List<List<Integer>> l=new ArrayList<>();
        for(int i=0;i<=n;i++){
            l.add(new ArrayList<>());
        }
        for(int[]ed:edges){
            int u=ed[0];
            int v=ed[1];
            boolean[]vis=new boolean[n+1];
            if(path(u,v,vis,l)){
                return ed;
            }
            l.get(u).add(v);
            l.get(v).add(u);
        }
        return new int[0];
    }
}