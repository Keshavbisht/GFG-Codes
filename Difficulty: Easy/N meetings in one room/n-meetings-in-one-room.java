class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public int maxMeetings(int start[], int end[]) {
        // add your code here
        int n = start.length;
        int[][] arr = new int [n][2];
        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)-> a[1] - b[1]);
        for(int i = 0; i< n; i++){
            arr[i][0] = start[i];
            arr[i][1] = end[i];
            pq.add(arr[i]);
        }
        int ans = 0;
        int prev = -1;
        while(!pq.isEmpty()){
            int[] curr = pq.remove();
            // System.out.println(prev);
            if(prev < curr[0]){
                // System.out.println("curr" + curr[0]);
                ans++;
                prev = curr[1];
            }
        }
        return ans;
        
        // PriorityQueue<int[]> pq= new PriorityQueue<>();
        
    }
}
