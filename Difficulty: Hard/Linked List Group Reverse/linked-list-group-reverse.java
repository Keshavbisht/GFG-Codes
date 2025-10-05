/*
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}
*/

class Solution {
    public Node reverseKGroup(Node head, int k) {
        // code here
        
        Node dummy = new Node(-1);
        dummy.next = head;
        Node temp = dummy;
        
        
        while(temp.next != null){
            Node temp2 = temp.next;
            // temp.next = reverse(temp, k);
            int i = 0;
            Node curr = temp.next;
            Node prev = null;
            Node future;
            while(curr != null && i<k){
                i++;
                future = curr.next;
                curr.next = prev;
                prev = curr;
                curr = future;
            }
            temp.next = prev;
            temp2.next = curr;
            temp = temp2;
            
        }
        return dummy.next;
        
    }
    
}