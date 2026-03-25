class Solution {
    public long maxMatrixSum(int[][] matrix) {
        List<Integer> l=new ArrayList<>();
        long sum=0;
        int r=matrix.length;
        int c=matrix[0].length;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                sum+=Math.abs(matrix[i][j]);
                if(matrix[i][j]<0) l.add(matrix[i][j]);
                min=Math.min(min,Math.abs(matrix[i][j]));
            }
        }
        Collections.sort(l);
        if(l.size()%2==0)return sum;
        else return sum-(2*min);
    }
}