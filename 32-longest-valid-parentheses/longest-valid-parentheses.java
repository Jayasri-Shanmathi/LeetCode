class Solution {
    public int longestValidParentheses(String s) {
        int N=s.length();
        Stack<Integer> st=new Stack<>();
        int[]res=new int[N];
        for(int i=0;i<N;i++){
            if(s.charAt(i)=='(') st.push(i);
            else if(!st.isEmpty() && s.charAt(i)==')'){
                int idx=st.pop();
                res[idx]=(i-idx)+1;
            }
        }
        int max=0;
        for(int i=0;i<N;i++){
                int sum=res[i];
                int idx=i+res[i];
                while(idx<N){
                    if(res[idx]==0)break;
                    sum+=res[idx];
                    idx+=res[idx];
                }
                max=Math.max(max,sum);
        }
        return max;
    }
}