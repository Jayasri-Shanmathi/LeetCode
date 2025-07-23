class Solution {
    public String longestPalindrome(String s) {
           int n=s.length();
           if(n==1) return s;
           if(n==2 && s.charAt(0)==s.charAt(1)){
                return s;
           }
           if(n==2) {return Character.toString(s.charAt(0));}
           int start=0;int max=1;
           int[][]dp=new int[n][n];
           for(int i=0;i<n;i++){
                dp[i][i]=1;
            }
           for(int i=0;i<n-1;i++){
             if(s.charAt(i)==s.charAt(i+1)){
                 dp[i][i+1]=1;start=i;max=2;        
             }
            }
           for(int len=3;len<=n;len++){
            for(int row=0;row<=n-len;row++){
                int col=row+len-1;
                if(s.charAt(row)==s.charAt(col) && dp[row+1][col-1]==1){
                    dp[row][col]=1;
                    start=row;max=len;
                }
            }
           }
           return s.substring(start,start+max);
        
        }

    }
