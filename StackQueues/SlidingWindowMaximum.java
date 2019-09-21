/*
 * 
A long array A[] is given to you. There is a sliding window of size w which is moving from the very 
left of the array to the very right. You can only see the w numbers in the window. Each time the 
sliding window moves rightwards by one position. You have to find the maximum for each window. The 
following example will give you more clarity.

Example :

The array is [1 3 -1 -3 5 3 6 7], and w is 3.

Window position	Max
 	 
[1 3 -1] -3 5 3 6 7	3
1 [3 -1 -3] 5 3 6 7	3
1 3 [-1 -3 5] 3 6 7	5
1 3 -1 [-3 5 3] 6 7	5
1 3 -1 -3 [5 3 6] 7	6
1 3 -1 -3 5 [3 6 7]	7
Input: A long array A[], and a window width w
Output: An array B[], B[i] is the maximum value of from A[i] to A[i+w-1]
Requirement: Find a good optimal way to get B[i]

 Note: If w > length of the array, return 1 element with the max of the array. .
 */
package interviewprep.StackQueues;

/**
 *
 * @author jakadam
 */

import java.util.*;
public class SlidingWindowMaximum {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> slidingMaximum(final List<Integer> nums, int k) {
    ArrayList<Integer> result = new ArrayList<Integer>() ;
    
    if(nums==null||nums.size()==0)
        return result;
        
    LinkedList<Integer> deque = new LinkedList<Integer>();
    for(int i=0; i<nums.size(); i++){
        
        //remove element out of window
        if(!deque.isEmpty()&&deque.peekFirst()==i-k) 
            deque.poll();
        
        // make sure deque is in descending order
        while(!deque.isEmpty()&&nums.get(deque.peekLast())<nums.get(i)){
            deque.removeLast();
        }    
        
        //push current element to deque
        deque.offer(i);
 
        if(i+1>=k)
            result.add(nums.get(deque.peek()));
    }
 
    return result;
        
    }
}

/*
Link-
https://www.interviewbit.com/problems/sliding-window-maximum/

Notes-
*** https://www.youtube.com/watch?v=J6o_Wz-UGvc

optional

http://www.programcreek.com/2014/05/leetcode-sliding-window-maximum-java/


https://www.youtube.com/watch?v=39grPZtywyQ

http://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/
*/
