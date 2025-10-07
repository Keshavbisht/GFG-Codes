class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        int maxi = -1;
        for(int i = arr.length-1; i>=0; i--){
            if(arr[i] >= maxi){
                ans.add(arr[i]);
                maxi = arr[i];
            }
        }
        Collections.reverse(ans);
        return ans;
    }
}
