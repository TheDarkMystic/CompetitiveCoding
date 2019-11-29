/*
 *
You are given two linked lists representing two non-negative numbers. 
The digits are stored in reverse order and each of their nodes contain a single 
digit. 
Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

    342 + 465 = 807
Make sure there are no trailing zeros in the output list
So, 7 -> 0 -> 8 -> 0 is not a valid response even though the value is still 807.
 */
package interviewprep.LinkedList;

/**
 *
 * @author jakadam
 */

import java.util.*;

public class AddTwoNumbersAsLists {
        public ListNode addTwoNumbers(ListNode a, ListNode b) {
        
        //if both lists are null
        if(a==null && b==null)
            return new ListNode(0);
        
        // create first node for ans with val=0 and next=null
        ListNode head=new ListNode(0);
        ListNode res= head;// we will return this pointer as ans
        
        
        //continue until both lists are null/ exhausted
        int carry=0;
        while(true){
            
            //apt place to use ternary operators
            int num=((a==null)? 0:a.val) +
                    ((b==null)? 0:b.val) +
                    carry;
            
            int sum=num%10;
                carry=num/10;
            
            
            head.next=new ListNode(sum);
            head=head.next;
                
            if(a!=null)
                a=a.next;
            
            if(b!=null)
                b=b.next;
            
            
            if(a==null && b==null)
                break;
        }
        
        if(carry!=0)
             head.next=new ListNode(carry);
             
    return res.next;
    }
}

/*
Links-https://www.interviewbit.com/problems/add-two-numbers-as-lists/

Notes-
Own Logic
Self-Explainatory
Use of ternary operators
*/