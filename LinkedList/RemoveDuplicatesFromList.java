/*
Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
 */
package interviewprep.LinkedList;

/**
 *
 * @author jakadam
 */
public class RemoveDuplicatesFromList {
    public ListNode deleteDuplicates(ListNode A) {
        
        ListNode cur=A;
        
        //sequence of operations is important
        
        //1. Check if cur is null or not
        while(cur!=null){
            
            //2. if next node is null, no point in going ahead. Break.
            if(cur.next==null)
                break;
            //3. if cur and next has same value, drop the next node
            if(cur.val==cur.next.val){
                cur.next=cur.next.next;
            }
            //4. increament the cur pointer
            else
                cur=cur.next;
        }
        return A;
    }
}
/*
Links-
https://www.interviewbit.com/problems/remove-duplicates-from-sorted-list/
Notes-
https://leetcode.com/problems/remove-duplicates-from-sorted-list/#/solutions


recursive solution
https://discuss.leetcode.com/topic/12580/3-line-recursive-solution/10
*/