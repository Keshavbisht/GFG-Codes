// User function Template for Java

class Solution {
    public ArrayList<Integer> largestValues(Node root) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<Node> q = new LinkedList<>();


        q.add(root);
        q.add(null);
        int maxi = Integer.MIN_VALUE;
        while(!q.isEmpty()){
            Node curr = q.remove();
            if(curr == null){
                if(q.isEmpty()){
                    ans.add(maxi);
                    return ans;
                }
                else{
                    q.add(null);
                    ans.add(maxi);
                    maxi = Integer.MIN_VALUE;
                }
            }
            else{
                maxi = Math.max(maxi, curr.data);
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
            
        }
        return ans;
    }
}