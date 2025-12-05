class Solution {
    boolean[] vis;
    boolean[] rec;
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i< V; i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i = 0; i< edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            
            adj.get(u).add(v);
        }
        vis = new boolean[V];
        rec = new boolean[V];
        
        
        for(int i = 0; i< V; i++){
            if(vis[i] == false){
                if(helper(i, -1, adj)) return true;
            }
        }
        return false;
        
        
    }
    public boolean helper(int ind, int par,ArrayList<ArrayList<Integer>> adj){
        vis[ind] = true;
        rec[ind] = true;
        
        for(int i = 0; i< adj.get(ind).size(); i++){
            if(vis[adj.get(ind).get(i)] == false){
                if(helper(adj.get(ind).get(i), ind, adj)) return true;
            }
            else if(vis[adj.get(ind).get(i)] == true && rec[adj.get(ind).get(i)] == true ) return true;
        }
        rec[ind] = false;
        return false;
    }
}