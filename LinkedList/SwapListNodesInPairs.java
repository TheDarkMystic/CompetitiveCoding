/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
*/
package interviewprep.LinkedList;

/**
 *
 * @author jakadam
 */
public class SwapListNodesInPairs {
    public ListNode swapPairs(ListNode A) {
        //corner case
        if(A==null || A.next==null)
            return A;
        // Imagine only 2 nodes for this solution
        
        // this   will be the head of ans list      
        ListNode head=A.next;
        
        // as usual, a create prev and next( in this case temp inside while) for 
        // reversal operation
        
        ListNode prev=null;
       
            // if there are atleast 2 nodes
           while(A!=null && A.next!=null){
               // adjust pointers of 2 nodes to make them reverse
               ListNode temp=A.next;
               A.next=A.next.next;
               temp.next=A;
               
               // connect the reversed pair with remaing part of the list
               if(prev!=null)   
                    prev.next=temp;
                
                //adjust prev pointer for next pair to be reversed
                prev=A;
                //move to the next pair
                A=A.next;
                    
           }
           
           // we created this pointer at the start
            return head;
    }
    
}

/*
Links-https://www.interviewbit.com/problems/swap-list-nodes-in-pairs/

Notes-
Study own logic

// recursive solution as created in 'k reverse LL' is not accepted here because it uses O(n) call stack space

Optional-

http://www.programcreek.com/2014/04/leetcode-swap-nodes-in-pairs-java/

http://www.geeksforgeeks.org/pairwise-swap-elements-of-a-given-linked-list/


------------------------------------------------------------------
https://www.youtube.com/watch?v=jiLloHVmLDc
*/