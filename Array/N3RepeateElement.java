/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewprep.Array;

/**
 *
 * @author jakadam
 */
import java.util.*;
public class N3RepeateElement {
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