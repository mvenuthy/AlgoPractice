/*
  - Rabbit and hare concept
  - Have two pointers which start at head
  - Slow pointer travels at one node per iteration
  - Fast pointer travels twice as fast as slow pointer
  - If they both meet
    - Have a while condition where head needs to travel till the loop in the list
    - Return the slow pointer
  - Return null if there is no loop in the list
*/

public class Solution {
    public ListNode detectCycle(ListNode head) {        
            ListNode slow = head;
            ListNode fast = head;
            while(fast != null && fast.next != null){
                fast = fast.next.next;
                slow = slow.next;
                if(slow == fast){                    
                    while(head != slow){
                        head = head.next;
                        slow = slow.next;
                    }
                    return slow;
                }
            }            
            return null;
        }    
}
