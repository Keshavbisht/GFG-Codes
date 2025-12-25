// User function Template for Java

class Solution {
    static int[] replaceWithRank(int arr[], int N) {
        // code here
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] arr1 = new int[N];
        for(int i = 0; i< N; i++){
            arr1[i] = arr[i]; 
        }
        int ind = 1;
        Arrays.sort(arr1);
        for(int i = 0; i< N; i++){
            if(!map.containsKey(arr1[i])){
                map.put(arr1[i], ind);
                ind++;
            }
        }
        for(int i = 0; i< N; i++){
            arr1[i] = map.get(arr[i]); 
        }
        return arr1;
    }
}
