class Solution {
    public int countPalindromicSubsequence(String s) {
       int[] left=new int[128];
       int[] right=new int[128];
       for(char ch:s.toCharArray()){
        right[ch]++;
       }
       Set<String>seq=new HashSet<>();
       for(int i=0;i<s.length();i++){
        char middle=s.charAt(i);
        right[middle]--;
        for(char ch='a';ch<='z';ch++){
            if(right[ch]>0 && left[ch]>0){
                 StringBuilder sb=new StringBuilder();
                 sb.append(ch).append(middle).append(ch);
                 seq.add(sb.toString());
                 
            }
        }
        left[middle]++;   
            
       }
       return seq.size();
    }
}