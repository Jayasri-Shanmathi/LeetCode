class Solution {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch=='(' || ch=='{' || ch=='[') st.push(ch);
            else{
                if(st.isEmpty()) return false;
                char peek=st.pop();
                if(ch==')' && peek!='(' ||
                   ch=='}' && peek!='{' ||
                   ch==']' && peek!='[' ){
                    return false;
                   }
            }
        }
        return st.isEmpty();
    }
}