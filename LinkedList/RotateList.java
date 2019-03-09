/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
Given a list, rotate the list to the right by k places, where k is non-negative.

For example:

Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
*/

package interviewprep.LinkedList;

/**
 *
 * @author jakadam
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode lastNode=null;
        ListNode cur=head;
        
        if(head==null || head.next==null)
            return head;
        
        int len=1;// assuming list has atleast 1 node, as head!=null above
        
        //calculate the length of the list
        // by the end of loop, cur will be pointing to the lastNode of current list
        while(cur.next!=null){
            cur=cur.next;
            len++;
        }
        
        k=k%len;
        
        // if we rotate the list lenght times, head will again become head
        if(k==0) return head;
        
        
        // connect the lastNode to head i.e., circle the list
        lastNode=cur;
        lastNode.next=head;
        
        //now, after rotating the list 'k' times (len-k)th node will be the 
        //1->2->3->4->5->NULL and k = 2, ans 4->5->1->2->3->NULL.
        //in above eg. 3 is the end node and 4 is the start node for new list
        //so we just need to adjust the pointers now as we have creatd a cyclic list
        
        // find the (len-k)th node. mark the next node as head and (len-k)th nodes next pointer to null.
        ListNode tail=head;
        for(int i=1;i<len-k;i++){
            tail=tail.next;
        }
        
        // mark the head for new list/rotated list
        head=tail.next;
        
        // mark the end of new list/rotated list
        tail.next=null;
        
        
        return head;
    }
}


/*
Links-https://www.interviewbit.com/problems/rotate-list/
Notes-
Optional
https://leetcode.com/submissions/detail/106176005/
*/