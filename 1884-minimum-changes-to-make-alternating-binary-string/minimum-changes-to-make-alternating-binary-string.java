class Solution {
    public int minOperations(String s) {
        char start='0';
        int count1=0;
        for(int i=0;i<s.length();i++){
            if(i%2==0 && s.charAt(i)!=start) count1++;
            else if(i%2!=0 && s.charAt(i)==start) count1++;
        }
        start='1';
        int count2=0;
        for(int i=0;i<s.length();i++){
            if(i%2==0 && s.charAt(i)!=start) count2++;
            else if(i%2!=0 && s.charAt(i)==start) count2++;
        }
         return Math.min(count1,count2);

    }
}