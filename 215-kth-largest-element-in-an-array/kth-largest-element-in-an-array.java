class Solution {
    public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> minHeap= new PriorityQueue<>();
    for(int i=0;i<nums.length;i++){
        if(minHeap.size()<k || nums[i]>minHeap.peek())
             minHeap.add(nums[i]);
        if(minHeap.size()>k)
             minHeap.poll();     
    }
    return minHeap.poll();
    
    }
    
}