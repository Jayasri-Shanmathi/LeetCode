class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb=new StringBuilder();
        int n1=word1.length();int n2=word2.length();
        int ind1=0;int ind2=0;
        boolean first=true;
        while(ind1<n1 && ind2<n2){
            if(first){
                sb.append(word1.charAt(ind1));ind1++;
                first=false;
            }
            else{
                sb.append(word2.charAt(ind2));ind2++;
                first=true;
            }
        }
        if(ind2<n2){
            for(int i=ind2;i<n2;i++) {
                sb.append(word2.charAt(ind2));ind2++;
            }
        }
        if(ind1<n1){
             for(int i=ind1;i<n1;i++) {
                sb.append(word1.charAt(ind1));ind1++;
            }
        }
        return sb.toString();
    }
}