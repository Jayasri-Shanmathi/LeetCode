class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int row=grid.length;
        int col=grid[0].length;
        int[][]mat=new int[row-k+1][col-k+1];
        for(int i=0;i<=row-k;i++){
            for(int j=0;j<=col-k;j++){
                Set<Integer>set=new HashSet<>();
                for(int x=i;x<i+k;x++){
                    for(int y=j;y<j+k;y++){
                        set.add(grid[x][y]);
                    }
                }
                List<Integer>l=new ArrayList<>(set);
                Collections.sort(l);
                int diff=Integer.MAX_VALUE;
                for(int idx=1;idx<l.size();idx++){
                    int d=l.get(idx)-l.get(idx-1);
                    diff=Math.min(diff,d);
                    if(diff==0)break;
                }
                if(diff==Integer.MAX_VALUE) mat[i][j]=0;
                else mat[i][j]=diff;
            }
        }
        return mat;
    }
}