class Solution {
    public int romanToInt(String s) {
        Map<Character,Integer>map=new HashMap<>();
        map.put('M',1000);
        map.put('D',500);
        map.put('C',100);
        map.put('L',50);
        map.put('X',10);
        map.put('V',5);
        map.put('I',1);
        int result=0;
        int i=0;
        int n=s.length();
        while(i<n-1){
            if (map.get(s.charAt(i)) < map.get(s.charAt(i+1))){
                result-=map.get(s.charAt(i));}
            else
               { result+=map.get(s.charAt(i));}
            i++;       
        }
        return result+map.get(s.charAt(n-1));
        
    }
}