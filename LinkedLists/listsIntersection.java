/*
Algorithm
- Calculate length of the two given lists using a helper function
- If either of the lists are null. return null
- If length of listA is greater than listB. 
    - Move the local head pointer of A for the number of times the decrement happens
    - Decrement the length value of listA till length of A and B are equal
- If length of listB is greater than listA.
    - Move the local head pointer of B for the number of times the decrement happens
    - Decrement the length value of listB till length of A and B are equal
- Start a loop with a exit condition of localHeadA != localHeadB and keep moving the local heads. 
- Return localHeadA or localHeadB
*/


public class Solution {
    
    /*
    Helper function to calculate the length of each list
    */
    
    public int lengthOfList(ListNode head){
        ListNode current = head;
        int count = 0;
        while(current != null){
            count++;
            current = current.next;
        }
        return count;
    }
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            
        int lenA = lengthOfList(headA);
        int lenB = lengthOfList(headB);
        int diff; 
        
        if(headA == null || headB == null){return null;}
        
    /*
      Move the head pointer of listA
      Decrement the length of listA to be equal to length of listB.
    */
        
        while (lenA > lenB){
            headA = headA.next;
            lenA --;
        }
    
    /*
      Move the head pointer of listB
      Decrement the length of listB to be equal to length of listA.
    */
    
        while (lenB > lenA){
            headB = headB.next;
            lenB--;
        }
   /* 
    Start a loop with a exit condition of localHeadA != localHeadB and keep moving the local heads. 
    Return localHeadA or localHeadB
   */
  
        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}
