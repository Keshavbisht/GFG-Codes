class Solution {
    int[] indegree;
    int[] vis;
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        ArrayList<Integer> ans = new ArrayList<>();
        indegree = new int[V];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i< V; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i< edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            indegree[edges[i][1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i< V; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int curr = q.remove();
            ans.add(curr);
            
            for(int i = 0; i< adj.get(curr).size(); i++){
                int temp = adj.get(curr).get(i);
                indegree[temp]--;
                if(indegree[temp]== 0){
                    q.add(temp);
                }
            }
        }
        return ans;
        
        
    }
}