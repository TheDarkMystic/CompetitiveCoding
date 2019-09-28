/*
Find the intersection of two sorted arrays.
OR in other words,
Given 2 sorted arrays, find all the elements which occur in both the arrays.

Example :

Input : 
    A : [1 2 3 3 4 5 6]
    B : [3 3 5]

Output : [3 3 5]

Input : 
    A : [1 2 3 3 4 5 6]
    B : [3 5]

Output : [3 5]
NOTE : For the purpose of this problem ( as also conveyed by the sample case ), 
assume that elements that appear more than once in both arrays should be included multiple times 
in the final output. 
 */
package interviewprep.TwoPointers;

/**
 *
 * @author jakadam
 */

import java.util.*;
public class IntersectionOfSortedArrays {
    public ArrayList<Integer> intersect(final List<Integer> A, final List<Integer> B) {
        ArrayList<Integer> res= new ArrayList<Integer>();
        int lenA=A.size();
        int lenB=B.size();
        int ptrA=0, ptrB=0;
        
        while(ptrA<lenA && ptrB<lenB){
            int valA=A.get(ptrA);
            int valB=B.get(ptrB);
            
            if(valA==valB){
                res.add(A.get(ptrA));
                ptrA++;
                ptrB++;
            }
            else{
                
                if(valA<valB)
                    ptrA++;
                else
                    ptrB++;
            }
        }
        
        return res;
    }
}
/*
Links-
Notes-
    Code is self-explainatory
    Classic MergeSort merge technique
*/