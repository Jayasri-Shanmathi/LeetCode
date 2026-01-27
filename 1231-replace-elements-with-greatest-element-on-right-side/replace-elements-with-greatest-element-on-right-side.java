class Solution {
    public int[] replaceElements(int[] arr) {
        int n=arr.length;
        int[]a=new int[n];
        a[n-1]=-1;
        for(int i=n-2;i>=0;i--){
            a[i]=Math.max(arr[i+1],a[i+1]);
        }
        return a;
    }
}