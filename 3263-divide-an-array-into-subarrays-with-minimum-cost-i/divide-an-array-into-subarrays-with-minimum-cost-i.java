class Solution {
    public int minimumCost(int[] nums) {
        int cost = nums[0];
        int[] rest = Arrays.copyOfRange(nums, 1, nums.length);
        Arrays.sort(rest);
        cost += rest[0] + rest[1];
        return cost;
    }
}