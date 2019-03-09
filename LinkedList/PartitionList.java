/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
*/
package interviewprep.LinkedList;

/**
 *
 * @author jakadam
 */
public class PartitionList {
     public ListNode partition(ListNode A, int B) {
        // corner case
        if(A==null || A.next==null)
            return A;
        
        // create two seperate empty lists with dummy nodes
        ListNode dummy1= new ListNode(0);
        ListNode dummy2= new ListNode(0);
        
        // cur iterators for each list
        ListNode cur1=dummy1;
        ListNode cur2=dummy2;
        
        ListNode head=A;
        
        //logic for partitioning the lists
        while(head!=null){
            
            if(head.val<B){
                cur1.next=head;
                cur1=cur1.next;
            }
            else{
                cur2.next=head;
                cur2=cur2.next;
            }
            head=head.next;
        }
        
        // join the first list to second list
        cur1.next=dummy2.next;
        // mark the last node of second list as end of ans list
        cur2.next=null;
        
        return dummy1.next;
        
    }
}
/*
Links- https://www.interviewbit.com/problems/partition-list/ 
Notes-
Own logic
optional
https://leetcode.com/problems/partition-list/discuss/29183/Concise-java-code-with-explanation-one-pass

*/
