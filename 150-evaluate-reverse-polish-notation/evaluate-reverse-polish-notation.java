class Solution {
    public int evalRPN(String[] tokens) {
         Stack<Integer> st=new Stack<>();
        int n=tokens.length;
        for(String str:tokens){
            if(!str.equals("+") && !str.equals("-") && 
               !str.equals("*") && !str.equals("/")){  
                st.push(Integer.parseInt(str));
            } 
            else{
                int b=st.pop();int a=st.pop();
                if(str.equals("+")) a+=b;
                else if(str.equals("-")) a-=b;
                else if(str.equals("*")) a*=b;
                else if(str.equals("/")) a/=b;
                st.push(a);
            }
        }
        return st.peek();
    }
}