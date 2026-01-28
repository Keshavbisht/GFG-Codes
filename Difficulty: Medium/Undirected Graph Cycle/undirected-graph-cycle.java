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
                if(bfs(i, adj)) return true;
            }
        }
        return false;
    }
    public boolean bfs(int ind, ArrayList<ArrayList<Integer>> adj){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{ind, -1});
        
        // q.add(null);
        while(!q.isEmpty()){
            int[] curr = q.remove();
            if(vis[curr[0]] == true) return true;
            vis[curr[0]] = true;
            for(int i = 0; i< adj.get(curr[0]).size(); i++){
                int temp = adj.get(curr[0]).get(i);
                if(temp != curr[1]){
                    q.add(new int[]{temp, curr[0]});
                }
            }
        }
        return false;
    }
}