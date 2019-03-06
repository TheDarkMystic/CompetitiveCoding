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
public class ReorderList {
    
    public ListNode reorderList(ListNode A) {
        /*
            Read Palindrome List solution for detailed explaination
            STEP1: find Middle of the list, break the list into 2
            STEP2: Reverse the second list
            STEP3: Merge the Lists node by node.
        */
        
        if(A==null || A.next==null)
            return A;
        
        // STEP1: Find Middle of the list
        ListNode head1=A;
        ListNode fast=A;
        ListNode slow=A;
        
        while(fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        
        ListNode head2=slow.next;
        slow.next=null;
        
        
        //STEP2: reverse the second list
        ListNode cur=head2;
        ListNode prev=null;
        ListNode next=null;
        
        
        while(cur!=null){
            next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        
        head2=prev;
        
        
        //STEP3: Merge Lists
        ListNode dummy=new ListNode(0);
        ListNode dummyCur=dummy;
        
        while(head1!=null && head2!=null){
            // add node from list1
            dummyCur.next=head1;
            head1=head1.next;
            dummyCur=dummyCur.next;
            
            // add node from list2
            dummyCur.next=head2;
            head2=head2.next;
            dummyCur=dummyCur.next;
        }
        
        if(head1==null)
            dummyCur.next=head2;
        else
            dummyCur.next=head1;
        
    
        return dummy.next;
    }
}

/*
Links-https://www.interviewbit.com/problems/reorder-list/

Notes-
https://leetcode.com/problems/reorder-list/#/solutions

http://www.geeksforgeeks.org/rearrange-a-given-linked-list-in-place/
*/
