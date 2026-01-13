class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length())return "";
        Map<Character,Integer>map=new HashMap<>();
        for(char ch:t.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int rem=t.length();
        int i=0;
        int minLen=Integer.MAX_VALUE;
        int start=0;
        for(int j=0;j<s.length();j++) {
            char c=s.charAt(j);
            if(map.containsKey(c)) {
                if(map.get(c)>0) rem--;
                map.put(c,map.get(c)-1);
            }
            while(rem==0) {
                if (j-i+1<minLen) {
                    minLen=j-i+1;
                    start=i;
                }
                char left=s.charAt(i);
                if(map.containsKey(left)) {
                    map.put(left,map.get(left)+1);
                    if(map.get(left)>0)rem++;
                }
                i++;
            }
        }
        return minLen==Integer.MAX_VALUE ? "" : s.substring(start,start+minLen);
    }
}