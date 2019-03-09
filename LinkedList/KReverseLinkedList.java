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
public class KReverseLinkedList {
    public ListNode reverseList(ListNode node, int B) {
        // This is a recursive solution
        // Very similar to reverse LL solution
        ListNode cur=node;
        ListNode prev=null;
        ListNode next=null;
        
        int count=B;
        // following loop will reverse B nodes starting from node cur
        // at the end of loop, 
        //prev= head of reversed list
        //node= end of reversed list
        // cur= start of next list to be reversed
        while(count-->0 && cur!=null){
            next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        
        
        // if start of next list to be reversed is not null 
        if(cur!=null){
            // make a recur call and assign returned pointer(head of next reversed list)
            // to this lists end
            node.next=reverseList(cur,B);
        }
        
        //head of this list
        return prev;
        
        
    }
}


/*
Links-https://www.interviewbit.com/problems/k-reverse-linked-list/
Notes-
Own logic
Refer Comments in the code
*/