class Solution {

     private void dfs(String word, String beginWord,Map<String, List<String>> parents,List<String> path,List<List<String>> ans) {
        if(word.equals(beginWord)){
            List<String> copy=new ArrayList<>(path);
            Collections.reverse(copy);
            ans.add(copy);
            return;
        }
        for(String p:parents.getOrDefault(word,new ArrayList<>())) {
            path.add(p);
            dfs(p,beginWord,parents,path,ans);
            path.remove(path.size()-1);
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans=new ArrayList<>();
        Set<String> dict=new HashSet<>(wordList);
        if(!dict.contains(endWord))return ans;
        Map<String, List<String>> parents=new HashMap<>();
        Set<String> current=new HashSet<>();
        current.add(beginWord);
        boolean found=false;
        while(!current.isEmpty() && !found) {
            dict.removeAll(current);
            Set<String> next=new HashSet<>();
            for(String word:current){
                char[] arr=word.toCharArray();
                for (int i=0;i<arr.length;i++) {
                    char old=arr[i];
                    for (char c='a';c<='z';c++) {
                        arr[i]=c;
                        String nw=new String(arr);
                        if (dict.contains(nw)) {
                            next.add(nw);
                            parents.computeIfAbsent(nw, k->new ArrayList<>()).add(word);
                            if (nw.equals(endWord)) found=true;
                        }
                    }
                    arr[i]=old;
                }
            }
            current=next;
        }
        if(!found) return ans;
        List<String> path=new ArrayList<>();
        path.add(endWord);
        dfs(endWord,beginWord,parents,path,ans);
        return ans;
    }
   
}
