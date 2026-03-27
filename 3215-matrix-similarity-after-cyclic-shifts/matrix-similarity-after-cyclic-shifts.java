class Solution {
    private static boolean compare(int[][]grid,int[][]mat) {
		int r=grid.length;
		int c=grid[0].length;
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(grid[i][j]!=mat[i][j]) return false;
			}
		}
		return true;
	}
    public boolean areSimilar(int[][] mat, int k) {
        int r=mat.length;
        int c=mat[0].length;
        if(r==k && c==k) return true;
        int[][]grid=new int[r][c];
        for(int i=0;i<r;i++) {
        	for(int j=0;j<c;j++) {
        			grid[i][(j+k)%c]=mat[i][j];
        		}
        	}
        boolean yes=compare(grid,mat);
        return yes;
    }
}