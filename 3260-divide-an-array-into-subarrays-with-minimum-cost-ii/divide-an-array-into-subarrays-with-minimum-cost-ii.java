class Solution{
    public long minimumCost(int[]nums,int k,int dist){
        long ans=Long.MAX_VALUE,sum=0;
        int n=nums.length;
        TreeSet<Integer>set1=new TreeSet<>(
            (a,b)->nums[a]==nums[b]?a-b:nums[a]-nums[b]
        );
        TreeSet<Integer>set2=new TreeSet<>(
            (a,b)->nums[a]==nums[b]?a-b:nums[a]-nums[b]
        );
        for(int i=1;i<=dist+1;i++){
            set1.add(i);
            sum+=nums[i];
        }
        while(set1.size()>k-1){
            int idx=set1.pollLast();
            sum-=nums[idx];
            set2.add(idx);
        }
        ans=Math.min(ans,sum);
        for(int i=1;i+dist+1<n;i++){
            set2.add(i+dist+1);
            if(set1.contains(i)){
                set1.remove(i);
                sum-=nums[i];
                int idx=set2.pollFirst();
                set1.add(idx);
                sum+=nums[idx];
            }
            else{
                set2.remove(i);
                int minSet2=set2.first();
                int maxSet1=set1.last();
                if(nums[minSet2]<nums[maxSet1]){
                    set1.remove(maxSet1);
                    set2.add(maxSet1);
                    sum-=nums[maxSet1];
                    set2.remove(minSet2);
                    set1.add(minSet2);
                    sum+=nums[minSet2];
                }
            }
            ans=Math.min(ans,sum);
        }
        return ans+nums[0];
    }
}
