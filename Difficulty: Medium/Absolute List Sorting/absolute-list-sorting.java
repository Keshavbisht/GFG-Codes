/* The structure of the node of the Linked List is
class Node
{
   int data;
   Node next;
   Node(int d) {data = d; next = null; }
 }
*/

class Solution {
    Node sortList(Node head) {
        // Your code here
        Node negative = new Node(-1);
        Node positive = new Node(1);
        Node pnt1 = negative;
        Node pnt2 = positive;
        
        Node temp =head;
        while(temp != null){
            Node nextNode = temp.next;
            temp.next = null;
            if(temp.data <0){
                pnt1.next = temp;
                pnt1 = pnt1.next;
            }
            else{
                pnt2.next = temp;
                pnt2 = pnt2.next;
            }
            temp = nextNode;
        }
        pnt2.next = null;
        // temp = negative.next;
        Node nHead = reverse(negative.next);
        if(nHead == null) return positive.next;
        Node nTail = nHead;
        while(nTail.next!=null){
            nTail = nTail.next;
        }
        nTail.next = positive.next;
        return nHead;
    }
    public Node reverse(Node node){
        Node curr = node;
        Node prev = null;
        Node future;
        while(curr!= null){
            future = curr.next;
            curr.next = prev;
            prev = curr;
            curr = future;
        }
        return prev;
    }
}