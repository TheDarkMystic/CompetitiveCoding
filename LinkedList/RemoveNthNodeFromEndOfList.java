/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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