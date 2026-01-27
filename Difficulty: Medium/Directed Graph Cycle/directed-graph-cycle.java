class Solution {
    boolean[] vis;
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        vis = new boolean[V];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i< V; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i< edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
        }
        boolean[] flag;
        for(int i = 0; i< V; i++){
            if(!vis[i]){
                flag  = new boolean[V];
                if(dfs(i, adj,flag)) return true;
            }
        }
        return false;
        
        
    }
    public boolean dfs(int ind, ArrayList<ArrayList<Integer>> adj, boolean[] flag){
        if(flag[ind] == true) return true;
        flag[ind] = true;
        vis[ind] = true;
        for(int i = 0; i< adj.get(ind).size(); i++){
            int temp = adj.get(ind).get(i);
            if(dfs(temp, adj, flag)) return true;
        }
        flag[ind] = false;
        return false;
    }
}