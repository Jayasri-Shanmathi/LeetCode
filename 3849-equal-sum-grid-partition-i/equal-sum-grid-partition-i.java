class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int r=grid.length;
        int c=grid[0].length;
        long[]rowsum=new long[r];
        long[]colsum=new long[c];
        long total=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                total+=grid[i][j];
            }
        }
        if(total%2!=0)return false;
        for(int i=0;i<r;i++){
            long sum=0;
            for(int j=0;j<c;j++){
                sum+=grid[i][j];
            }
            rowsum[i]=sum;
        }
        for(int j=0;j<c;j++){
            long sum=0;
            for(int i=0;i<r;i++){
                sum+=grid[i][j];
            }
            colsum[j]=sum;
        }
        long rs=0;
        for(int i=0;i<r;i++){
            rs+=rowsum[i];
            if(rs==(total/2))return true;
        }
        long tc=0;
        for(int i=0;i<c;i++){
            tc+=colsum[i];
            if(tc==(total/2))return true;
        }
        return false;

    }
}