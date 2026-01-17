class Solution {
    public String kthSmallestPath(int[] destination, int k) {
        int row=destination[0];
        int col=destination[1];
        int total=row + col;
        long[][]arr=new long[total + 1][total + 1];
        for (int i=0;i<=total;i++) {
            arr[i][0]=arr[i][i]=1;
            for(int j=1;j<i;j++) {
                arr[i][j]=arr[i-1][j-1]+arr[i-1][j];
            }
        }
        StringBuilder sb=new StringBuilder();
        while (row > 0 || col > 0) {
            if (col > 0) {
                long count=arr[row+col-1][row];
                if (k<=count) {
                    sb.append('H');
                    col--;
                } else {
                    sb.append('V');
                    k-=count;
                    row--;
                }
            } else {
                sb.append('V');
                row--;
            }
        }
        return sb.toString();
    }
}
