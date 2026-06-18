class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> maxheap=new PriorityQueue<>(Collections.reverseOrder());
        for(int g:gifts){
            maxheap.add(g);
        }
        long sum=0;
        while(!maxheap.isEmpty() && k>0){
            int max=maxheap.poll();
            if(max==1){
                sum++;
                continue;
            }
            int sqrt=(int)(Math.sqrt(max));
            maxheap.add(sqrt);
            k--;
        }
        
        while(!maxheap.isEmpty()){
            sum+=(maxheap.poll());
        }
        return sum;
    }
}