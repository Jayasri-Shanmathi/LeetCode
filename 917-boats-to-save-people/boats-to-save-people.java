class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int boats=0;int left=0;int right=people.length-1;
        Arrays.sort(people);
        while(left<=right){
            int weight=people[left]+people[right];
            if(weight<=limit){
                 left++;
            }
            boats++;right--;
        }return boats;
}}