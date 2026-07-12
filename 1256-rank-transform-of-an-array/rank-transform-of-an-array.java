class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int N=arr.length;
        int[]darr=new int[N];
        for(int i=0;i<N;i++){
            darr[i]=arr[i];
        }
        Arrays.sort(darr);
        int[]res=new int[N];
        int idx=1;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<N;i++){
            if(!map.containsKey(darr[i])){
                map.put(darr[i],idx);
                idx++;
            }
        }
        for(int i=0;i<N;i++){
            res[i]=map.get(arr[i]);
        }
        return res;
    }
}