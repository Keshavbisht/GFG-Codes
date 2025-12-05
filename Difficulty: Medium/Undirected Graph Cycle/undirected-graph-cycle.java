class Pair{
    int a;
    int b;
    Pair(int x, int y){
        a =x;
        b =y;
    }
}
class Solution {
    boolean[] vis;
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        int n = edges.length;
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i< V; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i< edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        vis = new boolean[V];

        for(int i = 0; i< V; i++){
            if(vis[i] == false){
                if(helper(i, -1, adj)) return true;
            }
        }
        return false;
        
    }
    public boolean helper(int ind, int par,List<List<Integer>> adj){
        vis[ind] = true;
        
        for(int i = 0; i< adj.get(ind).size();i++){
            if(vis[adj.get(ind).get(i)] == false){
                if(helper(adj.get(ind).get(i), ind, adj)) return true;
            }
            else if(vis[adj.get(ind).get(i)] == true && par != adj.get(ind).get(i)) return true;
        }
        return false;
    }
}