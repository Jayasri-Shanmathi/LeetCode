class Solution {
    public int findCenter(int[][] edges) {
        int n=edges.length;
        Map<Integer,ArrayList<Integer>>map=new HashMap<>();
        for(int i=0;i<n;i++){
            if(!map.containsKey(edges[i][0])){
                map.put(edges[i][0],new ArrayList<Integer>());
            }
            if(!map.containsKey(edges[i][1])){
                 map.put(edges[i][1],new ArrayList<Integer>());
            }
        }
        for(int i=0;i<n;i++){
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }
        int size=map.size()-1;
        for(int i:map.keySet()){
            if(map.get(i).size()==size){
                return i;
            }
        }
        return 0;
    }
}