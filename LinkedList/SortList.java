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



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        
        if(head==null || head.next==null)// single element or empty list
            return head;
        
        
        //step1: find middle
        ListNode slow=head, fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        
        ListNode l1End=slow;//marking last node of l1
        slow=slow.next;// now slow is middle
        l1End.next=null;// marking end of l1
        
        
        //step 2: Sort each list-recursion
        ListNode l1=sortList(head);
        ListNode l2=sortList(slow);
        
        //step3: merge lists
        ListNode newHead=merge(l1, l2);
        
        
        return newHead;
        
    }
    
    public ListNode merge(ListNode head1, ListNode head2){
        ListNode dummy=new ListNode(0), cur=dummy;
        
        while(head1!=null && head2!=null){
            if(head1.val<=head2.val){
                cur.next=head1;
                head1=head1.next;
            }
            else{
                cur.next=head2;
                head2=head2.next;
            }
            cur=cur.next;
        }
        
        //l1 not exausted
        if(head1!=null)
            cur.next=head1;
        
        //l2 not exahusted
        if(head2!=null)
            cur.next=head2;
        
        return dummy.next;    
    }
}

/*
Merge Sot on List

https://www.youtube.com/watch?v=TzeBrDU-JaY

https://leetcode.com/problems/sort-list/#/solutions

see "java merge sot solution"
*/



