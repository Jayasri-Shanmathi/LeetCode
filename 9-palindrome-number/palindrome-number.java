class Solution {
    public boolean isPalindrome(int x) {
        int num=x;
        int sum=0;
        int rem=0;
        while(num>0){
            sum=num%10;
            rem=rem*10+sum;
            num=num/10;
        }
        if(rem==x)
           return true;
        else
           return false;   
    }
}