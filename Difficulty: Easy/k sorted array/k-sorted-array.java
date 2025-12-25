// User function Template for Java

class Solution {
    static String isKSortedArray(int arr[], int n, int k) {
        // code here
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] arr1 = new int[n];
        for(int i = 0; i< n; i++){
            arr1[i] = arr[i];
            
        }
        Arrays.sort(arr1);
        for(int i = 0; i< n; i++){
            map.put(arr1[i], i);
            
        }
        
        for(int i = 0; i< arr.length; i++){
            if(Math.abs(i - map.get(arr[i])) > k) return "No"; 
        }
        return "Yes";
    }
}