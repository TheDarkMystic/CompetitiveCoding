/*
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
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