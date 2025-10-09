class Solution {
    static Map<Integer,String> map = new HashMap<>();
    static{map.put(2,"abc");
    map.put(3,"def");
    map.put(4,"ghi");
    map.put(5,"jkl");
    map.put(6,"mno");
    map.put(7,"pqrs");
    map.put(8,"tuv");
    map.put(9,"wxyz");
    }
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits==null || digits.length()==0) return result;
        backtrack(digits,0,result,new StringBuilder());
        return result;
    }
       
    public void  backtrack(String digits,int index,List<String>result,StringBuilder path){
        if(index==digits.length()){
            result.add(path.toString());
            return;
        }
        String letters=map.get(digits.charAt(index)-'0');
        for(char c:letters.toCharArray()){
            path.append(c);
            backtrack(digits,index+1,result,path);
            path.deleteCharAt(path.length()-1);
        }

    }
}