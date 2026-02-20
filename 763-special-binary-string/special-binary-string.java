class Solution {
    public String makeLargestSpecial(String s) {
        List<String>list=new ArrayList<>();
        int count=0;int st=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1')count++;
            else count--;
            if(count==0){
                String str=s.substring(st+1,i);
                list.add("1"+makeLargestSpecial(str)+"0");
                st=i+1;
            }
        }
        Collections.sort(list,Collections.reverseOrder());
        StringBuilder sb=new StringBuilder();
        for(String l:list){
            sb.append(l);
        }
        return sb.toString();
    }
}