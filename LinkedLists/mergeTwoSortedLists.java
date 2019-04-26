    //Function to merge two sorted lists 
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        /*Using dummynode concept to maintain the head pointer*/ 
        
        ListNode dummyNode = new ListNode(0);
        
        /*
        The head and tail of new list starts at the dummynode
        */
        
        ListNode tail = dummyNode;
        
        /*
        -- While loop which always runs and breaks when a specific condition is met
        -- Initial exit condition is when the first list is null
        -- Second exit condition is when the second list is null
        -- Check values in both the lists
          -- if value in list 1 is less than value in list 2. Add node to tail.next and move the list1 pointer to next
          -- else add node in list2 to tail.next and move the list2 pointer
        -- Move the tail pointer to tail.next
        -- Continue till you reach null in either of the lists. 
        */
        
        while(true){
        if(l1 == null){
            tail.next = l2;
            break;
        }
        
        if(l2 == null){
            tail.next = l1;
            break;
        }

        if(l1.val <= l2.val){
            tail.next = l1;
            l1 = l1.next;
        }else{
            tail.next = l2;
            l2 = l2.next;
        }                
        tail = tail.next;
        }
        return dummyNode.next;
    }
