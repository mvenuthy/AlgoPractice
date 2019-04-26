/*
    Constant space and O(m+n) solution
*/

/*
  - Have two pointers a and b which denote the head of listA and listB respectively
  - Have a while condition that terminates if a == b
  - If a reaches null, reassign it back to head of listB
  - if b reaches null, reassign it back to head of listA
  - Keep traversing if not. 
  - To see why the above trick would work, consider the following two lists: A = {1,3,5,7,9,11} and B = {2,4,9,11}, 
    which are intersected at node '9'. Since B.length (=4) < A.length (=6), b would reach the end of the merged list first, 
    because b traverses exactly 2 nodes less than a does. By redirecting b to head listA, and a to listB, 
    we now ask b to travel exactly 2 more nodes than a would. 
    So in the second iteration, they are guaranteed to reach the intersection node at the same time.
  - If two lists have intersection, then their last nodes must be the same one. 
    So when a/b reaches the end of a list, record the last element of listA/listB respectively. 
    If the two last elements are not the same one, then the two lists have no intersections.
*/

public class Solution {            
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        if(headA == null || headB == null){return null;}
        
        ListNode a = headA;
        ListNode b = headB;
        
        while(a!=b){
            
            if(a == null){
                a = headB;
            }else{
                a = a.next;
            }   
            
            if(b == null){
                b = headA;                
            }else{
                b = b.next;   
            }        
        }        
        return a;
    }
 
