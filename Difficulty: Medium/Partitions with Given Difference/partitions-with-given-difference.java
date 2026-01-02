class Solution {
    public int countPartitions(int[] arr, int diff) {
        // code here
        int sum1 = 0;
        for(int i= 0; i< arr.length; i++){
            sum1 = sum1 + arr[i];
        }
        int[][] dp = new int[arr.length +1][sum1 +1];
        for(int[] itr: dp){
            Arrays.fill(itr, -1);
        }
        return helper(0, 0,sum1, sum1, arr, diff, dp);
        
    }
    public int helper(int ind, int total,int second, int sum, int[] arr, int diff, int[][] dp){
        if(second - total < diff) return 0;
        if(ind == arr.length){
            // int temp = sum - total;
            if(second - total == diff) return 1;
            return 0;
        }
        if(dp[ind][total] != -1) return dp[ind][total];
        
        int a = helper(ind+1, total+arr[ind],second-arr[ind], sum, arr, diff, dp);
        int b = helper(ind+1, total, second, sum, arr,diff, dp);
        return dp[ind][total] = a+b;
        
    }
}
