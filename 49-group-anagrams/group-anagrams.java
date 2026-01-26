class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>>map=new HashMap<>();
        for(String s:strs){
            char[]ch=s.toCharArray();
            Arrays.sort(ch);
            String k=new String(ch);
            map.putIfAbsent(k,new ArrayList<>());
            map.get(k).add(s);
        }
        return new ArrayList<>(map.values());
    }
}