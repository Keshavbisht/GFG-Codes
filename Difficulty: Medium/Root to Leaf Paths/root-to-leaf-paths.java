/*

Definition for Binary Tree Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        // code here
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        helper(root,temp, ans);
        return ans;
        
    }
    public static void helper(Node root, ArrayList<Integer> temp,ArrayList<ArrayList<Integer>> ans){
        if(root == null) return;
        if(root.left == null && root.right == null){
            temp.add(root.data);
            ans.add(new ArrayList<>(temp));
            temp.remove(temp.size()-1);
        }
        temp.add(root.data);
        helper(root.left, temp, ans);
        helper(root.right, temp, ans);
        temp.remove(temp.size()-1);
        return;
        
    }
}