class Solution {
    public int peakElement(int[] arr) {
        // code here
        if(arr.length == 1) return 0;
        for(int i = 0; i< arr.length; i++){
            if(i == 0){
                if(arr[i+1]<arr[i]) return 0;
            }
            else if((i==arr.length-1)){
                 if(arr[i-1] < arr[i]) return i;
            }
            
            else{
                if(arr[i]>arr[i-1] && arr[i] > arr[i+1]) return i;
            }
        }
        return 0;
    }
}