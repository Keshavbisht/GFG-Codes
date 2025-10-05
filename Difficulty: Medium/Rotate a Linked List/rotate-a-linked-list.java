/*
class Node {
    int data;
    Node next;

    Node(int d){
        data=d;
        next=null;
   }
}
*/

class Solution {
    public Node rotate(Node head, int k) {
        // code here
        if(head.next == null || k==0) return head;
        if(head == null) return null;
        
        Node temp = head;
        int i = 1;
        while(temp.next != null){
            i++;
            temp = temp.next; 
        }
        temp.next = head;
        if(i>k){
            k = k%i;
        }
        temp = head;
        
        for(int j = 1; j<k; j++ ){
            temp = temp.next;
        }
        head = temp.next;
        temp.next = null;
        return head;
        
    }
}