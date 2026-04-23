class Solution {
    private String cp2(String s1,String s2){
        StringBuilder res=new StringBuilder();
        int n1=s1.length(),n2=s2.length();
        for(int i=0;i<n1 && i<n2;i++) {
            if(s1.charAt(i)!=s2.charAt(i))
                break;
            res.append(s1.charAt(i));
        }
        return res.toString();
    }
    private String cp(String[] strs,int l,int r){
        if(l==r)return strs[l];
        if(l<r){
            int mid=(l+r)/2;
            String s1=cp(strs,l,mid);
            String s2=cp(strs,mid+1,r);
            return cp2(s1,s2);
        }
        return "";
    }
    public String longestCommonPrefix(String[] strs) {
        return cp(strs,0,strs.length-1);
    }
}