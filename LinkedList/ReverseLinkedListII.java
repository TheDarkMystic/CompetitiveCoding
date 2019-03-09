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

public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode A, int B, int C) {
        if(A==null || A.next==null)
            return A;
        
        ListNode head=A;
        ListNode cur=A;
        ListNode prev=null;
        
        // keep track of current and prev at the same point
        // prev is supposed to point ti the node just before the starting point for reversal
        // so that we can connect the reversed list to 1st part(non-reversed) of list
       for(int i=1;i<B; i++){
           prev=cur;
           cur=cur.next;
       }
       //how many node are to be reversed
       int count=C-B+1;
       
       // call to reverse function
       ListNode headOfRevLL=reverse(cur,count);
       
       //prev==null means we started the reversal process from node 1
       //eg. 1->2->3 start=1, end=2
       if(prev==null )
            return headOfRevLL;
       else//connect the first(non-reversed) part of the list ot the reversed part
            prev.next=headOfRevLL;
       
       
       return head;
    }
    
    
    // this function actually reverses the list segment
    // very similar to what we did on 'k reverse list problem'
    public ListNode reverse(ListNode head, int count){
        ListNode next=null;
        ListNode prev=null;
        ListNode cur=head;
        
        
        while(count-->0 && cur!=null){
            next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        //after reversing, head points to the end of the reversed list
        // connect it with the list remaining after B index from input.
        head.next=cur;
        
        // return head to reversed list connected with remaing 2nd part of list
        return prev;
    }
}
/*
Links-https://www.interviewbit.com/problems/reverse-link-list-ii/

Notes-  
https://leetcode.com/problems/reverse-linked-list-ii/#/solutions

*/
