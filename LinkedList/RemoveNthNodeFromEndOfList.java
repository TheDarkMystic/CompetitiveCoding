/*
Given a linked list, remove the nth node from the end of list and return its head.

For example,
Given linked list: 1->2->3->4->5, and n = 2.
After removing the second node from the end, the linked list becomes 1->2->3->5.

Note:
If n is greater than the size of the list, remove the first node of the list.
Try doing it using constant additional space.
 */
package interviewprep.LinkedList;

/**
 *
 * @author jakadam
 */

import java.util.*;
public class RemoveNthNodeFromEndOfList {
     public ListNode removeNthFromEnd(ListNode A, int n) {
       ListNode slow=A;
       ListNode fast=A;
       
       // move fast pointer n+1 times in total. First move n times and later once
       // this maintains the constant gap of n nodes between fast and slow pointers
       for(int i=0;i<n; i++){
            if(fast!=null)
                fast=fast.next;
            else
                break;
       }
       
       // if fast==null remove head
       if(fast==null)
          return A.next;
        
       // now move it once more
       fast= fast.next;
       
       
       // now move the both pointers in sync, 1 step at a time
       while(fast!=null){
           fast=fast.next;
           slow=slow.next;
       }
       
       
       //now remove the slow.next
       slow.next=slow.next.next;
        
       return A;
    }
}


/*
Link-
Notes-
Code without dummy node-

https://leetcode.com/problems/remove-nth-node-from-end-of-list/discuss/8806/My-one-pass-solution

Concept Explaination-
https://leetcode.com/problems/remove-nth-node-from-end-of-list/solution/

*/