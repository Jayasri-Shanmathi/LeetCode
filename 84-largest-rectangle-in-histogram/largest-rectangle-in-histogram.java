class Solution {
    public int largestRectangleArea(int[] heights) {
        int N=heights.length;int area=0;
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<=N;i++){
            int n;
            if(i==N) n=0;
            else n=heights[i];
            while(!st.isEmpty() && n<heights[st.peek()]){
                int height=heights[st.pop()];
                int wid=st.isEmpty() ? -1:st.peek();
                wid=i-wid-1;
                area=Math.max(area,height*wid);
            }
            st.push(i);
        }
        return area;
    }
}