class Solution {
    static List<Integer> firstNegInt(int arr[], int k) {
        // write code here
        int pnt1= 0;
        int pnt2 = -1;
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        while(pnt2 < arr.length-1){
            pnt2++;
            if(arr[pnt2] < 0){
                pq.add(pnt2);
            }
            if((pnt2 - pnt1)+1 == k){
                if(pq.isEmpty()){
                    ans.add(0);
                }
                else{
                    int temp = pq.remove();
                    ans.add(arr[temp]);
                    if(temp >=pnt1+1){
                        pq.add(temp);
                    }
                }
                pnt1++;
            }
        }
        return ans;
        
        
    }
}