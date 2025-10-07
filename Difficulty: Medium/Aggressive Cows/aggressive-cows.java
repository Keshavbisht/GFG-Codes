class Solution {
    public int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        int low = 1;
        int high = stalls[stalls.length - 1] - stalls[0];
        
        int ans = high;
        while(low <= high){
            int mid = low + (high-low)/2;
            
            boolean check = helper(stalls, k, mid);
            if(check == true){
                ans = mid;
                low = mid+1;
                
            }
            else{
                high = mid-1;
            }
        }
        return ans;
        
    }
    public boolean helper(int[] stalls, int k, int mid){
        int last = 0;
        int count =1;
        
        for(int i = 1; i< stalls.length; i++){
            if(stalls[i] - stalls[last] >= mid){
                count++;
                last = i;
            }
            if(count == k) return true;
            
        }
        return false;
    }
}