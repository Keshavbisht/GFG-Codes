/*
class Node {
    int data;
    Node next;
    Node(int x) {
        data = x;
        next = null;
    }
}
*/
class Solution {
    public Node joinTheLists(Node head1, Node head2) {
        // code here
        Node temp = head1;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = head2;
        return head1;
    }
}
