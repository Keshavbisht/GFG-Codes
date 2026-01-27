class Solution {
    boolean vis[];
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        vis = new boolean[V];
        Arrays.fill(vis, false);
        
        for(int i = 0; i< V; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i< edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        for(int i = 0; i< V; i++){
            if(vis[i] == false){
                if(dfs(i, adj, -1)) return true;
            }
        }
        return false;
    }
    public boolean dfs(int ind, ArrayList<ArrayList<Integer>> adj, int parent){
        if(vis[ind] == true) return true;
        vis[ind] = true;
        
        for(int i = 0; i< adj.get(ind).size(); i++){
            int temp = adj.get(ind).get(i);
            if(temp != parent){
                if(dfs(temp, adj, ind)) return true;
            }
        }
        return false;
    }
}