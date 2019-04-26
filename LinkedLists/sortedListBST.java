/* 
  Problem Introduction and Algorithm
    Introduction
      - Convert a sorted singly linked list into a BST.
      - Uses a helper function called constructBST to recursively build the BST from root, left subtree and right subtree
    Algorithm
      - Tortoise and hare concept.
      - Slow pointer travels at one node per iteration
      - Fast pointer travels at twice the speed of the slow pointer
      - Based on this, we have start, middle and end
      - Recursively follow this to build the left subtree and right subtree
      - Return the tree.
*/

class Solution {
    
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){return null;}
        TreeNode result = constructBST(head,null);
        return result;
    }
    
    public TreeNode constructBST(ListNode start, ListNode end){        
        ListNode slow = start;
        ListNode fast = start;
        if(start == end){return null;}
        
        while(fast != end&&fast.next != end){
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = constructBST(start,slow);
        root.right = constructBST(slow.next,end); 
        return root;
    }
}
