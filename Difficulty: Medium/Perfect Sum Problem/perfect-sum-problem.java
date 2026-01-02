class Solution {
    int ans= 0;
    // Function to calculate the number of subsets with a given sum
    public int perfectSum(int[] nums, int target) {
        // code here
        
        int[][] dp = new int[nums.length+1][target + 1];
        
        for(int[] itr: dp){
            Arrays.fill(itr, -1);
        }
        return helper(0, 0, target, nums, dp);
        
    }
    public int helper(int ind, int total, int target, int[] nums, int[][] dp){
        if(total>target) return 0;
        if(ind == nums.length){
            if(total == target){
                ans++;
                return 1;
            }
            return 0;
        }
        if(dp[ind][total] != -1) return dp[ind][total];
        int a = helper(ind+1, total+nums[ind], target, nums, dp);
        int b = helper(ind+1, total, target, nums, dp);
        return dp[ind][total] = a+b;
    }
}