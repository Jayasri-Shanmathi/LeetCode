class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st=new Stack<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=nums2.length-1;i>=0;i--){
            int n=nums2[i];
            while(!st.isEmpty() && st.peek()<=n){
                st.pop();
            }
            int nge=-1;
            if(!st.isEmpty()) nge=st.peek();
            map.put(n,nge);
            st.push(n);
        }
        int[] res=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            res[i]=map.get(nums1[i]);
        }
        return res;
    }
}