class Solution {
    public int[][] merge(int[][] intervals) {
        int n=intervals.length;
        if(n==1)return intervals;
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));
        List<List<Integer>> l=new ArrayList<>();
        int prst=intervals[0][0];int pred=intervals[0][1];
        for(int i=1;i<n;i++){
              if(intervals[i][0]<=pred){
                pred=Math.max(pred,intervals[i][1]);
              }
              else{
                List<Integer>ll=new ArrayList<>();
                ll.add(prst);ll.add(pred);
                l.add(ll);
                pred=intervals[i][1];
                prst=intervals[i][0];
              }
        }
        List<Integer>ll=new ArrayList<>();
        ll.add(prst);ll.add(pred);
        l.add(ll);
        int size=l.size();
        int[][]ans=new int[size][2];
        for(int i=0;i<size;i++){
            ans[i][0]=l.get(i).get(0);
            ans[i][1]=l.get(i).get(1);
        }
        return ans;
    }
}