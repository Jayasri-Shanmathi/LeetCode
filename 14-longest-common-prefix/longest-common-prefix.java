class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String str1=strs[0];
        String str2=strs[strs.length-1];
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<str1.length();i++){
            if(str1.charAt(i)!=str2.charAt(i)) return sb.toString();
            sb.append(str1.charAt(i));
        }
        return sb.toString();
    }
}