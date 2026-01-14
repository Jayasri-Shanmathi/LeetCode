class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list1=new ArrayList<>();
        List<String> list2=new ArrayList<>();
        int letter=0;
        for(String word:words){
            if (letter+list1.size()+word.length()>maxWidth){
                int spaces=maxWidth-letter;
                int gaps=list1.size()-1;
                if(gaps>0){
                    for(int i=0;i<spaces;i++){
                        int idx=i%gaps;
                        list1.set(idx,list1.get(idx)+" ");
                    }
                } else {
                    list1.set(0, list1.get(0)+" ".repeat(spaces));
                }
                StringBuilder sb=new StringBuilder();
                for (String s:list1) sb.append(s);
                list2.add(sb.toString());
                list1.clear();
                letter=0;
            }
            list1.add(word);
            letter+=word.length();
        }
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<list1.size();i++){
            sb.append(list1.get(i));
            if (i!=list1.size()-1)sb.append(" ");
        }
        while (sb.length()<maxWidth)sb.append(" ");
        list2.add(sb.toString());
        return list2;
    }
}
