// User function Template for Java

class Solution {
    boolean[][] vis;
    int n;
    int m;
    int countDistinctIslands(int[][] grid) {
        // Your Code here
        n = grid.length;
        m = grid[0].length;
        
        vis = new boolean[n][m];
        Set<List<Integer>> set = new HashSet<>();
        
        for(int i = 0; i< n; i++){
            for(int j = 0; j< m; j++){
                if(vis[i][j] == false && grid[i][j] == 1){
                    List<Integer> temp = new ArrayList<>();
                    helper(i,j,grid, i,j,temp);
                    set.add(temp);
                }
            }
        }
        return set.size();
        
    }
    public void helper(int i, int j, int[][] grid, int pi, int pj, List<Integer> temp){
        if(i <0 || i>=n || j<0 || j>=m || grid[i][j] != 1|| vis[i][j]) return;
        vis[i][j] = true;
        
        temp.add(i-pi);
        temp.add(j-pj);
        helper(i+1, j, grid, pi, pj, temp);
        helper(i-1, j, grid, pi, pj, temp);
        helper(i, j+1, grid, pi, pj, temp);
        helper(i, j-1, grid, pi, pj, temp);
        return;
        
        
        
        
    }
}
