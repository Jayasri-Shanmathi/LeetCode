class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[]arr=new int[n];
        boolean[]res=new boolean[queries.length];
        for(int i=1;i<n;i++){
            if(nums[i]-nums[i-1]<=maxDiff){
                arr[i]=arr[i-1];
            }
            else{
                arr[i]=arr[i-1]+1;
            }
        }
        int idx=0;
        for(int[]q:queries){
            if(arr[q[0]]==arr[q[1]]){
                res[idx]=true;
            }
            else res[idx]=false;
            idx++;
        }
        return res;
    }
}