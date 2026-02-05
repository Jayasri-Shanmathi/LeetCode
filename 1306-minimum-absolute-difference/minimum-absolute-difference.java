class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> d=new ArrayList<>();
        List<List<Integer>> result=new ArrayList<>();
        int min=Integer.MAX_VALUE;
        int n=arr.length;
        for(int i=0;i<n-1;i++){
            int diff=arr[i+1]-arr[i];
            min=Math.min(min,diff);
            List<Integer> l=new ArrayList<>();
            l.add(arr[i]);l.add(arr[i+1]);l.add(diff);
            d.add(l);
        }
        for(List<Integer> x:d){
            if(x.get(2)==min){
                List<Integer> l=new ArrayList<>();
                l.add(x.get(0));l.add(x.get(1));
                result.add(l);
            }
        }
        return result;
    }
}