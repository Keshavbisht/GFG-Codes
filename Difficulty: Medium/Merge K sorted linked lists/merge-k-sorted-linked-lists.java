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
    Node mergeKLists(Node[] lists) {
        Node dummy = new Node(-1);
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.data - b.data );

        for(Node it: lists){
            if(it !=null){
                pq.add(it);
            }
        }
        Node curr = dummy;
        while(!pq.isEmpty()){
            Node temp = pq.remove();
            curr.next = temp;
            curr = curr.next;
            if(temp.next != null){
                pq.add(temp.next);
            }
        }

        return dummy.next;
        
    }
}