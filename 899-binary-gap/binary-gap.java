class Solution {
    public int binaryGap(int n) {
        StringBuilder sb=new StringBuilder();
        while(n>0){
           int b=n&1;
           sb.append(b);
           n=n>>1;
        }
        String str=sb.reverse().toString();
        int max=0;
        List<Integer> one=new ArrayList<>();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='1')one.add(i);
        }
        if(one.size()==1) return 0;
        for(int i=1;i<one.size();i++){
            max=Math.max(max,one.get(i)-one.get(i-1));
        }
        return max;
    }
}