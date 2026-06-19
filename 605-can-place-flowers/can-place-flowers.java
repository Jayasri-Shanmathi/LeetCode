class Solution {
    public boolean canPlaceFlowers(int[] arr, int n) {
        int len=arr.length;int pot=0;
        if(len==1){
            if(arr[0]==0)pot++;
            return (pot>=n);
        }
        for(int i=0;i<len;i++){
            if(arr[i]==0){
                if(i!=0 && i!=len-1){
                    if(arr[i-1]!=1 && arr[i+1]!=1){
                        pot++;arr[i]=1;
                    }
                }
                else if(i==0 && arr[i+1]!=1){
                    pot++;arr[i]=1;
                }
                else if(i==len-1 && arr[i-1]!=1){
                    pot++;arr[i]=1;
                }
            }
        }
        return (pot>=n);
    }
}