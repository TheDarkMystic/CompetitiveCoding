/*
Merge k sorted linked lists and return it as one sorted list.

Example :

1 -> 10 -> 20
4 -> 11 -> 13
3 -> 8 -> 9
will result in

1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20
 */
package interviewprep.HeapsAndMaps;

/**
 *
 * @author jakadam
 */


import java.util.*;

 // Definition for singly-linked list.
class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
 }
 

public class mergeKSortedLists {
    public ListNode mergeKLists(ArrayList<ListNode> a) {
        /*
        
        Following is detailed algorithm.
        1. Create an output array of size n*k.
        2. Create a min heap of size k and insert 1st element in all the arrays into the heap
        3. Repeat following steps n*k times.
             a) Get minimum element from heap (minimum is always at root) and store it in output array.
             b) Replace heap root with next element from the array from which the element is extracted. 
             
             If the array doesnt have any more elements, then replace root with infinite. After replacing 
             the root, heapify the tree.
        */
        
        
        if(a==null || a.size()==0)
            return null;
            
        Queue<ListNode> heap= new PriorityQueue<ListNode>(
            new Comparator<ListNode>(){
                @Override
                public int compare(ListNode x, ListNode y){
                    if(x.val<y.val)
                        return -1;
                    else
                        if(x.val>y.val)
                            return 1;
                        else
                            return 0;
                }
            }
            
        );
            
        ListNode dummy=new ListNode(0);
        ListNode end=dummy;
        
        //put all the first nodes in the heap
        for(ListNode node : a){
            if(node!=null)
                heap.add(node);
        }
        
        while(!heap.isEmpty()){
            end.next=heap.poll();
            end=end.next;
            
            //below statement is critical
            //implements step 3b
            if(end.next!=null){
                heap.add(end.next);
            }
        }
        
        
        return dummy.next;
    }
}

/*
Link-
https://www.interviewbit.com/problems/merge-k-sorted-lists/
Note-
http://www.geeksforgeeks.org/merge-k-sorted-arrays/

https://discuss.leetcode.com/topic/2780/a-java-solution-based-on-priority-queue

*/