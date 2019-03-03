/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
                
                if(A.get(ptrA)<B.get(ptrB))
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