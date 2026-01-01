class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        Boolean[][] dp = new Boolean[arr.length+1][sum+1];
        // for(boolean[] itr: dp){
        //     Arrays.fill(itr, false);
        // }
        return helper(0, 0, arr, sum, dp);
    }
    public static boolean helper(int ind,int total,  int[] arr, int sum, Boolean[][] dp){
        if(total > sum) return false;

        if(ind == arr.length){
            if(total == sum) return true;
            else{return false;}
        }
        // if(ind > arr.length) return false;
        if(dp[ind][total] != null) return dp[ind][total];
        
        return dp[ind][total] = helper(ind+1, total+arr[ind], arr, sum, dp) ||helper(ind+1, total, arr, sum, dp);
    }
}