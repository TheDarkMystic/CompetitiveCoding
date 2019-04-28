/*
 * 
    Given an array of size n, find the majority element. The majority element is the element that appears more than floor(n/2) times.

    You may assume that the array is non-empty and the majority element always exist in the array.

    Example :

    Input : [2, 1, 2]
    Return  : 2 which occurs 2 times which is greater than 3/2. 
 */
package interviewprep.Greedy;

/**
 *
 * @author jakadam
 */
import java.util.*;
public class MajorityElement {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int majorityElement(final List<Integer> A) {
        /*
        Approach 1: 2 nested loops O(n^2), O(1)
        Approach 2: HashMap O(n), O(n)
        Approach 3: Sorting O(nlogn), O(1)
        Approach 4: Boyer-Moore voting algo O(n), O(1)
                    Step 1: find Candidate ele
                            we maintain a count,if next element is same,we increament count else we decrement the count
                            Idea is if an element is occuring more than n/2 times, we will have non-zero count in the 
                            end of 1st pass, which will give us majority ele
                    Step 2: Traverse array for confirmation, if candidate is really a majority ele
                    
        */
        
        
        int len =A.size();
        
        if(len==1)
            return A.get(0);
        
        //Step 1: Find Candidate
        int candidate=A.get(0);
        int count=1;
        for(int i=1; i<len; i++){
            if(count==0){
                candidate=A.get(i);
                count++;
            }
            else{
                if(candidate==A.get(i))
                    count++;
                else count--;
            }
        }
        
        //Step 2: Confirm Majority Element
        int count2=0;
        for(Integer num: A){
            if(num==candidate)
                count2++;
        }
        //System.out.println(count2);
        if(count2>=Math.floor(len/2))
            return candidate;
        
        return -1;
        
    }
}


/*
Link-
Notes-
https://www.youtube.com/watch?v=uwogtyFiDLg             Skip to 7:00
https://www.youtube.com/watch?v=zOyOwDEF1Rc

https://en.wikipedia.org/wiki/Boyer%E2%80%93Moore_majority_vote_algorithm
Proof of Correctness:
If there is a majority element, the algorithm will always find it. For, supposing that the majority 
element is m, let c be a number defined at any step of the algorithm to be either the counter, if the 
stored element is m, or the negation of the counter otherwise. Then at each step in which the algorithm 
encounters a value equal to m, the value of c will increase by one, and at each step at which it 
encounters a different value, the value of c may either increase or decrease by one. If m truly is the 
majority, there will be more increases than decreases, and c will be positive at the end of the 
algorithm. But this can be true only when the final stored element is m, the majority element.


*/
