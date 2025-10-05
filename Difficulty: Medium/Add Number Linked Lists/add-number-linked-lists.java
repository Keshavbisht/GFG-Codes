class Solution {
    
    public Node addTwoLists(Node head1, Node head2) {
        // Remove leading zeros
        head1 = removeLeadingZeros(head1);
        head2 = removeLeadingZeros(head2);
        
        // If both are null, return 0
        if (head1 == null && head2 == null) {
            return new Node(0);
        }
        
        // Reverse both lists
        Node pnt1 = reverse(head1);
        Node pnt2 = reverse(head2);
        
        // Add the two lists
        Node dummy = new Node(0);
        Node temp = dummy;
        int carry = 0;
        
        while (pnt1 != null || pnt2 != null || carry != 0) {
            int sum = carry;
            if (pnt1 != null) {
                sum += pnt1.data;
                pnt1 = pnt1.next;
            }
            if (pnt2 != null) {
                sum += pnt2.data;
                pnt2 = pnt2.next;
            }
            
            temp.next = new Node(sum % 10);
            temp = temp.next;
            carry = sum / 10;
        }
        
        // Reverse the result
        return reverse(dummy.next);
    }
    
    private Node removeLeadingZeros(Node head) {
        while (head != null && head.data == 0) {
            head = head.next;
        }
        return head;
    }
    
    private Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}