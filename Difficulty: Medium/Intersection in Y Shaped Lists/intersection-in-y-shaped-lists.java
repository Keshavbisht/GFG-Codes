/*
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
*/

class Solution {
    public Node intersectPoint(Node head1, Node head2) {
        // code here
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        helper(head1, st1);
        helper(head2, st2);
        Node prev=null;
        while(st1.peek() == st2.peek()){
            prev = st1.pop();
            st2.pop();
            
        }
        return prev;
        
    }
    public void helper(Node head, Stack<Node> st1){
        Node temp = head;
        while(temp != null){
            st1.push(temp);
            temp = temp.next;
        }
        return;
    }
}