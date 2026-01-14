class Solution {
    boolean dfs(List<Double> num){
        if(num.size()==1) return Math.abs(num.get(0)-24)<1e-6;
        for(int i=0;i<num.size();i++){
            for(int j=0;j<num.size();j++){
                if(i==j)continue;
                List<Double> list=new ArrayList<>();
                for(int k=0;k<num.size();k++){
                    if(k!=i && k!=j) list.add(num.get(k));
                }
                double a=num.get(i);double b=num.get(j);
                double[]arr=new double[]{a+b,a-b,b-a,a*b,Math.abs(b) > 1e-6 ? a/b:Double.NaN,Math.abs(a) >1e-6 ? b/a:Double.NaN};
                for(double n:arr){
                    if(Double.isNaN(n))continue;
                    list.add(n);
                    if(dfs(list))return true;
                    list.remove(list.size()-1);
                }
            }
        }
        return false;
    }
    public boolean judgePoint24(int[] cards) {
        List<Double> num=new ArrayList<>();
        for(double c:cards) num.add((double)c);
        return dfs(num);      
    }
}