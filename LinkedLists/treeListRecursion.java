/* Algorithm for the solution
   Introduction 
    - This is an in-place recursive solution which takes O(1) space and O(n) time
    - Algorithm makes use of the in-order traversal property of a binary tree
    - Uses two helper functions to join() and append nodes()
    - join() - utility function to connect two list nodes
    - append() - utility function to append two lists
   
   Algorithm
    - This needs to be a in-place solution. 
    - Solution which involves in modifying the left and right pointer of each node in the tree,
      to the next and previous pointer of the nodes in the doubly linked list
    - Using inorder traversal property. Collect all nodes of the left subtree
    - Collect all nodes of the right subtree by recursing right
    - One trick is to set the root node circular
      - The .next and .previous pointer is set to itself
    - Create the doubly linked list with the left tree, root and right subtree
    - return the list
*/



class Solution {
    
    /*
      - Given two list nodes, join them together so the second immediately follow the first.
      - Sets the .next of the first and the .previous of the second.
    */
    
    public void joinNodes(Node a, Node b){
        a.right = b;
        b.left = a;
    }
    
    /*
      - Given two circular doubly linked lists, append them and return the new list      
    */
    
    public Node appendNodes(Node a, Node b){
        if(a == null){return b;}
        if(b == null){return a;}
        
        Node newA = a.left;
        Node newB = b.left;
        
        joinNodes(newA, b);
        joinNodes(newB, a);
        
        return a;        
    }
    
    public Node treeToDoublyList(Node root) {
        
        if(root == null){return root;}
        
        Node left = treeToDoublyList(root.left);
        Node right = treeToDoublyList(root.right);
        
        root.left = root;
        root.right = root;
        
        left = appendNodes(left, root);
        left = appendNodes(left, right);
        
        return left;
        
    }
}
