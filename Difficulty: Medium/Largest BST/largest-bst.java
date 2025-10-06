// class Node
// {
//     int data;
//     Node left, right;

//     public Node(int d)
//     {
//         data = d;
//         left = right = null;
//     }
// }

class Solution {
    class tuple{
        int size;
        int leftMax;
        int rightMin;
        boolean isBST;
        tuple(int size, int left, int right,boolean isBST){
            this.size = size;
            this.leftMax = left;
            this.rightMin = right;
            this.isBST= isBST;
        }
    }

    // Return the size of the largest sub-tree which is also a BST
    public int largestBst(Node root) {
        return helper(root).size;
        
    }
    public tuple helper(Node root){
        if(root == null) return new tuple(0, Integer.MIN_VALUE, Integer.MAX_VALUE, true);
        if(root.left == null && root.right == null){
            return new tuple(1, root.data, root.data, true);
        }
        tuple left = helper(root.left);
        tuple right = helper(root.right);
        tuple curr = new tuple(1, Integer.MAX_VALUE, Integer.MIN_VALUE, true);
        
        if(left.isBST && right.isBST && left.leftMax < root.data && right.rightMin>root.data){
            curr.size = left.size + right.size +1;
            curr.leftMax = Math.max(root.data, right.leftMax);
            curr.rightMin = Math.min(root.data, left.rightMin);
            curr.isBST = true;
            return curr;
        }
        
        curr.size = Math.max(left.size, right.size);
        curr.isBST = false;
        return curr;
        
        
        
    }
}