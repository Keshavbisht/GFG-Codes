/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/
class tuple{
    int LeftMax;
    int RightMin;
    boolean isBST;
    tuple(int LeftMax, int RightMin, boolean isBST){
        this.LeftMax = LeftMax;
        this.RightMin = RightMin;
        this.isBST = isBST;
    }
}
class Solution {
    public boolean isBST(Node root) {
        tuple ans = helper(root);
        return ans.isBST;
        
    }
    public tuple helper(Node root){
        if (root == null) return new tuple(Integer.MIN_VALUE, Integer.MAX_VALUE, true);
        
        if(root.left == null && root.right == null){
            return new tuple(root.data, root.data, true);
        }
        tuple curr = new tuple(Integer.MIN_VALUE, Integer.MAX_VALUE, false);
        tuple left = helper(root.left);
        tuple right = helper(root.right);
        
        if(left.isBST && right.isBST && left.LeftMax < root.data && right.RightMin > root.data){
            curr.LeftMax = Math.max(root.data, right.LeftMax);
            curr.RightMin = Math.min(root.data, left.RightMin);
            curr.isBST = true;
            return curr;
        }
        return curr;
    }
    
}