class Solution {
    public String winningPlayer(int x, int y) {
        int sv=x*75;
        int t=y*10;
        int total=sv+t;
        boolean player=false;
        while(sv>=75 && t>=40){
            player=!player;
            sv-=75;
            t-=40;
        }
        if(player) return "Alice";
        else return "Bob";
    }
}