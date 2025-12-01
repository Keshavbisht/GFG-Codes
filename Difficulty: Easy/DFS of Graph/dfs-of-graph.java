class Solution {
    ArrayList<Integer> ans = new ArrayList<>();
    
    boolean[] vis;
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int n = adj.size();
        vis = new boolean[n];
        helper(0,adj);
        return ans;
    }
    public void helper(int ind,ArrayList<ArrayList<Integer>> adj){
        vis[ind] = true;
        ans.add(ind);
        // ArrayList<Integer> temp = a
        for(int i = 0; i< adj.get(ind).size();i++){
            int t = adj.get(ind).get(i);
            if(!vis[t]){
                helper(t, adj);
            }
        }
    }
    
}