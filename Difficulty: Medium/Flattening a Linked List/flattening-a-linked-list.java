/*
class Node {
    int data;
    Node next;
    Node bottom;

    Node(int x) {
        data = x;
        next = null;
        bottom = null;
    }
}
*/
class Solution {
    public Node flatten(Node root) {
        // code here
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.data - b.data);
        Node temp = root;
        while(temp != null){
            pq.add(temp);
            Node temp2 = temp.bottom;
            while(temp2 != null){
                pq.add(temp2);
                temp2 = temp2.bottom;
            }
            temp = temp.next;
        }
        Node dummy = new Node(-1);
        temp = dummy;
        while(!pq.isEmpty()){
            Node node = pq.remove();
            node.next = null;       
            node.bottom = null;     
            temp.bottom = node;     
            temp = temp.bottom;

        }
        return dummy.bottom;
        
    }
}