/*
Merge two sorted linked lists and return it as a new list. 
The new list should be made by splicing together the nodes of the first two lists, and should also be sorted.

For example, given following linked lists :

  5 -> 8 -> 20 
  4 -> 11 -> 15
The merged list should be :

4 -> 5 -> 8 -> 11 -> 15 -> 20

 */
package interviewprep.LinkedList;

/**
 *
 * @author jakadam
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        ListNode head1=A;
        ListNode head2=B;
        
        //create a fake node and a iterator for solution list
        ListNode dummy= new ListNode(0);
        ListNode dummyCur=dummy;
        
        //corner case: if any list is empty
        if(A==null)
            return B;
        if(B==null)
            return A;
        
        //add the nodes from both the list in incrasing order to solution list
        //This ligic is the crux of merge sort
        while(head1!=null && head2!=null){
            if(head1.val<head2.val){
                dummyCur.next=head1;
                dummyCur=dummyCur.next;
                head1=head1.next;
            }
            else{
                dummyCur.next=head2;
                dummyCur=dummyCur.next;
                head2=head2.next;
            }
        }
        
        // if one of the list is exhausted, add remianing part of non-exhausted list 
        // to solution list
        if(head1==null)
            dummyCur.next=head2;
        
        
        if(head2==null)
            dummyCur.next=head1;
        
        return dummy.next;
    }
}

/*
Links-https://www.interviewbit.com/problems/merge-two-sorted-lists/

Notes-
Own Logic

try to visualize the code using 
4->null
5->null

https://discuss.leetcode.com/topic/27564/my-ac-java-solution
*/