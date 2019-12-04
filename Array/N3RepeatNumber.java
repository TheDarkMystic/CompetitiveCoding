/*
You’re given a read only array of n integers. Find out if any integer occurs more than n/3 times in the array in linear time and constant additional space.
If so, return the integer. If not, return -1.
If there are multiple solutions, return any one.
Example :

Input : [1 2 3 1 1]
Output : 1 
1 occurs 3 times which is more than 5/3 times. 
 */
package interviewprep.Array;

/**
 *
 * @author jakadam
 */
import java.util.*;
public class N3RepeatNumber {
    // DO NOT MODIFY THE LIST
    public int repeatedNumber(final List<Integer> a) {
        int len = a.size();

        if(a.size() == 0) {
            return -1;
        }

        if(a.size() == 1) {
            return a.get(0);
        }

        int c1 = a.get(0);
        int c2 = a.get(1);
        int c1count = 0;
        int c2count = 0;
        
        //Step 1: Find the candidates
        for(int num : a) {
            if(c1 == num) {
                c1count++;
            } else if(c2 == num) {
                c2count++;
            } else if(c1count == 0) {
                c1 = num;
                c1count = 1;
            } else if(c2count == 0) {
                c2 = num;
                c2count = 1;
            } else {
                c1count--;
                c2count--;
            }
        }
        
        //Step 2: Confirm candidates are the majority element
        c1count = 0;
        c2count = 0;
        for(int num : a) {
            if(c1 == num) {
                c1count++;
            } else if(num == c2) {
                c2count++;
            }
        }
        
        //return the ans
        if(c1count > len / 3) {
            return c1;
        } else if(c2count > len / 3) {
            return c2;
        } else {
            return -1;
        }

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

/*
*
ProblemURLs:-
I-https://www.interviewbit.com/problems/n3-repeat-number/

NOTES:
Boyer-moore algo for majority counting

https://www.youtube.com/watch?v=zOyOwDEF1Rc

n/3 variation
https://discuss.leetcode.com/topic/17396/boyer-moore-majority-vote-algorithm-generalization/5

CTRL+F :doudou900914 

n/2 algorithm variation
https://leetcode.com/problems/majority-element/#/description

soltion using Sorting is in complete solution section of IB
*/
