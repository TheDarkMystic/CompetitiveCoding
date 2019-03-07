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
public class RemoveDuplicatesFromSortedListII {
        public ListNode deleteDuplicates(ListNode A) {
        //corner case
        if(A==null || A.next==null)
            return A;
        
        
        //create head and cur for solution list
        ListNode dummy= new ListNode(0);
        ListNode dummyCur= dummy;
        
        //create cur pointer to traverse given list
        ListNode cur=A;
       
       
        //logic starts       
        while(cur!=null){
            // if duplicates are found
            if(cur.next!=null && cur.val==cur.next.val){
                while(cur.next!=null && cur.val==cur.next.val){
                    cur=cur.next;
                }
            }
            //else element is unique
            else{
                dummyCur.next=cur;
                dummyCur=dummyCur.next;
            }
            
            
            //common cur increment for both if and else
            cur=cur.next;
            
        }
        
        
        // TESTCASE: 1->2->2->null  ans:[1]
        dummyCur.next=null;
        
        
        return dummy.next;
        
    }
}

/*
Links-
https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/submissions/
https://www.interviewbit.com/problems/remove-duplicates-from-sorted-list-ii/
Notes-
Own Logic

http://www.programcreek.com/2014/06/leetcode-remove-duplicates-from-sorted-list-ii-java/

https://leetcode.com/submissions/detail/106168053/
*/