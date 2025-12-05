class Solution {
    Stack<Integer> st;
    boolean[] vis;
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        st = new Stack<>();
        vis = new boolean[V];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i< V; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i< edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            
            adj.get(u).add(v);
        }
        
        for(int i = 0; i< V; i++){
            if(!vis[i]){
                helper(i, adj);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while(!st.isEmpty()){
            ans.add(st.pop());
        }
        return ans;
    }
    public void helper(int ind, ArrayList<ArrayList<Integer>> adj){
        vis[ind] = true;
        
        for(int i = 0; i<adj.get(ind).size(); i++){
            if(!vis[adj.get(ind).get(i)]){
                helper(adj.get(ind).get(i), adj);
            }
        }
        st.push(ind);
        
    }
}