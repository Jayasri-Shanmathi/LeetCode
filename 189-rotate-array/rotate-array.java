class Solution {
    public void rotate(int[] nums, int k) {
    int n=nums.length;
    k=k%n;
    int left=0;
    int right=n-1;
    while(left<=right){
          int temp=nums[left];
          nums[left]=nums[right];
          nums[right]=temp;
          left++;right--;
    }
    left=0;
    right=k-1;
    while(left<=right){
          int temp=nums[left];
          nums[left]=nums[right];
          nums[right]=temp;
          left++;right--;
    }
    left=k;
    right=n-1;
    while(left<=right){
          int temp=nums[left];
          nums[left]=nums[right];
          nums[right]=temp;
          left++;right--;
    }

}}