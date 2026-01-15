class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> list=new ArrayList<>();
        Set<String> set=new HashSet<>(Arrays.asList(words));
        for(String word:words){
            if(word.length()==0) continue;
            set.remove(word);
            int n=word.length();
            boolean[]dp=new boolean[n+1];
            dp[0]=true;
            for(int i=1;i<=n;i++){
                for(int j=0;j<i;j++){
                    if(!dp[j]) continue;
                    if(set.contains(word.substring(j,i))){
                        dp[i]=true;break;
                    }
                }
          }
          if(dp[n]) list.add(word);set.add(word);
        }
        return list;
    }
}