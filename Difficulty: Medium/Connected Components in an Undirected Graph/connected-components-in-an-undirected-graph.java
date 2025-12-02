class Solution {
    ArrayList<ArrayList<Integer>> ans;
    boolean[] vis;
    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
        // code here
        ans = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i< V; i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i = 0; i< edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        vis = new boolean[V];
        for(int i = 0; i< V; i++){
            if(!vis[i]){
                ArrayList<Integer> temp = new ArrayList<>();
                helper(i, adj, temp);
                ans.add(new ArrayList<>(temp));
            }
        }
        return ans;
    }
    public void helper(int ind, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> temp){
        vis[ind] = true;
        temp.add(ind);
        for(int i =0; i< adj.get(ind).size(); i++){
            if(!vis[adj.get(ind).get(i)]){
                helper(adj.get(ind).get(i), adj, temp);
            }
        }
    }
}