class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n=heights.length;
        Stack<Integer> st=new Stack<>();
        int[]result=new int[n];
        for(int i=n-1;i>=0;i--){
            int count=0;
            while(!st.isEmpty() && st.peek()<heights[i]){
                       count++;
                       st.pop();
            }
            if(!st.isEmpty() && st.peek()>heights[i])count++;
            result[i]=count;
            st.push(heights[i]);
        }
        return result;
    }
}