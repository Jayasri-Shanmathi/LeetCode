class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
           if(s1.length()+s2.length() != s3.length()) return false;
           int i1=0,i2=0;
           Boolean[][] dp=new Boolean[s1.length()+1][s2.length()+1];
           return isValid(i1,i2,s1,s2,s3,dp);       
        }
    private Boolean isValid(int i1,int i2,String s1,String s2,String s3,Boolean[][]dp){
            if(i1+i2==s3.length()) return true;
            if(dp[i1][i2]!= null) return dp[i1][i2];
            Boolean valid=false;
            if(i1<s1.length() && s1.charAt(i1)==s3.charAt(i1+i2)){
                valid=isValid(i1+1,i2,s1,s2,s3,dp);
            }
            if(!valid && i2<s2.length() && s2.charAt(i2)==s3.charAt(i1+i2)){
                valid=isValid(i1,i2+1,s1,s2,s3,dp);
            }
            dp[i1][i2]=valid;
            return valid;
        }
    }