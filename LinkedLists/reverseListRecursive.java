class Solution {
        
      //Recursive Reverse Solution
      public ListNode reverseList(ListNode head){
          if(head == null){return head;}
          if(head.next == null){return head;}
          ListNode newHead = reverseList(head.next);
          head.next.next = head;
          head.next = null;
          return newHead;                    
      }
     }
