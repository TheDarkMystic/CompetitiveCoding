/*
 *
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Try solving it using constant additional space.

Example :

Input : 

                  ______
                 |     |
                 \/    |
        1 -> 2 -> 3 -> 4

Return the node corresponding to node 3. 
 */
package interviewprep.LinkedList;

/**
 *
 * @author jakadam
 */
import java.util.*;

  //Definition for singly-linked list.
class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
  }
 
public class ListCycle {
    public ListNode detectCycle(ListNode a) {
        
        ListNode fast=a;
        ListNode slow=a;
        ListNode head=a;
        
        //if the LL has no cycle, fast will be the first one to reach end of LL and 
        //we keep fast.next!=null because fast is moving 2 steps so fast and fas.next both can reach the end.
        // hence the while condition
        while(fast!=null && fast.next!=null){
            fast= fast.next.next;
            slow=slow.next;
            
            if(slow==fast)//loop detected
            {
                // finding start of the loop
                // reset the slow to head and now move both pointers 1 step at a time
                slow=head;
                
                while(slow!=fast){
                    slow=slow.next;
                    fast=fast.next;
                }
                //once this loop breaks, meaning once the slow and fast pointing to the same node, we have found start of the cycle
                // why? for the reasoning check leetcode ans comments or gaurav sen's video
                // we can return either slow or fast as both are pointing to the start
                return slow;
            }
        }
        
        return null;// cycle not found
    }
}


  /*
       
       Algorithm is simple
       1. take two pointers slow and fast
       2. slow moves ones step and fast moves 2 steps at a time
       3. if cycle exists, pointers will eventually meet else return NULL
       4. if cycle found run a new pointer from head and again start slow pointer
       5. when we keep them running, they meet at start of cycle.
       6. math for step 5 is given at leetcode solution and gaurav sen video
*/

/*
Links-https://www.interviewbit.com/problems/list-cycle/
Notes-
2 solutions
1> Using hashset
2> using Math

Hashset wala solution given in solution section


Math solution references
https://leetcode.com/problems/linked-list-cycle-ii/#/solutions

https://www.youtube.com/watch?v=apIw0Opq5nk

https://www.youtube.com/watch?v=-YiQZi3mLq0&t=558s
*/